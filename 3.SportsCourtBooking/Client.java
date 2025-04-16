public class Client {

    private String name;
    private boolean isAvailable;
    public Client(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
