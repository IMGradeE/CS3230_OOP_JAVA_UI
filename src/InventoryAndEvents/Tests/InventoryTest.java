package InventoryAndEvents.Tests;

import InventoryAndEvents.Inventory.Inventory;
import InventoryAndEvents.Inventory.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest {
    private Inventory<Product<String>> inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory<>();
    }

    @Test
    void testTotalInventoryEmpty() {
        assertEquals(0, inventory.totalInventory());
    }

    @Test
    void testTotalInventoryNonEmpty() {
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        assertEquals(15, inventory.totalInventory());
    }

    @Test
    void testCalculateTotalInventoryValueEmpty() {
        assertEquals(0.0, inventory.calculateTotalInventoryValue(), 0.001);
    }

    @Test
    void testCalculateTotalInventoryValueNonEmpty() {
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        assertEquals(90.0, inventory.calculateTotalInventoryValue(), 0.001);
    }

    @Test
    void testCalculateAveragePriceEmpty() {
        assertEquals(0.0, inventory.calculateAveragePrice(), 0.001);
    }

    @Test
    void testCalculateAveragePriceNonEmpty() {
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        assertEquals(6.0, inventory.calculateAveragePrice(), 0.001);
    }

    @Test
    void testListInventory() {
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Get the platform-specific newline character sequence
        String newLine = System.getProperty("line.separator");

        // use \r\n for CRLF, \n only refers to LF, so it is better to use newLine
        String expectedOutput = "Item 1 - $5.0, quantity: 10, details: Details 1" + newLine + "Item 2 - $8.0, quantity: 5, details: Details 2" + newLine;

        assertEquals(expectedOutput, TestUtils.getConsoleOutput(inventory::listInventory));
    }

    @Test
    void testRemoveProduct() {
        Product<String> product1 = new Product<>("Item 1", 10, "Details 1", 5.0);
        Product<String> product2 = new Product<>("Item 2", 5, "Details 2", 8.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        assertTrue(inventory.removeProduct(product1));
        assertEquals(5, inventory.totalInventory());
        assertFalse(inventory.removeProduct(product1));
    }
}
