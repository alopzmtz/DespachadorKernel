import java.util.*;
import java.lang.Math;

public class Proceso {

    ////Variables del Proceso
    private String processID;

    // T.E.
    private int execTime;

    // Number of times the process should block
    private int totalBlocks;

    // T.I.
    private int creationTime;

    // T.C.C
	private int changeOfContextTime;

    //Variables del sistema
    private int quantumTime;
    private int blockTime;
    private int changeOfQuantumTime;

    //Variables resultantes de la lógica

    // T.F.
    private int totalTime;

    public Proceso(String processID, int changeOfContextTime, int quantumTime, int blockTime, int changeOfQuantumTime, int execTime, int totalBlocks, int creationTime) {
        this.processID = processID;
        this.changeOfContextTime = changeOfContextTime;
    	this.quantumTime = quantumTime;
        this.blockTime = blockTime;
        this.changeOfQuantumTime = changeOfQuantumTime;
        this.execTime = execTime;
        this.totalBlocks = totalBlocks;
        this.creationTime = creationTime;
        totalTime = calculateTime();
    }

    // T.B.
    private int calculateBlocks() {
        return blockTime * totalBlocks;
    }

    // T.V.C.
    private int calculateQuantumTime() {
        return ((execTime / quantumTime) * changeOfQuantumTime);
    }

    private int calculateTime() {
        return changeOfContextTime + execTime + calculateQuantumTime() + calculateBlocks();
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getFinalTime() {
    	return totalTime + creationTime;
	}

    public int getCreationTime() {
        return creationTime;
    }

    public String getProcessName(){
        return processID;
    }
}
