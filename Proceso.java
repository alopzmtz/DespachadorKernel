public class Proceso {

	////Variables del Proceso
	private int execTime;
	private int totalBlocks;
	private int creationTime;

	//Variables del sistema
	private int quantumTime;
	private int blockTime;
	private int changeOfQuantumTime;

	//Variables resultantes de la lógica
	private int totalQuantums;

	public Proceso(int quantumTime, int blockTime, int changeOfQuantumTime, int execTime, int totalBlocks, int creationTime) {
		this.quantumTime = quantumTime;
		this.blockTime = blockTime;
		this.changeOfQuantumTime = changeOfQuantumTime;
		this.execTime = execTime;
		this.totalBlocks = totalBlocks;
		this.creationTime = creationTime;
	}

	



}