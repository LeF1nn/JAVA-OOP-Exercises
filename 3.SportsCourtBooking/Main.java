import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome to the court booking system");
            System.out.println("Please select an option:");
            System.out.println("1. Book a court");
            System.out.println("2. Cancel a booking");
            System.out.println("3. View all bookings");
            System.out.println("4. Add a client");
            System.out.println("5. Add a court");
            System.out.println("6. View all clients");
            System.out.println("7. View all courts");
            System.out.println("8. Exit");
            System.out.print(">>> ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Please enter the court name:");
                    System.out.print(">>> ");
                    String courtName = scanner.nextLine();
                    System.out.println("Please enter the client name:");
                    System.out.print(">>> ");
                    String clientName = scanner.nextLine();

                    boolean clientExists = false;
                    for (Client client : manager.getClients()) {
                        if (client.getName().equals(clientName)) {
                            clientExists = true;
                            break;
                        }
                    }

                    if (!clientExists) {
                        System.out.println("Client not found.");
                        break;
                    }

                    Court courtToBook = null;
                    for (Court court : manager.getCourts()) {
                        if (court.getName().equals(courtName)) {
                            courtToBook = court;
                            break;
                        }
                    }

                    if (courtToBook == null) {
                        System.out.println("Court not found.");
                    } else if (!courtToBook.isAvailable()) {
                        System.out.println("Court is already booked by " + courtToBook.getClientName());
                    } else {
                        if (manager.bookCourt(courtName, clientName)) {
                            System.out.println("Court booked successfully.");
                        } else {
                            System.out.println("Booking failed.");
                        }
                    }
                    break;

                case "2":
                    System.out.println("Please enter the court name to cancel booking:");
                    System.out.print(">>> ");
                    String courtToCancel = scanner.nextLine();

                    Court foundCourt = null;
                    for (Court court : manager.getCourts()) {
                        if (court.getName().equals(courtToCancel)) {
                            foundCourt = court;
                            break;
                        }
                    }

                    if (foundCourt == null) {
                        System.out.println("Court not found.");
                    } else if (foundCourt.isAvailable()) {
                        System.out.println("This court is not currently booked.");
                    } else {
                        if (manager.cancelBooking(foundCourt)) {
                            System.out.println("Booking canceled successfully.");
                        } else {
                            System.out.println("Failed to cancel booking.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nCurrent bookings:");
                    boolean hasBookings = false;
                    for (Court court : manager.getCourts()) {
                        if (!court.isAvailable()) {
                            System.out.println("Court: " + court.getName() + " - Booked by: " + court.getClientName());
                            hasBookings = true;
                        }
                    }
                    if (!hasBookings) {
                        System.out.println("No current bookings.");
                    }
                    break;

                case "4":
                    System.out.println("Please enter the client name:");
                    System.out.print(">>> ");
                    String newClientName = scanner.nextLine();

                    boolean clientAlreadyExists = false;
                    for (Client client : manager.getClients()) {
                        if (client.getName().equals(newClientName)) {
                            clientAlreadyExists = true;
                            break;
                        }
                    }

                    if (clientAlreadyExists) {
                        System.out.println("Client with this name already exists.");
                    } else {
                        manager.addClient(new Client(newClientName, true));
                        System.out.println("Client added successfully.");
                    }
                    break;

                case "5":
                    System.out.println("Please enter the court name:");
                    System.out.print(">>> ");
                    String newCourtName = scanner.nextLine();

                    boolean courtAlreadyExists = false;
                    for (Court court : manager.getCourts()) {
                        if (court.getName().equals(newCourtName)) {
                            courtAlreadyExists = true;
                            break;
                        }
                    }

                    if (courtAlreadyExists) {
                        System.out.println("Court with this name already exists.");
                    } else {
                        manager.addCourt(new Court(newCourtName, true, null));
                        System.out.println("Court added successfully.");
                    }
                    break;

                case "6":
                    System.out.println("\nList of all clients:");
                    if (manager.getClients().isEmpty()) {
                        System.out.println("No clients registered.");
                    } else {
                        for (Client client : manager.getClients()) {
                            System.out.println("- " + client.getName() +
                                    " (Status: " + (client.isAvailable() ? "Available" : "Not Available") + ")");
                        }
                    }
                    break;

                case "7":
                    System.out.println("\nList of all courts:");
                    if (manager.getCourts().isEmpty()) {
                        System.out.println("No courts available.");
                    } else {
                        for (Court court : manager.getCourts()) {
                            System.out.println("- " + court.getName() +
                                    " (Status: " + (court.isAvailable() ? "Available" : "Booked by " + court.getClientName()) + ")");
                        }
                    }
                    break;

                case "8":
                    isRunning = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}