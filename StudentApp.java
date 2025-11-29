import javax.swing.*;
import java.util.ArrayList;

public class StudentApp {
    // List to store student info
    static class Student {
        String name;
        String id;
        String confirmationNumber;

        public Student(String name, String id, String confirmationNumber) {
            this.name = name;
            this.id = id;
            this.confirmationNumber = confirmationNumber;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", ID: " + id + ", Confirmation Number: " + confirmationNumber;
        }
    }

    // List of students for each class
    static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            // Get user input
            String name = JOptionPane.showInputDialog("Enter student name:");
            if (name == null || name.isEmpty()) {
                break; // Exit if the user cancels or doesn't enter anything
            }

            String idNumber = JOptionPane.showInputDialog("Enter student ID (e.g., B-01375):");
            if (idNumber == null || !isValidID(idNumber)) {
                JOptionPane.showMessageDialog(null, "Invalid ID number. Please enter a valid ID.");
                continue; // If invalid, re-enter details
            }

            String confirmationNumber = JOptionPane.showInputDialog("Enter confirmation number (e.g., 019-A1):");
            if (confirmationNumber == null || !isValidConfirmationNumber(confirmationNumber)) {
                JOptionPane.showMessageDialog(null, "Invalid confirmation number. Please enter a valid confirmation number.");
                continue;
            }

            // Process confirmation number based on name
            String formattedConfirmation = generateConfirmationNumber(name);

            // Save student details
            studentsList.add(new Student(name, idNumber, formattedConfirmation));

            // Display success message
            JOptionPane.showMessageDialog(null, "Student added successfully!");

            // Ask if they want to add another student
            int option = JOptionPane.showConfirmDialog(null, "Do you want to add another student?", "Continue", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Display all students added
        StringBuilder studentList = new StringBuilder("Students List:\n");
        for (Student student : studentsList) {
            studentList.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, studentList.toString());
    }

    // Method to generate confirmation number
    private static String generateConfirmationNumber(String name) {
        char firstLetter = name.toUpperCase().charAt(0);
        int number = firstLetter - 'A' + 1;
        return String.format("%03d-%s%d", number, String.valueOf(firstLetter), number);
    }

    // Check if the ID number is valid (e.g., B-01375)
    private static boolean isValidID(String id) {
        return id.matches("^[A-Z]-\\d{5}$");
    }

    // Check if the confirmation number is valid (e.g., 019-A1)
    private static boolean isValidConfirmationNumber(String confirmation) {
        return confirmation.matches("^\\d{3}-[A-Z]\\d$");
    }
}
