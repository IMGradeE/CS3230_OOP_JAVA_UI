package InventoryAndEvents.Inventory;

public class Electronics {
    private String name;
    private String model;
    private boolean hasBattery;

    public Electronics(String name, String model, boolean hasBattery) {
        this.name = name;
        this.model = model;
        this.hasBattery = hasBattery;
    }

    @Override
    public String toString() {
        return "Electronics: " + name + ", model: " + model + ", has battery: " + hasBattery;
    }
}
