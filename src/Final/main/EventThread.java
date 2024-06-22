package Final.main;

import java.awt.Component;
public class EventThread extends Thread{
    private Event event;
    private Component eventComponent;
    public static final int STEPS = 80;
    public static final int DELAY = 3;
    private String threadName;
    private Thread t;

    public EventThread(Event event, Component eventComponent, String threadName) {
        this.event = event;
        this.eventComponent = eventComponent;
        this.threadName = threadName;
    }

    public void run()
    {
        System.out.println("Running " + threadName);
        try {
            for (int i = 1; i <= STEPS; i++) {
                event.move(eventComponent.getBounds());
                eventComponent.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thread " + threadName + " terminated");
    }

    public void start()
    {
        System.out.println("Starting " + threadName);
        if(t == null)
        {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
