package InventoryAndEvents.Inventory;


import java.util.ArrayList;

public class Inventory<T>{
    private ArrayList<T> items;

    public Inventory(){
        items = new ArrayList<T>();
    }

    public Inventory(ArrayList<T> a){
        items = a;
    }

    public void addProduct(T product){
        items.add(product);
    }

    public boolean removeProduct(T product){
        return items.remove(product);
    }

    public int totalInventory(){
        int total = 0;
        for (T item : items){
            Product<T> p = (Product) item;
            total += p.getQuantity();
        }
        return total;
    }

    public double calculateTotalInventoryValue(){
        if(items.isEmpty()) {
            return 0.0;
        } else {
            int total = 0;
            for (T item : items) {
                Product<T> p = (Product) item;
                total += p.getQuantity()*p.getPrice();
            }
            return total;
        }
    }

    public double calculateAveragePrice(){
        if(items.isEmpty()) {
            return 0.0;
        } else {
            double total = 0.0;
            int quant = 0;
            for (T item : items) {
                Product<T> p = (Product) item;
                quant += p.getQuantity();
                total += p.getPrice()*p.getQuantity();
            }
            double d = total / (double) quant;
            return d;
        }
    }

    public void  listInventory(){
        if(items.isEmpty()) {
            System.out.println("Inventory is empty");
        } else
            for (T item : items){
            Product<T> p = (Product) item;
            System.out.println(p.toString());
        }
    }
}
