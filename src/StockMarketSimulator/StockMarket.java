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
    public static double buyStock(String symbol, int quantity){
        Stock stock = StocksMap.get(symbol);
        stock.reportPurchase(quantity); // increase the number of outstanding shares
        return stock.getCurrentPrice()*quantity; // return positive amount of purchase
    }
    public static double sellStock(String symbol, int quantity){
        Stock stock = StocksMap.get(symbol);
        stock.reportSale(quantity); // decrease the number of outstanding shares
        return stock.getCurrentPrice()*quantity; // return positive amount of sale
    }
    public  void calculatePortfolioValue(){
        // TODO
    }
    public void simulateMarketChanges(){
        for (Stock s : Stocks){
            double changePercentageCoeff = 1 +(random.nextDouble()-.5)*2.0;
            s.setCurrentPrice(s.getCurrentPrice()*changePercentageCoeff);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
