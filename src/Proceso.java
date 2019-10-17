import java.util.*;
import java.lang.Math;

public class Proceso {

	////Variables del Proceso
	private double execTime;
	private double totalBlocks;
	private double creationTime;

	//Variables del sistema
	private double quantumTime;
	private double blockTime;
	private double changeOfQuantumTime;

	//Variables resultantes de la lógica
	private double tempTime;

	public Proceso(double quantumTime, double blockTime, double changeOfQuantumTime, double execTime, double totalBlocks, double creationTime) {
		this.quantumTime = quantumTime;
		this.blockTime = blockTime;
		this.changeOfQuantumTime = changeOfQuantumTime;
		this.execTime = execTime;
		this.totalBlocks = totalBlocks;
		this.creationTime = creationTime;

		tempTime = calculateTime();

	}

	private double calculateBlocks() {

		double totalBlockTime = blockTime * totalBlocks;
		return totalBlockTime;
	}

	private double calculateQuantumTime() {

		double tempNumber1 = Math.ceil(execTime/quantumTime);
		double tempNumber = (tempNumber1 * changeOfQuantumTime) - changeOfQuantumTime;

		return tempNumber;
	}

	private double calculateTime() {
		double tempTime1 = execTime + calculateQuantumTime() + calculateBlocks();
		return tempTime1;
	}

	public double getTime() {
		return tempTime;
	}

}