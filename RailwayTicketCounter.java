package cia;
import java.util.*;

public class RailwayTicketCounter {

	    static Scanner sc = new Scanner(System.in);

	    // Queue for customers
	    static Queue<String> customerQueue = new LinkedList<>();

	    // Stack for cancelled tickets
	    static Stack<String> cancelledTickets = new Stack<>();

	    // Array for ticket storage
	    static String[] tickets = new String[100];
	    static int ticketCount = 0;

	public static void main(String[] args) {
		
		while (true) {
            System.out.println("\n--- Railway Ticket Counter ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Cancel Last Ticket");
            System.out.println("4. Display Waiting List");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

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

    static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        customerQueue.add(name);
        System.out.println("Customer added to queue!");
    }

    static void serveCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("No customers!");
            return;
        }

        String customer = customerQueue.poll();
        tickets[ticketCount++] = customer;

        System.out.println("Ticket issued to: " + customer);
    }

    static void cancelTicket() {
        if (ticketCount == 0) {
            System.out.println("No tickets to cancel!");
            return;
        }

        String cancelled = tickets[--ticketCount];
        cancelledTickets.push(cancelled);

        System.out.println("Cancelled ticket of: " + cancelled);
    }

    static void displayQueue() {
        if (customerQueue.isEmpty()) {
            System.out.println("No waiting customers!");
            return;
        }

        System.out.println("Waiting Customers:");
        for (String c : customerQueue) {
            System.out.println("- " + c);
        }
	}

}
