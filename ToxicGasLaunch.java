import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToxicGasLaunch {

    // Canister status: Active, Inactive, or Damaged
    private static String[] canisterStatus = {"Inactive", "Inactive", "Inactive", "Inactive", "Inactive", "Inactive"};
    
    // Toxic Gas Level for each canister (percentage for each canister)
    private static int[] toxicGasLevels = {100, 100, 100, 100, 100, 100}; 
    
    private static int canisterIntegrity = 100; // Canister Integrity (in percentage)
    private static int countdownTime; // Countdown time in seconds
    private static boolean gasReleased = false; // Flag to check if gas has been released

    public static void main(String[] args) {
        while (true) {
            // Ask the user to select a canister
            String canisterChoice = JOptionPane.showInputDialog("Which canister do you want to activate? (1, 2, 3, 4, 5, or 6):");

            // Validate canister choice
            if (canisterChoice == null || !canisterChoice.matches("[1-6]")) {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please select canister 1, 2, 3, 4, 5, or 6.");
                continue;
            }

            int canisterIndex = Integer.parseInt(canisterChoice) - 1;

            // Check canister status
            if (canisterStatus[canisterIndex].equals("Damaged")) {
                JOptionPane.showMessageDialog(null, "Canister " + (canisterIndex + 1) + " is damaged and cannot be activated.");
                continue;
            }

            // Ask if the user wants to activate the selected canister
            int activateChoice = JOptionPane.showConfirmDialog(null, "Do you want to activate Canister " + (canisterIndex + 1) + "?",
                    "Activate Canister", JOptionPane.YES_NO_OPTION);
            if (activateChoice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Canister activation aborted.");
                continue;
            }

            // Activate the canister
            canisterStatus[canisterIndex] = "Active";
            JOptionPane.showMessageDialog(null, "Canister " + (canisterIndex + 1) + " is now activated.");

            // Ask for ID and PIN before starting the countdown
            String userID = JOptionPane.showInputDialog("Enter your ID:");
            if (userID == null || userID.isEmpty()) {
                break;
            }

            String pin = JOptionPane.showInputDialog("Enter Confirmation PIN:");
            if (pin == null || pin.length() != 4) {
                JOptionPane.showMessageDialog(null, "Invalid PIN! Please enter a 4-digit PIN.");
                continue;
            }

            // Validate PIN (simple check for demo purposes)
            if (!pin.equals("0528")) {
                JOptionPane.showMessageDialog(null, "Invalid PIN. Access Denied.");
                continue;
            }

            // Ask for countdown time
            String countdownInput = JOptionPane.showInputDialog("Enter countdown time in seconds (min 10 seconds):");
            try {
                countdownTime = Integer.parseInt(countdownInput);
                if (countdownTime < 10) {
                    JOptionPane.showMessageDialog(null, "Countdown time must be at least 10 seconds.");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid time input.");
                continue;
            }

            // Ask for confirmation before starting countdown
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to launch the toxic gas?", "Confirm Launch", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Launch aborted.");
                continue;
            }

            // Start Countdown Timer
            startCountdown();
        }
    }

    private static void startCountdown() {
        // Create a JFrame for displaying the countdown and the canister status
        JFrame frame = new JFrame("Toxic Gas Countdown");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        panel.add(textArea);

        // Display initial status
        updateStatus(textArea);

        // Create the Cancel button
        JButton cancelButton = new JButton("Cancel Countdown");
        panel.add(cancelButton);

        // Action Listener for canceling the countdown
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Countdown canceled.");
                frame.dispose(); // Close the countdown window
            }
        });

        // Set up the frame
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Countdown logic with gas depletion
        Timer timer = new Timer(1000, new ActionListener() {
            int remainingTime = countdownTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update countdown every second
                if (remainingTime > 0) {
                    remainingTime--;
                    for (int i = 0; i < toxicGasLevels.length; i++) {
                        if (canisterStatus[i].equals("Active") && toxicGasLevels[i] > 0) {
                            toxicGasLevels[i]--; // Decrease toxic gas level for each active canister
                        }
                    }

                    textArea.setText("Countdown: " + remainingTime + " seconds remaining\n" +
                            "Canister Integrity: " + canisterIntegrity + "%\n" +
                            displayCanisterStatuses());
                } else {
                    // When countdown reaches zero, release the gas
                    gasReleased = true;
                    textArea.setText("Toxic gas has been released!\n" +
                            "Canister Integrity: " + canisterIntegrity + "%\n" +
                            displayCanisterStatuses());
                    ((Timer) e.getSource()).stop(); // Stop the timer
                    updateCanisterStatus(); // Update canister status after release
                }
            }
        });

        timer.start(); // Start the countdown timer
    }

    private static void updateStatus(JTextArea textArea) {
        textArea.setText("Countdown: " + countdownTime + " seconds\n" +
                "Canister Integrity: " + canisterIntegrity + "%\n" +
                displayCanisterStatuses());
    }

    private static void updateCanisterStatus() {
        // Simulate canister integrity and gas level changes after release
        canisterIntegrity -= 10; // Decrease integrity after releasing gas
    }

    private static String displayCanisterStatuses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < canisterStatus.length; i++) {
            sb.append("Canister " + (i + 1) + ": " + canisterStatus[i] + ", " +
                    "Toxic Gas Level: " + toxicGasLevels[i] + "%\n");
        }
        return sb.toString();
    }
}
