package InventoryAndEvents.Inventory;

import java.time.LocalDate;

public class Food {
    private String name;
    private LocalDate expiration;
    private double weight;

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
        expiration = LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return "Food: " + name + ", weight: " + weight + ", expires on " + expiration;
    }
}
