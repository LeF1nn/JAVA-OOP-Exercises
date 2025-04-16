import java.util.ArrayList;

public class Manager {
    private ArrayList<Client> clients;
    private ArrayList<Court> courts;

    public Manager() {
        this.clients = new ArrayList<>();
        this.courts = new ArrayList<>();
    }

    public boolean addClient(Client client) {
        for (Client c : clients) {
            if (c.getName().equals(client.getName())) {
                return false;
            }
        }
        this.clients.add(client);
        return true;
    }

    public boolean addCourt(Court court) {
        for (Court c : courts) {
            if (c.getName().equals(court.getName())) {
                return false;
            }
        }
        this.courts.add(court);
        return true;
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    public void removeCourt(Court court) {
        this.courts.remove(court);
    }

    public boolean bookCourt(String courtName, String clientName) {
        for (Court court : courts) {
            if (court.getName().equals(courtName) && court.isAvailable()) {
                court.setClientName(clientName);
                court.setIsAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean cancelBooking(Court court) {
        if (court != null && !court.isAvailable()) {
            court.setClientName(null);
            court.setIsAvailable(true);
            return true;
        }
        return false;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Court> getCourts() {
        return courts;
    }
}