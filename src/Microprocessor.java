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
}