package UserFriendlyGUI.Auction;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class AuctionApp {
    public static void main(String[] args) {
        AuctionSystem auctionSystem = new AuctionSystem(5);
        auctionSystem.startAuction();

    }
}

class AuctionSystem {
    private ArrayList<AuctionItem> items;
    private ReentrantLock itemLock;
    private int itemNumbers;

    public AuctionSystem() {
        items = new ArrayList<>();
        itemLock = new ReentrantLock();
        itemNumbers = 0;
    }

    public AuctionSystem(int numItems) {
        this();
        for (int i = 0; i < numItems; i++) {
            items.add(new AuctionItem(i + 1, "Item " + (i + 1), 100.0 + (i * 50.0)));
        }
        itemNumbers = numItems;
    }

    public int getItemNumbers() {
        return itemNumbers;
    }

    public void addItem(AuctionItem item) {
        itemLock.lock();
        items.add(new AuctionItem(itemNumbers + 1, "Item " + (itemNumbers + 1), 100.0 + (itemNumbers * 50.0)));
        ++itemNumbers;
        itemLock.unlock();
    }

    public AuctionItem getRandomItem() {
        int randomIndex = (int) (Math.random() * items.size());
        return items.get(randomIndex);
    }

    public void startAuction() {
        Thread[] threads = new Thread[items.size()];
        Bidder[] bidders = new Bidder[items.size()];

        // maximum number of bids for each bidder is 10 times the total number of items
        for (int i = 0; i < items.size(); i++) {
            bidders[i] = new Bidder("Bidder " + (i + 1), 500.0, this, items.size() * 10);
            threads[i] = new Thread(bidders[i]);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // All threads have finished, continue with the next line
        System.out.println("All threads have finished.");
        for (AuctionItem item : items) {
            System.out.println("Item #" + item.getItemId() + " has a final bid of " + item.getHighestBid() + ", by " + item.getCurrentHighestBidder().getName());
        }
        for (Bidder bidder : bidders) {
            System.out.println(bidder.getName() + " has a remaining budget of " + bidder.getBudget());
        }

    }

    public boolean placeBid(Bidder bidder, AuctionItem item, double bidAmount) {
        itemLock.lock();
        boolean b = false;
        try {
            b = item.placeBid(bidder, bidAmount);
        } finally {
            itemLock.unlock();
        }
        return b;
    }


    public void displayAuctionItems() {
        for (AuctionItem item : items) {
            System.out.println(item.toString() + " (Current Bid: $" + item.getHighestBid() + ")");
        }
    }

    public ArrayList<AuctionItem> getItems() {
        return items;
    }
}

class AuctionItem {
    private int itemId;
    private String description;
    private double startingBid;
    private double highestBid;
    private Bidder currentHighestBidder;
    private ReentrantLock lock;

    public AuctionItem(int itemId, String description, double startingBid) {
        this.itemId = itemId;
        this.description = description;
        this.startingBid = startingBid;
        this.highestBid = startingBid;
        this.currentHighestBidder = null;
        this.lock = new ReentrantLock();
    }

    public int getItemId() {
        return itemId;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public Bidder getCurrentHighestBidder() {
        return (currentHighestBidder == null)? new Bidder("None", 0, null, 0 ): currentHighestBidder;
    }

    public String getDescription() {
        return description;
    }

    public boolean placeBid(Bidder bidder, double bidAmount) {
        // TODO:
        boolean b = false;
        lock.lock();
        try{
            if (bidAmount > highestBid && bidder.getBudget()>= bidAmount) {
                highestBid = bidAmount;
                currentHighestBidder = bidder;
                bidder.setBudget(bidder.getBudget()- bidAmount);
                b = true;
            }
        }finally{
            lock.unlock();
        }
        return b;

    }

    @Override
    public String toString() {
        return "Item #" + itemId + ": " + description + " (Starting Bid: $" + startingBid + ")";
    }
}

class Bidder implements Runnable {
    private String name;
    private double budget;
    private AuctionSystem auctionSystem;

    private int maxNumBids;

    public Bidder(String name, double budget, AuctionSystem auctionSystem, int maxNumBids) {
        this.name = name;
        this.budget = budget;
        this.auctionSystem = auctionSystem;
        this.maxNumBids = maxNumBids;
    }

    @Override
    public void run() {
        int bidsPlaced = 0;
        while (budget > 0 && bidsPlaced < maxNumBids) {
            bidsPlaced++;
            AuctionItem item = auctionSystem.getRandomItem(); // Get a random item to bid on
            if(item.getCurrentHighestBidder() == this) continue; // // try to avoid bidding itself

            double bidAmount = item.getHighestBid() + 1; // Calculate the bid amount (slightly higher than the current highest bid)
            if (budget >= bidAmount) { // Check if the bidder has enough budget
                if (auctionSystem.placeBid(this, item, bidAmount)) { // Attempt to place the bid
                    System.out.println(name + " placed a bid of $" + bidAmount + " on " + item.toString()); // Print bid information
                }
            } else { // Not enough budget to bid
                System.out.println(name + " cannot place any more bids due to budget constraints.");
            }
        }
        System.out.println(name + " has run out of budget or bids."); // Notify that the bidder has no more budget
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
