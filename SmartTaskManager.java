package cia;

import java.util.*;

public class SmartTaskManager {

	static Scanner sc = new Scanner(System.in);

	// Array to store all tasks
	static String[] allTasks = new String[100];
	static int taskCount = 0;

	// Queue for pending tasks
	static Queue<String> taskQueue = new LinkedList<>();
    
	// Stack for undo
	static Stack<String> undoStack = new Stack<>();

	public static void main(String[] args) {
		
		while (true) {
            System.out.println("\n--- Smart Task Management ---");
            System.out.println("1. Add Task");
            System.out.println("2. Process Task");
            System.out.println("3. Undo Last Task");
            System.out.println("4. Display Pending Tasks");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> processTask();
                case 3 -> undoTask();
                case 4 -> displayTasks();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task name: ");
        String task = sc.nextLine();

        allTasks[taskCount++] = task;
        taskQueue.add(task);

        System.out.println("Task added successfully!");
    }

    static void processTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No pending tasks!");
            return;
        }

        String task = taskQueue.poll();
        undoStack.push(task);

        System.out.println("Processed Task: " + task);
    }

    static void undoTask() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        String task = undoStack.pop();
        taskQueue.add(task);

        System.out.println("Undo successful: " + task);
    }

    static void displayTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No pending tasks!");
            return;
        }

        System.out.println("Pending Tasks:");
        for (String t : taskQueue) {
            System.out.println("- " + t);
        }
	}

}
