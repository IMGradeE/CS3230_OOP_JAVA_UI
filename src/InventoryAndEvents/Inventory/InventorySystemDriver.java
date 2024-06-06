package InventoryAndEvents.Inventory;

import java.util.Random;

public class InventorySystemDriver {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        Inventory<Product> inventory = new Inventory<>();
        //  create products (test case products)
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        //  add products
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        // loop initializes 8 more. (These cannot be removed without an overridden remove method that operates off of an index, or a getItem method because they leave scope locally)
        for (int i = 3; i < 10; i++) {
            inventory.addProduct(new Product<String>(String.format("Item %d",i), rand.nextInt(25), String.format("Details %d",i), rand.nextDouble(15.0)));
        }
        inventory.listInventory();
        System.out.printf("Total value of on hand items: %.2f\n",inventory.calculateTotalInventoryValue());
        System.out.printf("Average price: %.2f\n",inventory.calculateAveragePrice());
        //  remove products
        inventory.removeProduct(product1);
        inventory.removeProduct(product2);
        //  retrieve product details;
        inventory.listInventory();
        System.out.printf("Total value of on hand items: %.2f\n",inventory.calculateTotalInventoryValue());
        System.out.printf("Average price: %.2f\n",inventory.calculateAveragePrice());



    }
}




