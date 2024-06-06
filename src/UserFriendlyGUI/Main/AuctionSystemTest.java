package UserFriendlyGUI.Main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuctionSystemTest {

    private final AuctionSystem auctionSystem = new AuctionSystem(5);

    @Test
    public void testPlaceBidMultithreading() {
        AuctionItem item = new AuctionItem(1, "Item 1", 100.0);
        Bidder bidder1 = new Bidder("Bidder 1", 500.0, auctionSystem, 3);
        Bidder bidder2 = new Bidder("Bidder 2", 500.0, auctionSystem, 3);

        assertTrue(auctionSystem.placeBid(bidder1, item, 150.0));
        assertFalse(auctionSystem.placeBid(bidder2, item, 100.0)); // Bid not higher
    }

    @Test
    public void testAuctionMultithreading() {
        auctionSystem.startAuction();
        assertEquals(5, auctionSystem.getItems().size());
        for (AuctionItem item : auctionSystem.getItems()) {
            assertNotNull(item.getCurrentHighestBidder());
        }
    }

    @Test
    public void testBidderRunMultithreading() {
        Bidder bidder = new Bidder("Bidder 1", 500.0, auctionSystem, 3);
        bidder.run();
        assertTrue(bidder.getBudget() <= 500.0 && bidder.getBudget() >= 0.0);
    }

    @DisplayName("Concurrent Place Bid Test")
    @RepeatedTest(10)
    public void concurrentPlaceBidTest() {
        testPlaceBidMultithreading();
    }

    @DisplayName("Concurrent Auction Test")
    @RepeatedTest(10)
    public void concurrentAuctionTest() {
        testAuctionMultithreading();
    }

    @DisplayName("Concurrent Bidder Run Test")
    @RepeatedTest(10)
    public void concurrentBidderRunTest() {
        testBidderRunMultithreading();
    }

    @Test
    public void testAuctionSystemInitialization() {
        AuctionSystem auctionSystem = new AuctionSystem(5);
        assertEquals(5, auctionSystem.getItemNumbers());
        assertEquals(5, auctionSystem.getItems().size());
    }

    @Test
    public void testAuctionItemInitialization() {
        AuctionItem item = new AuctionItem(1, "Item 1", 100.0);
        assertEquals(1, item.getItemId());
        assertEquals("Item 1", item.getDescription());
        assertEquals(100.0, item.getStartingBid());
        assertEquals(100.0, item.getHighestBid());
        assertNull(item.getCurrentHighestBidder());
    }

    @Test
    public void testAuctionSystemPlaceBid() {
        AuctionSystem auctionSystem = new AuctionSystem(5);
        AuctionItem item = new AuctionItem(1, "Item 1", 100.0);
        Bidder bidder1 = new Bidder("Bidder 1", 500.0, auctionSystem, 3);
        Bidder bidder2 = new Bidder("Bidder 2", 500.0, auctionSystem, 3);

        assertTrue(auctionSystem.placeBid(bidder1, item, 150.0));
        assertEquals(150.0, item.getHighestBid());
        assertEquals(bidder1, item.getCurrentHighestBidder());

        assertFalse(auctionSystem.placeBid(bidder2, item, 100.0)); // Bid not higher
        assertEquals(150.0, item.getHighestBid());
        assertEquals(bidder1, item.getCurrentHighestBidder());
    }

    @Test
    public void testBidderRun() {
        AuctionSystem auctionSystem = new AuctionSystem(1);
        Bidder bidder = new Bidder("Bidder 1", 500.0, auctionSystem, 3);

        AuctionItem item = auctionSystem.getItems().get(0);
        bidder.run();
        assertEquals(399.0, bidder.getBudget(), 0.001);
        assertEquals(101.0, item.getHighestBid(), 0.001);
        assertEquals(bidder, item.getCurrentHighestBidder());
    }

    // You can add more test cases to cover other aspects of the code

}
