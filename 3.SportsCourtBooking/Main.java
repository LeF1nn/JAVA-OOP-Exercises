import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to the court booking system");
            System.out.println("Please select an option:");
            System.out.println("1. Book a court");
            System.out.println("2. Cancel a booking");
            System.out.println("3. View all bookings");
            System.out.println("4. Add a client");
            System.out.println("5. Add a court");
            System.out.println("6. Exit");
            System.out.print(">>> ");
            String option = scanner.nextLine();
            switch (option) {
                case "1": {
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
                    } else {
                        boolean courtExists = false;
                        for (Court court : manager.getCourts()) {
                            if (court.getName().equals(courtName)) {
                                courtExists = true;
                                break;
                            }
                        }
                        if (!courtExists) {
                            System.out.println("Court not found.");
                        } else {
                            if (manager.bookCourt(courtName, clientName)) {
                                System.out.println("Court booked successfully.");
                            } else {
                                System.out.println("Court is already booked.");
                            }
                        }
                    }
                    break;
                }

                case "2": {
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
                    } else {
                        boolean courtExists = false;
                        for (Court court : manager.getCourts()) {
                            if (court.getName().equals(courtName)) {
                                courtExists = true;
                                break;
                            }
                        }
                        if (!courtExists) {
                            System.out.println("Court not found.");
                        } else {
                            Court court = new Court(courtName, true, clientName);
                            Manager manager1 = new Manager();
                            manager1.cancelBooking(court);
                            System.out.println("canceld!");
                        }
                    }
                    break;
                }

                case "3": {
                    Manager manager1 = new Manager();
                    System.out.println("book list: ");
                    for (int i = 0; i < manager1.getCourts().size(); i++) {
                        System.out.println("Court" + i + "--> " + manager1.getCourts().get(i));
                    }
                    for (int i = 0; i < manager1.getClients().size(); i++) {
                        System.out.println("\n\nClient" + i + "--> " + manager1.getClients().get(i));
                    }
                    break;
                }

                case "4": {
                    Manager manager1 = new Manager();
                    System.out.println("Please enter client name: ");
                    String nameClient = scanner.nextLine();
                    int i = 0;
                    boolean loop = true;
                    boolean taken = true;
                    while (loop) {
                        if (nameClient.equals(manager1.getClients().get(i))) {
                            System.out.println("name is alredy used!");
                            loop = false;
                        } else {
                            taken = false;
                        }
                    }
                    if (!taken) {
                        Client client = new Client(nameClient, true);
                        System.out.println("client added! ");
                    }
                    break;
                }

                case "5": {
                    Manager manager1 = new Manager();
                    System.out.println("Please enter Court name: ");
                    String nameCourt = scanner.nextLine();
                    System.out.println("Please enter client name: ");
                    String nameClient = scanner.nextLine();
                    Court court = new Court(nameCourt, true, nameClient);
                    manager1.addCourt(court);
                    break;
                }


                case "6":
                    isRunning = false;
                    break;
            }
        }
    }
}
