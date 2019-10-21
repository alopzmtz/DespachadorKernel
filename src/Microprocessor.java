import java.util.*;

public class Microprocessor {

    private int mId;
    private List<Process> mProcesses;
    private int mUsedTime;

    public Microprocessor(int id) {
        mId = id;
        mProcesses = new ArrayList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<Process> getProcesses() {
        return mProcesses;
    }

    public void setProcesses(List<Process> processes) {
        mProcesses = processes;
    }

    public int getUsedTime() {
        return mUsedTime;
    }

    public void setUsedTime(int currentTime) {
        mUsedTime = currentTime;
    }

    public void addProcess(Process process) {
        // Update used time
        mUsedTime = process.getFinalTime();
        // Add process to the list
        mProcesses.add(process);
    }

    public void removeProcess(Process process) {
        mUsedTime = process.getInitialTime();
        mProcesses.remove(process);
    }

    @Override
    public String toString() {
        return "Micro Id = " + mId
                + " Used Time = " + mUsedTime
                + " Processes = " + mProcesses;
    }
}