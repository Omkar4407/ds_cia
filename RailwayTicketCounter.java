package cia;
import java.util.*;

public class RailwayTicketCounter {
    // A Scanner object will be taking input from user
	static Scanner sc = new Scanner(System.in);

	// A Queue which will store the customers' waiting list for tickets (First in - First out method)
	static Queue<String> customerQueue = new LinkedList<>();

	// A Stack for storing cancelled tickets (Last in - First out method)
	static Stack<String> cancelledTickets = new Stack<>();
    
	// An Array for storing the issued tickets
	static String[] tickets = new String[100];
	static int ticketCount = 0; // keeps the count of number of tickets issued

	public static void main(String[] args) {
		
        // A loop which will display a menu in front of the user until the user hits exit
		while (true) {
            System.out.println("\n--- Railway Ticket Counter ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Cancel Last Ticket");
            System.out.println("4. Display Waiting List");
            System.out.println("5. Exit");

            // This reads the user's choice
            int choice = sc.nextInt();
            sc.nextLine();

            // A switch case is used to perform the selected operation by the user
            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> serveCustomer();
                case 3 -> cancelTicket();
                case 4 -> displayQueue();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // adds a customer to the queue
    static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine(); // reads the customers' name

        // adds the customer to the queue
        customerQueue.add(name);
        System.out.println("Customer added to queue!");
    }

    // issues a ticket to the customer
    static void serveCustomer() {
        // checks if there are no customers
        if (customerQueue.isEmpty()) {
            System.out.println("No customers!");
            return;
        }

        // removes the customer from the queue who got the ticket issued
        String customer = customerQueue.poll();
        // stored the issued ticket in array for cancellation later
        tickets[ticketCount++] = customer;

        System.out.println("Ticket issued to: " + customer);
    }

    // cancels the last issued ticket
    static void cancelTicket() {
        // checks if issued tickets exists
        if (ticketCount == 0) {
            System.out.println("No tickets to cancel!");
            return;
        }

        // cancels the last issued ticket
        String cancelled = tickets[--ticketCount];
        // pushes the cancelled ticket into the stack
        cancelledTickets.push(cancelled);

        System.out.println("Cancelled ticket of: " + cancelled);
    }

    // displays the waiting customers' queue
    static void displayQueue() {
        // checks if there are no waiting customers
        if (customerQueue.isEmpty()) {
            System.out.println("No waiting customers!");
            return;
        }

        // iterates through the queue and displays all the customers in the waiting list
        System.out.println("Waiting Customers:");
        for (String c : customerQueue) {
            System.out.println("- " + c);
        }
	}

}
