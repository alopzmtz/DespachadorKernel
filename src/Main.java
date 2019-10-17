import javax.swing.*;
import javax.swing.JFileChooser;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;

public class Main extends JFrame{

	JButton simulationStart;
	JLabel titleLabel, authorA, authorB, authorC, authorD, inputA, inputB, inputC, inputD, errorMsg;
	JTextField microNumTF, quantumNumTF, ccTimeTF, blockTimeTF;

	public Main(){
		super();
		simulationStart = new JButton("Simular despachador.");
		simulationStart.setBounds(150,535,200,50);
		titleLabel = new JLabel("Despachador");
		titleLabel.setBounds(150, 30, 200, 60);
		titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		authorA = new JLabel("Rafael R. O. - A01339605");
		Font defaultFont = new Font("Calibri", 0, 14);
		authorA.setFont(defaultFont);
		authorB = new JLabel("Alejandro L. M. - A0173657");
		authorB.setFont(defaultFont);
		authorC = new JLabel("Nicole B. M. - A0165289");
		authorC.setFont(defaultFont);
		authorD = new JLabel("Alfredo Q. T. - A01337630");
		authorD.setFont(defaultFont);
		authorA.setBounds(40, 100, 150, 40);
		authorB.setBounds(40, 140, 175, 40);
		authorC.setBounds(270, 100, 150, 40);
		authorD.setBounds(270, 140, 150, 40);
		inputA = new JLabel("Numero de Microprocesadores:");
		inputA.setBounds(35, 185, 200, 70);
		inputB = new JLabel("Tamano de Quantum:");
		inputB.setBounds(35,265, 200, 70);
		inputC = new JLabel("Tiempo de Cambio de Contexto:");
		inputC.setBounds(35,345, 200, 70);
		inputD = new JLabel("Tiempo de Bloqueo:");
		inputD.setBounds(35,425, 200, 70);
		errorMsg = new JLabel("IT'S THE FINAL COUNTDOWN");
		errorMsg.setBounds(120, 620, 300, 50);
		errorMsg.setFont(new Font("Calibri", Font.BOLD, 20));
		microNumTF = new JTextField();
		microNumTF.setBounds(265, 200, 150, 40);
		quantumNumTF = new JTextField();
		quantumNumTF.setBounds(265, 280, 150, 40);
		ccTimeTF = new JTextField();
		ccTimeTF.setBounds(265, 360, 150, 40);
		blockTimeTF = new JTextField();
		blockTimeTF.setBounds(265, 440, 150, 40);
		add(simulationStart); add(titleLabel); add(authorA); add(authorB); add(authorC); add(authorD); add(inputA);
		add(inputB);add(inputC); add(inputD);add(errorMsg);add(microNumTF);add(quantumNumTF);add(ccTimeTF);add(blockTimeTF);
		simulationStart.addActionListener(new SimulationListener());
		getContentPane().setBackground(new Color(211,240,219));
		setSize(500,750);
		setLayout(null);
		setVisible(true);
	}

	private class SimulationListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			errorMsg.setText("Whoo button was pressed yay!");
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}