import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame {

    // Hardcoded processes list
    private static List<Process> processes = Arrays.asList(
            new Process("B", 300, 2, 0),
            new Process("D", 100, 2, 0),
            new Process("F", 500, 3, 0),
            new Process("H", 700, 4, 0),
            new Process("J", 300, 2, 1500),
            new Process("L", 3000, 5, 1500),
            new Process("N", 50, 2, 1500),
            new Process("O", 600, 3, 1500),
            new Process("A", 400, 2, 3000),
            new Process("C", 50, 2, 3000),
            new Process("E", 1000, 5, 3000),
            new Process("G", 10, 2, 3000),
            new Process("I", 450, 3, 3000),
            new Process("K", 100, 2, 4000),
            new Process("M", 80, 2, 4000),
            new Process("P", 800, 4, 4000),
            new Process("Ñ", 500, 3, 8000)
    );

    private ActionListener mSimulationStartActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // Get inputs for the kernel
            try {
                int microsNumber = Integer.parseInt(mMicroNumTF.getText());
                int quantumTime = Integer.parseInt(mQuantumTimeTF.getText());
                int contextChangeTime = Integer.parseInt(mCcTimeTF.getText());
                int lockTime = Integer.parseInt(mLockTimeTF.getText());

                Kernel kernel = new Kernel(
                        processes,
                        microsNumber,
                        quantumTime,
                        contextChangeTime,
                        lockTime
                );

                // Process the kernel
                kernel.process();

                // The micros will now contain the processes
                System.out.println(kernel.getMicroprocessors());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    };

    private JTextField mMicroNumTF;
    private JTextField mQuantumTimeTF;
    private JTextField mCcTimeTF;
    private JTextField mLockTimeTF;

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
        mMicroNumTF = new JTextField();
        mMicroNumTF.setBounds(265, 200, 150, 40);
        mQuantumTimeTF = new JTextField();
        mQuantumTimeTF.setBounds(265, 280, 150, 40);
        mCcTimeTF = new JTextField();
        mCcTimeTF.setBounds(265, 360, 150, 40);
        mLockTimeTF = new JTextField();
        mLockTimeTF.setBounds(265, 440, 150, 40);
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
        add(mMicroNumTF);
        add(mQuantumTimeTF);
        add(mCcTimeTF);
        add(mLockTimeTF);
        simulationStart.addActionListener(mSimulationStartActionListener);
        getContentPane().setBackground(new Color(211, 240, 219));
        setSize(500, 750);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Initialize the processes list

        new Main();
    }
}