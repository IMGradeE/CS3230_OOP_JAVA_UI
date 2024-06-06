package UserFriendlyGUI.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class EventRunnableTest {

    @Test
    public void testRun() throws InterruptedException {
        // Create an Event object with initial coordinates
        Event event = new Event(EventType.LUCKY);

        // Create an EventComponent with default dimensions
        EventComponent eventComponent = new EventComponent();

        // Create CountDownLatches for starting and finishing the thread
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(1);

        // Create an EventRunnable instance with a delay of 10 milliseconds
        EventRunnable eventRunnable = new EventRunnable(event, eventComponent, startLatch, finishLatch, 10);

        // Start the thread
        Thread thread = new Thread(eventRunnable);
        thread.start();

        // Release the start latch to allow the thread to proceed
        startLatch.countDown();

        // Wait for the finish latch to indicate the thread has finished
        finishLatch.await();

        // Check if the event's coordinates have been updated
        Assertions.assertNotEquals(100.0, event.getX());
        Assertions.assertNotEquals(150.0, event.getY());
    }
}
