package Mocks;

public abstract class MenuItem {
    String id;
    String name;
    int amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }
}

