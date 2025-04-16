public class Court {
    private String name;
    private boolean isAvailable;
    private String clientName;

    public Court(String name, boolean isAvailable, String clientName) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.clientName = clientName;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

