package Final.main;

public class SimulatorParameters {
    private int numberPeople;
    private int numberEvents;
    private int simulationSteps;
    private int delayTime;
    private double distanceThreshold;

    // Constructor
    public SimulatorParameters() {
        // Set default values for parameters
        this(1000, 500, 80, 50, 1);
    }

    public SimulatorParameters(int numberPeople, int numberEvents, int simulationSteps, int delayTime, double distanceThreshold) {
        this.numberPeople = numberPeople;
        this.numberEvents = numberEvents;
        this.simulationSteps = simulationSteps;
        this.delayTime = delayTime;
        this.distanceThreshold = distanceThreshold;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public int getNumberEvents() {
        return numberEvents;
    }

    public void setNumberEvents(int numberEvents) {
        this.numberEvents = numberEvents;
    }

    public int getSimulationSteps() {
        return simulationSteps;
    }

    public void setSimulationSteps(int simulationSteps) {
        this.simulationSteps = simulationSteps;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public double getDistanceThreshold() {
        return distanceThreshold;
    }

    public void setDistanceThreshold(double distanceThreshold) {
        this.distanceThreshold = distanceThreshold;
    }

    // html format is needed in order to display multiple lines in a JLabel
    @Override
    public String toString() {
        return "<html><b>Simulator Parameters:</b><br>" +
                "<br>Number of People=" + numberPeople +
                "<br>Number of Events=" + numberEvents +
                "<br>Simulation Steps=" + simulationSteps +
                "<br>Distance Threshold=" + distanceThreshold +
                "<br>Thread Delay Time=" + delayTime + "</html>";
    }
}
