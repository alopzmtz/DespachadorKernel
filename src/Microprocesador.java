import java.util.*;

public class Microprocesador{

    private int id;
    private boolean startState;
    private List<Proceso> processes; 
    private double time;


    public Microprocesador(int id){

        this.startState = true;
        this.time = 0;
        this.id = id;
        this.processes = new ArrayList<Proceso>();

    }

    //getters
    public int getId(){
        return id;
    }

    public boolean getStartState(){
        return startState;
    }

    public List<Proceso> getProcesses(){
        return processes;
    }

    public double getTime(){
        return time;
    }

    //setters

    public void setId(int id){
        this.id = id;
    }

    public void setStartState(boolean startState){
        this.startState = startState;
    }

    public void setProcesses(List<Proceso> processes){
        this.processes = processes;
    }

    public void setTime(double time){
        this.time = time;
    }

    //adds a process to the list and updates the final time
    public void addProcess(Proceso process, int tCC){
        processes.add(process);
        this.time = time + process.getTotalTime();
        if(startState == false){
            this.time +=10;
        }
        

    }
}