import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Application.QueuingSystem queuingSystem = Application.QueuingSystem.getInstance();
        Application.HelpDeskStation station1 = new Application.HelpDeskStation("Help Desk 1");
        Application.HelpDeskStation station2 = new Application.HelpDeskStation("Help Desk 2");
        Application.HelpDeskStation station3 = new Application.HelpDeskStation("Help Desk 3");
        Application.OnlineMonitoringSystem monitoringSystem = new Application.OnlineMonitoringSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("\n----- PAG-IBIG Centralized Queuing System -----");
            System.out.println("1. Enqueue customer");
            System.out.println("2. Serve next customer at Help Desk");
            System.out.println("3. Display current queued number online");
            System.out.println("4. Reset the queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
              {
                case 1:
                    System.out.print("Input customer number: ");
                    int customerNumber = scanner.nextInt();
                    queuingSystem.enqueue(customerNumber);
                    System.out.println("Customer " + customerNumber + " has been enqueued.");
                    break;
                case 2:
                    station1.serveNext();
                    break;
                case 3:
                    monitoringSystem.displayCurrentNumber();
                    break;
                case 4:
                    System.out.print("Enter the new startpoint for the queue: ");
                    int newStartingNumber = scanner.nextInt();
                    station1.resetQueue(newStartingNumber);
                    break;
                case 5:
                    System.out.println("Shutting down.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");}}
        while (choice != 5);

        scanner.close();
    }
}
