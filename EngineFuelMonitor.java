import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EngineFuelMonitor extends JFrame {
    private JProgressBar[] engineBars = new JProgressBar[4];
    private JLabel[] statusLabels = new JLabel[4];
    private int[] fuelLevels = new int[4];
    private boolean autopilotActivated = false;

    public EngineFuelMonitor() {
        setTitle("Engine Fuel Monitor");
        setSize(400, 300);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Setup fuel levels and UI
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            fuelLevels[i] = 70 + rand.nextInt(31); // 70-100

            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("Engine " + (i + 1));
            engineBars[i] = new JProgressBar(0, 100);
            engineBars[i].setValue(fuelLevels[i]);
            engineBars[i].setStringPainted(true);

            statusLabels[i] = new JLabel(getStatus(fuelLevels[i]));

            panel.add(label, BorderLayout.WEST);
            panel.add(engineBars[i], BorderLayout.CENTER);
            panel.add(statusLabels[i], BorderLayout.EAST);

            add(panel);
        }

        setVisible(true);

        // Start the simulation
        simulateFuelDrop();
    }

    private void simulateFuelDrop() {
        Timer timer = new Timer(2000, e -> {
            boolean lowFuelDetected = false;

            for (int i = 0; i < 4; i++) {
                if (fuelLevels[i] > 0) {
                    fuelLevels[i] = Math.max(0, fuelLevels[i] - new Random().nextInt(10) + 1);
                    engineBars[i].setValue(fuelLevels[i]);
                    String status = getStatus(fuelLevels[i]);
                    statusLabels[i].setText(status);

                    if (status.equals("Fuel Low") || status.equals("Critical")) {
                        lowFuelDetected = true;
                    }
                }
            }

            if (lowFuelDetected && !autopilotActivated) {
                int response = JOptionPane.showConfirmDialog(this,
                        "Fuel levels are low.\nActivate autopilot for emergency landing?",
                        "Autopilot Prompt", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    autopilotActivated = true;
                    JOptionPane.showMessageDialog(this, "Autopilot activated. Initiating landing sequence...");
                    ((Timer) e.getSource()).stop();
                } else {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Are you sure you want to continue without autopilot?",
                            "Confirm Decision", JOptionPane.YES_NO_OPTION);
                    if (confirm != JOptionPane.YES_OPTION) {
                        autopilotActivated = true;
                        JOptionPane.showMessageDialog(this, "Autopilot activated. Initiating landing sequence...");
                        ((Timer) e.getSource()).stop();
                    }
                }
            }

            // End simulation if all fuel is gone
            boolean allEmpty = true;
            for (int level : fuelLevels) {
                if (level > 0) {
                    allEmpty = false;
                    break;
                }
            }

            if (allEmpty) {
                JOptionPane.showMessageDialog(this, "All engines out of fuel. Emergency shutdown.");
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }

    private String getStatus(int fuel) {
        if (fuel >= 70) return "Good";
        else if (fuel >= 30) return "Fuel Low";
        else return "Critical";
    }

    public static void main(String[] args) {
        // PIN verification
        String pin = JOptionPane.showInputDialog(null, "Enter your 5-digit PIN:");
        if (pin == null || !pin.matches("\\d{5}")) {
            JOptionPane.showMessageDialog(null, "Invalid PIN. Program exiting.");
            return;
        }

        // Engine activation
        int activate = JOptionPane.showConfirmDialog(null,
                "Do you want to activate the engines?", "Engine Activation",
                JOptionPane.YES_NO_OPTION);
        if (activate != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Engines not activated. Program exiting.");
            return;
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> new EngineFuelMonitor());
    }
}
