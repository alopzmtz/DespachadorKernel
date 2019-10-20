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

}
