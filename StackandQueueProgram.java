import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackandQueueProgram{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user if they want a stack or queue
        System.out.print("Would you like to work with a stack or a queue? (Enter 'stack' or 'queue'): ");
        String choice = scanner.nextLine();

        // Ask for array size
        System.out.print("Enter the array size (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Stack or Queue logic
        if (choice.equalsIgnoreCase("stack")) {
            Stack<Integer> stack = new Stack<>();
            while (true) {
                System.out.print("Would you like to push or pop? (Enter 'push' or 'pop'): ");
                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("push")) {
                    if (stack.size() < n) {
                        System.out.print("Enter an integer value to push: ");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        stack.push(value);
                    } else {
                        System.out.println("Stack is full. You cannot push more elements.");
                    }
                } else if (action.equalsIgnoreCase("pop")) {
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                }

                System.out.print("Do you want to continue? (yes to continue, no to end): ");
                String continueAction = scanner.nextLine();

                if (continueAction.equalsIgnoreCase("no")) {
                    System.out.println("Final stack: " + stack);
                    break;
                }
            }
        } else if (choice.equalsIgnoreCase("queue")) {
            Queue<Integer> queue = new LinkedList<>();
            while (true) {
                System.out.print("Would you like to enqueue or dequeue? (Enter 'enqueue' or 'dequeue'): ");
                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("enqueue")) {
                    if (queue.size() < n) {
                        System.out.print("Enter an integer value to enqueue: ");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        queue.offer(value);
                    } else {
                        System.out.println("Queue is full. You cannot enqueue more elements.");
                    }
                } else if (action.equalsIgnoreCase("dequeue")) {
                    if (!queue.isEmpty()) {
                        System.out.println("Dequeued element: " + queue.poll());
                    } else {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                }

                System.out.print("Do you want to continue? (yes to continue, no to end): ");
                String continueAction = scanner.nextLine();

                if (continueAction.equalsIgnoreCase("no")) {
                    System.out.println("Final queue: " + queue);
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice. Please restart the program and enter 'stack' or 'queue'.");
        }

        scanner.close();
    }
}
