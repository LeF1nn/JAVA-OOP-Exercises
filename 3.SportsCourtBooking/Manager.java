import java.util.ArrayList;

public class Manager {
    private ArrayList<Client> clients;
    private ArrayList<Court> courts;

    public Manager() {
        this.clients = new ArrayList<>();
        this.courts = new ArrayList<>();
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addCourt(Court court) {
        this.courts.add(court);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    public void removeCourt(Court court) {
        this.courts.remove(court);
    }

    public boolean bookCourt(String courtName, String clientName) {
        for(Court court : courts) {
            if(court.getName().equals(courtName)) {
                court.setClientName(clientName);
                court.setIsAvailable(false);
                return true;
            }
        }
        return false;
    }

    public void cancelBooking(Court court) {
        court.setClientName(null);
        court.setIsAvailable(true);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Court> getCourts() {
        return courts;
    }


}