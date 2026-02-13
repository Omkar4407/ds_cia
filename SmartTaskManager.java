package cia;

import java.util.*;

public class SmartTaskManager {
    // A Scanner object will be taking input from user
	static Scanner sc = new Scanner(System.in);

	// An Array to store the tasks entered by the user
	static String[] allTasks = new String[100];
	static int taskCount = 0;

	// A Queue which will store the pending tasks of the user (First in - First out method)
	static Queue<String> taskQueue = new LinkedList<>();
    
	// This stack will store processed task which be later useful for undo of operations (Last in - First out method)
	static Stack<String> undoStack = new Stack<>();

	public static void main(String[] args) {
		
        // A loop which will display a menu in front of the user until the user hits exit
		while (true) {
            System.out.println("\n--- Smart Task Management ---");
            System.out.println("1. Add Task");
            System.out.println("2. Process Task");
            System.out.println("3. Undo Last Task");
            System.out.println("4. Display Pending Tasks");
            System.out.println("5. Exit");

            // This reads the user's choice
            int choice = sc.nextInt();
            sc.nextLine();

            // A switch case is used to perform the selected operation by the user
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
    // Adds a new task
    static void addTask() {
        System.out.print("Enter task name: ");
        String task = sc.nextLine();

        allTasks[taskCount++] = task; // stores the task in the array
        taskQueue.add(task);  // adds the task to queue for processing later

        System.out.println("Task added successfully!");
    }
    // processes a task
    static void processTask() {
        // checks if there are no pending tasks
        if (taskQueue.isEmpty()) {
            System.out.println("No pending tasks!");
            return;
        }

        // removes task from the queue (FIFO rule)
        String task = taskQueue.poll();
        // pushes the processed task into the stack for undo operation later (LIFO rule)
        undoStack.push(task);

        System.out.println("Processed Task: " + task);
    }
    // undo the last processed task
    static void undoTask() {
        // checks if the stack is empty for undo operation
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        
        // pops the last processed task
        String task = undoStack.pop();
        // adds it back to the queue
        taskQueue.add(task);

        System.out.println("Undo successful: " + task);
    }
    // displays all pending tasks
    static void displayTasks() {
        // checks if all tasks are processed
        if (taskQueue.isEmpty()) {
            System.out.println("No pending tasks!");
            return;
        }

        // iterates through the queue and prints all the pending tasks
        System.out.println("Pending Tasks:");
        for (String t : taskQueue) {
            System.out.println("- " + t);
        }
	}

}
