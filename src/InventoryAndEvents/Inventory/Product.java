package InventoryAndEvents.Inventory;


public class Product<T> implements Saleable{
    private String productName;
    private int quantityInStock;
    private T productDetails;
    private Double price;

    public Product(String prodName, int quantInStock, T prodDetails, Double prodPrice){
        productName = prodName;
        quantityInStock = quantInStock;
        productDetails = prodDetails;
        price = prodPrice;
    }

    @Override
    public String toString(){
        //"Item 1 - $5.0, quantity: 10, details: Details 1" + newLine + "Item 2 - $8.0, quantity: 5, details: Details 2" + newLine;
        return String.format("%s - $%.1f, quantity: %d, details: %s",productName,price,quantityInStock,productDetails);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public T getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(T productDetails) {
        this.productDetails = productDetails;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
