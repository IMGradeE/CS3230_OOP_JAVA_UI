package StockMarketSimulator;

import java.util.HashMap;
import java.util.Map;

// Money values should not be doubles but it's a game so it's fine.
public class Player {
    public Player(String name, double initialBudget){
        PLAYER_NAME = name;
        budget = initialBudget;
        portfolioValue = 0;
    }
    private final String PLAYER_NAME;
    private double budget;
    private double portfolioValue;
    private final String ACTION_ATTEMPT = "trying to";
    private final String ACTION_UNSUCCESSFUL = "unsuccessful";
    private final String ACTION_SUCCESS_BUY = "bought";
    private final String ACTION_SUCCESS_SELL = "sold";
    private final String BUDGET_LABEL = "Budget:";
    private final String PORTFOLIO_LABEL = "Portfolio Value:";
    private final String TOTAL_COSTS_LABEL = "Total Costs:";
    private final String TOTAL_PROFITS_LABEL = "Total Profits:";

    private Map<Stock, Integer> portfolio = new HashMap<>();
    // Methods to buy and sell stocks (protected to prevent unwanted portfolio modification)
    protected void buyStock(Stock stockToBuy, int purchaseQuantity) {
        double cost = stockToBuy.getCurrentPrice() * purchaseQuantity;
        double remainingBudget = budget - cost;
        int availableShares = stockToBuy.getQuantityAvailable();
        printActionTaken(true, ACTION_ATTEMPT + " buy", stockToBuy, purchaseQuantity, TOTAL_COSTS_LABEL, cost);
        if (remainingBudget >= 0 && availableShares - purchaseQuantity >= 0) {
            budget -= cost;
            int heldQuantity = (portfolio.get(stockToBuy) != null) ? portfolio.get(stockToBuy): 0;
            int totalQuantity = heldQuantity + purchaseQuantity;

            StockMarket.buyStock(stockToBuy.getSymbol(), purchaseQuantity);

            // add an entry of this stock to the portfolio; stock -> quantity held
            portfolio.put(stockToBuy, totalQuantity);

            // update portfolio value
            setPortfolioValue(StockMarket.calculatePortfolioValue(portfolio));
            printActionTaken(true, ACTION_SUCCESS_BUY, stockToBuy, purchaseQuantity, TOTAL_COSTS_LABEL, cost);
        }else{
            printActionTaken(false, ACTION_UNSUCCESSFUL, stockToBuy, purchaseQuantity, TOTAL_COSTS_LABEL, cost);
        }
                // Realistically this would branch to:
                // TODO a prompt for a quantity which does not:
                //  exceed the dollar amount a player can afford
                //  exceed the quantity of shares available for purchase
    }

    protected void sellStock(Stock stockToSell, int sellQuantity){
        double profit = (stockToSell.getCurrentPrice() * sellQuantity);
        double newBudget = budget + profit;
        printActionTaken(true, ACTION_ATTEMPT + " sell", stockToSell, sellQuantity, TOTAL_PROFITS_LABEL, profit);

        int heldShares = (portfolio.get(stockToSell) != null) ? portfolio.get(stockToSell): 0;
        if (heldShares - sellQuantity >= 0) {
            budget += profit;
            int newHeldQuantity = heldShares - sellQuantity;
            StockMarket.sellStock(stockToSell.getSymbol(), sellQuantity);

            // decrease number of stocks held.
            portfolio.put(stockToSell, newHeldQuantity);

            // update portfolio value.
            setPortfolioValue(StockMarket.calculatePortfolioValue(portfolio));
            printActionTaken( true, ACTION_SUCCESS_SELL, stockToSell, sellQuantity, TOTAL_PROFITS_LABEL, profit);
        }else{
            printActionTaken(false, ACTION_UNSUCCESSFUL, stockToSell, sellQuantity, TOTAL_PROFITS_LABEL, profit);
        }
            // Realistically this would branch to:
            // TODO a prompt for a quantity which does not:
            //  exceed the quantity of shares available to sell
    }

    public String getPlayerName(String playerName) {
        return playerName;
    }

    @Override
    public String toString() {

        return String.format("%s's Portfolio (%s $%.2f, %s $%.2f)", PLAYER_NAME, BUDGET_LABEL, budget, PORTFOLIO_LABEL, portfolioValue);
    }

    public void printActionTaken(boolean successOrStart, String actionString, Stock stockReferenced, int quantity, String totalCostOrProfit, double amountDollars) {
        String actionMessage;
        if (successOrStart){
            actionMessage = String.format(
                    "%s %s %d of %s. %s $%.2f",
                    PLAYER_NAME,
                    actionString,
                    quantity,
                    stockReferenced.toString(),
                    totalCostOrProfit,
                    amountDollars);
        }else{
            actionMessage = String.format(
                    "%s %s %d of %s",
                    PLAYER_NAME,
                    actionString,
                    quantity,
                    stockReferenced.toString());
        }
        System.out.println(actionMessage);
    }

    protected void setPortfolioValue(double portfolioValue) {
        this.portfolioValue = portfolioValue;
    }
}
