package UserFriendlyGUI.Main;

import java.util.concurrent.CountDownLatch;

public class EventRunnable implements Runnable {
    private Event event;
    private EventComponent eventComponent;
    private int delay;

    private final CountDownLatch start;
    private final CountDownLatch finish;

    public EventRunnable(Event event, EventComponent eventComponent, CountDownLatch start, CountDownLatch finish, int delay) {
        this.event = event;
        this.eventComponent = eventComponent;
        this.start = start;
        this.finish = finish;
        this.delay = delay;
    }

    public void run() {
        // TODO:
        try{
            start.await();
            event.move(eventComponent.getBounds());
            eventComponent.repaint();
            Thread.sleep(delay);
        }catch (InterruptedException e){

        }finally{
            finish.countDown();
        }
    }

    public int getDelay() {
        return delay;
    }
}
