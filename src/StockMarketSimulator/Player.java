package StockMarketSimulator;

import java.util.HashMap;
import java.util.Map;

public class Player {
    public Player(String name, double initialBudget){
        playerName = name;
        budget = initialBudget; // should not be a double, but it's a game so w/e
    }
    private final String playerName;
    private double budget;
    private Map<Stock, Integer> portfolio = new HashMap<>();
    // Methods to buy and sell stocks (protected to prevent unwanted portfolio modification)
    protected void buyStock(Stock stockToBuy, int purchaseQuantity) {
        double remainingBudget = budget - (stockToBuy.getCurrentPrice() * purchaseQuantity);
        int availableShares = stockToBuy.getQuantityAvailable();
        if (remainingBudget >= 0 && availableShares - purchaseQuantity >= 0) {
            budget -= StockMarket.buyStock(stockToBuy.getSymbol(), purchaseQuantity);
            // add an entry of this stock to the portfolio; stock -> quantity held
            int heldQuantity = (portfolio.get(stockToBuy) != null) ? portfolio.get(stockToBuy): 0;
            int totalQuantity = heldQuantity + purchaseQuantity;

            portfolio.put(stockToBuy, totalQuantity);

        }// Realistically this would branch to:
                // TODO a prompt for a quantity which does not:
                //  exceed the dollar amount a player can afford
                //  exceed the quantity of shares available for purchase
    }

    protected void sellStock(Stock stockToSell, int sellQuantity){
        double newBudget = budget + (stockToSell.getCurrentPrice() * sellQuantity);
        int heldShares = (portfolio.get(stockToSell) != null) ? portfolio.get(stockToSell): 0;
        if (heldShares - sellQuantity >= 0) {
            budget += StockMarket.sellStock(stockToSell.getSymbol(), sellQuantity);
            int newHeldQuantity = heldShares - sellQuantity;
            portfolio.put(stockToSell, newHeldQuantity);
        }// Realistically this would branch to:
        // TODO a prompt for a quantity which does not:
        //  exceed the quantity of shares available to sell
    }

    public String getPlayerName(String playerName) {
        return playerName;
    }

    @Override
    public String toString() {
        String s = String.format("%-20s\n%-20s\n%-20s", playerName, portfolio.keySet().toString(), portfolio.values().toString());
        return s;
    }
    // Method to calculate portfolio value
}
