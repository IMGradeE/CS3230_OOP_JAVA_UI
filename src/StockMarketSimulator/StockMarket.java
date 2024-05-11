package StockMarketSimulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StockMarket {
    public StockMarket(){
        random = new Random(System.currentTimeMillis());
    }
    private static Map<String, Stock> StocksMap = new HashMap<>();
    private static ArrayList<Stock> Stocks = new ArrayList<>();
    private Random random;

    public ArrayList<Stock> getStocks(){
        return new ArrayList<Stock>(StocksMap.values());
    }

    public Stock getRandomStock(){
        return Stocks.get(random.nextInt(Stocks.size()));
    }
    public void addStock(Stock stock){
        Stocks.add(stock);
        StocksMap.put(stock.getSymbol(), stock);
    }
    public static void buyStock(String symbol, int quantity){
        Stock stock = StocksMap.get(symbol);
        stock.reportPurchase(quantity); // increase the number of outstanding shares
    }
    public static void sellStock(String symbol, int quantity){
        Stock stock = StocksMap.get(symbol);
        stock.reportSale(quantity); // decrease the number of outstanding shares
    }
    public static double calculatePortfolioValue(Map<Stock, Integer> portfolio){
        double portfolioValue = 0;
        for (Map.Entry<Stock, Integer> entry : portfolio.entrySet()){
            Integer qty = entry.getValue();
            double currentPrice = entry.getKey().getCurrentPrice();
            portfolioValue += (double) qty*currentPrice;
        }
        return portfolioValue;
    }
    public void simulateMarketChanges(){
        for (Stock s : Stocks){
            double changePercentageCoeff = ((random.nextDouble()-.5)*2.0)/100.0; // bounds [-0.01, 0.01]
            double currentPrice = s.getCurrentPrice();
            s.setCurrentPrice(currentPrice+(currentPrice*changePercentageCoeff));
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
