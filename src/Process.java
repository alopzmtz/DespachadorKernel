public class Process {

    private String mProcessId;
    private int mExecutionTime;
    private int mLocksNumber;
    private int mLockTime;
    private int mTVC;
    private int mChangeOfContextTime;
    private int mInitialTime;
    private int mMinimumStartTime;
    private boolean mIsHole;

    public Process(String processId, int executionTime, int locksNumber, int minimumStartTime) {
        mProcessId = processId;
        mExecutionTime = executionTime;
        mLocksNumber = locksNumber;
        mMinimumStartTime = minimumStartTime;
        mIsHole = false;
    }

    // Applies for a hole
    public Process(int executionTime, int initialTime) {
        mProcessId = "Hueco";
        mExecutionTime = executionTime;
        mIsHole = true;
        mInitialTime = initialTime;
    }

    // T.B.
    public int getLockTime() {
        return mLockTime;
    }

    public void setLockTime(int lockTime) {
        mLockTime = lockTime;
    }

    // T.E.
    public int getExecutionTime() {
        return mExecutionTime;
    }

    // T.V.C.
    public int getTVC() {
        return mTVC;
    }

    public void setTVC(int tvc) {
        mTVC = tvc;
    }

    // T.C.C.
    public int getChangeOfContextTime() {
        return mChangeOfContextTime;
    }

    public void setChangeOfContextTime(int changeOfContextTime) {
        mChangeOfContextTime = changeOfContextTime;
    }

    // T.I.
    public int getInitialTime() {
        return mInitialTime;
    }

    public void setInitialTime(int initialTime) {
        mInitialTime = initialTime;
    }

    // T.T.
    public int getTotalTime() {
        return mChangeOfContextTime + mExecutionTime + mTVC + mLockTime;
    }

    // T.F.
    public int getFinalTime() {
        return getTotalTime() + mInitialTime;
    }

    public boolean isIsHole() {
        return mIsHole;
    }

//    // T.V.C.
//    private int calculateQuantumTime() {
//        return ((execTime / quantumTime) * changeOfQuantumTime);
//    }
//

}
