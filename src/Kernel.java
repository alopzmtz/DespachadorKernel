import java.util.ArrayList;
import java.util.List;

public class Kernel {

    // Map id to microprocessor
    private List<Microprocessor> mMicroprocessors;
    private List<Process> mProcesses;
    private int mQuantumTime;
    private int mContextChangeTime;
    private int mLockTime;

    public Kernel(List<Process> processes, int microsNumber, int quantumTime, int contextChangeTime, int lockTime) {
        // Create microprocessors
        mMicroprocessors = new ArrayList<>();
        for (int i = 0; i < microsNumber; ++i) {
            mMicroprocessors.add(new Microprocessor(i));
        }
        mProcesses = processes;
        mQuantumTime = quantumTime;
        mContextChangeTime = contextChangeTime;
        mLockTime = lockTime;
    }

    // After calling this, the micros will contain the processed
    public void process() {
        // Go through each process
        for (int i = 0; i < mProcesses.size(); ++i) {
            Process current = mProcesses.get(i);
            assignProcessToMicro(current);
        }

        // Remove all the holes at the end
        for (Microprocessor microprocessor: mMicroprocessors) {
            if (microprocessor.getProcesses().size() > 0) {
                Process last = microprocessor
                        .getProcesses()
                        .get(microprocessor.getProcesses().size() - 1);
                while (microprocessor.getProcesses().size() > 0 && last.isHole()) {
                    microprocessor.removeProcess(last);
                    if (microprocessor.getProcesses().size() > 0) {
                        last = microprocessor
                                .getProcesses()
                                .get(microprocessor.getProcesses().size() - 1);
                    }
                }
            }
        }
    }

    private void assignProcessToMicro(Process current) {
        // The micro that will contain the process
        Microprocessor leastUsed = mMicroprocessors.get(getMinUsedTimeMicroIndex());
        // Check if we need holes
        if (belowThreshold(leastUsed, current.getMinimumStartTime())) {
            fillMicrosWithHole(current.getMinimumStartTime());
        }

        // Create a copy of the process to be inserted so we don't modify input
        Process processIn = new Process(
                current.getProcessId(),
                current.getExecutionTime(),
                current.getLocksNumber(),
                current.getMinimumStartTime()
        );

        // T.C.C. should be 0 after a hole or if the processes in the micro are empty
        if (leastUsed.getProcesses().size() == 0
                || leastUsed.getProcesses().get(leastUsed.getProcesses().size() - 1).isHole()) {
            processIn.setChangeOfContextTime(0);
        } else {
            processIn.setChangeOfContextTime(mContextChangeTime);
        }

        // Set T.V.C.
        processIn.setTVC(calculateTVC(processIn.getExecutionTime()));
        // Set T.B.
        processIn.setLockTime(processIn.getLocksNumber() * mLockTime);
        // Set T.I. with the previous used time of the micro
        processIn.setInitialTime(leastUsed.getUsedTime());

        // Add the process to the micros list
        leastUsed.addProcess(processIn);
    }

    // Fills the micros with a hole if the used time is below the threshold
    private void fillMicrosWithHole(int threshold) {
        for (Microprocessor microprocessor : mMicroprocessors) {
            if (belowThreshold(microprocessor, threshold)) {
                // Create a hole
                Process hole = new Process(
                        threshold - microprocessor.getUsedTime(),
                        microprocessor.getUsedTime()
                );

                microprocessor.addProcess(hole);
            }
        }
    }

    // Checks if a micro used time is below a threshold
    private boolean belowThreshold(Microprocessor microprocessor, int threshold) {
        return microprocessor.getUsedTime() < threshold;
    }

    private int getMinUsedTimeMicroIndex() {
        int min = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < mMicroprocessors.size(); ++i) {
            Microprocessor current = mMicroprocessors.get(i);
            if (current.getUsedTime() < min) {
                min = current.getUsedTime();
                result = i;
            }
        }

        return result;
    }

    private int calculateTVC(int executionTime) {
        return (((int) Math.ceil((double) executionTime / (double) mQuantumTime)) - 1) * mContextChangeTime;
    }

    public List<Microprocessor> getMicroprocessors() {
        return mMicroprocessors;
    }
}
