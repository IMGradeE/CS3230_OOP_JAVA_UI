package StockMarketSimulator;

public class Stock {
    // all fields required:
    // constructor provides no defaults
    // does not allow empty initialization
    public Stock (String sym, String name, double price){
        symbol = sym;
        companyName = name;
        currentPrice = price;
        outstandingShares = 0;
    }
    private static final int AVAILABLE_SHARES = 50000;// unrealistic values but I don't think it matters here.
    private final String symbol;
    private final String companyName;
    private double currentPrice;
    private Integer outstandingShares;

    public String getSymbol() {
        return symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    protected void reportPurchase(int quantity){
        outstandingShares += quantity;
    }
    protected void reportSale(int quantity){
        outstandingShares -= quantity;
    }
    protected void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getQuantityAvailable(){
        return AVAILABLE_SHARES - this.outstandingShares;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): $%.2f", symbol, companyName,  currentPrice);
    }

}
