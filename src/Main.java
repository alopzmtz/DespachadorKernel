import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

	private static final List<Process> processes = new ArrayList<>();

	private Main() {
        super();

		JButton simulationStart = new JButton("Simular despachador.");
        simulationStart.setBounds(150, 535, 200, 50);
		JLabel titleLabel = new JLabel("Despachador");
        titleLabel.setBounds(150, 30, 200, 60);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		JLabel authorA = new JLabel("Rafael R. O. - A01339605");
        Font defaultFont = new Font("Calibri", 0, 14);
        authorA.setFont(defaultFont);
		JLabel authorB = new JLabel("Alejandro L. M. - A0173657");
        authorB.setFont(defaultFont);
		JLabel authorC = new JLabel("Nicole B. M. - A0165289");
        authorC.setFont(defaultFont);
		JLabel authorD = new JLabel("Alfredo Q. T. - A01337630");
        authorD.setFont(defaultFont);
        authorA.setBounds(40, 100, 150, 40);
        authorB.setBounds(40, 140, 175, 40);
        authorC.setBounds(270, 100, 150, 40);
        authorD.setBounds(270, 140, 150, 40);
		JLabel inputA = new JLabel("Numero de Microprocesadores:");
        inputA.setBounds(35, 185, 200, 70);
		JLabel inputB = new JLabel("Tamano de Quantum:");
        inputB.setBounds(35, 265, 200, 70);
		JLabel inputC = new JLabel("Tiempo de Cambio de Contexto:");
        inputC.setBounds(35, 345, 200, 70);
		JLabel inputD = new JLabel("Tiempo de Bloqueo:");
        inputD.setBounds(35, 425, 200, 70);
		JLabel errorMsg = new JLabel("PLACEHOLDER TEXT");
        errorMsg.setBounds(120, 620, 300, 50);
        errorMsg.setFont(new Font("Calibri", Font.BOLD, 20));
		JTextField microNumTF = new JTextField();
        microNumTF.setBounds(265, 200, 150, 40);
		JTextField quantumNumTF = new JTextField();
        quantumNumTF.setBounds(265, 280, 150, 40);
		JTextField ccTimeTF = new JTextField();
        ccTimeTF.setBounds(265, 360, 150, 40);
		JTextField blockTimeTF = new JTextField();
        blockTimeTF.setBounds(265, 440, 150, 40);
        add(simulationStart);
        add(titleLabel);
        add(authorA);
        add(authorB);
        add(authorC);
        add(authorD);
        add(inputA);
        add(inputB);
        add(inputC);
        add(inputD);
        add(errorMsg);
        add(microNumTF);
        add(quantumNumTF);
        add(ccTimeTF);
        add(blockTimeTF);
		ActionListener mSimulationStartActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

			}
		};
		simulationStart.addActionListener(mSimulationStartActionListener);
        getContentPane().setBackground(new Color(211, 240, 219));
        setSize(500, 750);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}