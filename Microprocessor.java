import java.util.*;

public class Microprocessor{

    private int id;
    private boolean startState;
    private List<Process> processes = new ArrayList<Process>();
    private int time;


    public Microprocessor(int id){

        this.startState = true;
        this.time = 0;
        this.id = id;

    }

    //getters
    public int getId(){
        return id;
    }

    public boolean getStartState(){
        return startState;
    }

    public List<Process> getProcesses(){
        return processes;
    }

    public int getTime(){
        return time;
    }

    //setters

    public void setId(int id){
        this.id = id;
    }

    public void setStartState(boolean startState){
        this.startState = startState;
    }

    public void setProcesses(List<Process> processes){
        this.processes = processes;
    }

    public void setTime(int time){
        this.time = time;
    }

    //adds a process to the list and updates the final time
    public void addProcess(Process process, int tCC){
        processes.add(process);
        this.time = time + process.getTotalTime();
        if(!state){
            this.time +=10;
        }
    }
}