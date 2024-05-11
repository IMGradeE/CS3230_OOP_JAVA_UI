package StockMarketSimulator;
import java.util.Random;
public class StockMarketSimulation {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        // Add sample stocks to the market
        Stock apple = new Stock("AAPL", "Apple Inc.", 150.0);
        Stock microsoft = new Stock("MSFT", "Microsoft Corporation", 300.0);
        Stock google = new Stock("GOOGL", "Alphabet Inc.", 2500.0);
        market.addStock(apple);
        market.addStock(microsoft);
        market.addStock(google);

        Player player1 = new Player("Player 1", 10000.0);
        Player player2 = new Player("Player 2", 15000.0);

        System.out.println(player1);
        System.out.println(player2);
        System.out.println("==============================================");
        // Simulate stock market changes for 10 days
        for (int day = 1; day <= 10; day++) {
            market.simulateMarketChanges();
            System.out.println("Day " + day + ":");
            for (Stock stock : market.getStocks()) {
                System.out.println(stock);
            }

            // Player 1's actions
            Random random = new Random();
            // Generate a random integer between 1 and 10 (inclusive)
            int qty1 = random.nextInt(10) + 1;
            player1.buyStock(market.getRandomStock(), qty1);

            // Player 2's actions
            int qty2 = random.nextInt(10) + 1;
            player2.buyStock(market.getRandomStock(), qty2);

            System.out.println(player1);
            System.out.println(player2);

            System.out.println();
        }
        System.out.println("===========================Final Summary===========================");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("===================================================================");

    }
}
