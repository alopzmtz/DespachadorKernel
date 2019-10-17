import java.util.*;
import java.lang.Math;

public class Proceso {

	////Variables del Proceso

	// T.E.
	private double execTime;

	// Number of times the process should block
	private double totalBlocks;

	// T.I.
	private double creationTime;

	//Variables del sistema
	private double quantumTime;
	private double blockTime;
	private double changeOfQuantumTime;

	//Variables resultantes de la lógica

	// T.F.
	private double totalTime;

	public Proceso(double quantumTime, double blockTime, double changeOfQuantumTime, double execTime, double totalBlocks, double creationTime) {
		this.quantumTime = quantumTime;
		this.blockTime = blockTime;
		this.changeOfQuantumTime = changeOfQuantumTime;
		this.execTime = execTime;
		this.totalBlocks = totalBlocks;
		this.creationTime = creationTime;
		totalTime = calculateTime();
	}

	// T.B.
	private double calculateBlocks() {
		return blockTime * totalBlocks;
	}

	// T.V.C.
	private double calculateQuantumTime() {

		double tempNumber1 = Math.ceil(execTime/quantumTime);

		return (tempNumber1 * changeOfQuantumTime) - changeOfQuantumTime;
	}

	private double calculateTime() {
		return execTime + calculateQuantumTime() + calculateBlocks();
	}

	public double getTotalTime() {
		return totalTime;
	}

	public double getCreationTime() {
		return creationTime;
	}
}