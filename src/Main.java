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
		simulationStart.setBounds(200,550,200,50);
		titleLabel = new JLabel("Despachador");
		titleLabel.setBounds(150, 30, 200, 60);
		authorA = new JLabel("Rafael R. O. - A01339605");
		authorB = new JLabel("Alejandro L. M. - A0173657");
		authorC = new JLabel("Nicole B. M. - A0165289");
		authorD = new JLabel("Alfredo Q. T. - A01337630");
		authorA.setBounds(20, 100, 150, 40);
		authorB.setBounds(20, 150, 150, 40);
		authorC.setBounds(250, 100, 150, 40);
		authorD.setBounds(250, 150, 150, 40);
		inputA = new JLabel("Numero de Microprocesadores:");
		inputA.setBounds(20, 200, 200, 70);
		inputB = new JLabel("Tamano de Quantum:");
		inputB.setBounds(20,280, 200, 70);
		inputC = new JLabel("Tiempo de Cambio de Contexto:");
		inputC.setBounds(20,360, 200, 70);
		inputD = new JLabel("Tiempo de Bloqueo:");
		inputD.setBounds(20,440, 200, 70);
		errorMsg = new JLabel("IT'S THE FINAL COUNTDOWN");
		errorMsg.setBounds(150, 650, 250, 60);
		microNumTF = new JTextField();
		microNumTF.setBounds(250, 200, 150, 40);
		quantumNumTF = new JTextField();
		quantumNumTF.setBounds(250, 280, 150, 40);
		ccTimeTF = new JTextField();
		ccTimeTF.setBounds(250, 360, 150, 40);
		blockTimeTF = new JTextField();
		blockTimeTF.setBounds(250, 440, 150, 40);
		add(simulationStart); add(titleLabel); add(authorA); add(authorB); add(authorC); add(authorD); add(inputA);
		add(inputB);add(inputC); add(inputD);add(errorMsg);add(microNumTF);add(quantumNumTF);add(ccTimeTF);add(blockTimeTF);
		simulationStart.addActionListener(new SimulationListener());
		getContentPane().setBackground(new Color(111,188,240));
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