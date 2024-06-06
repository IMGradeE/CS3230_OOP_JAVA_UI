package GUIFundamentals.main;

public class SimulatorParameters {

    private int numberPeople;
    private int numberEvents;
    private int simulationSteps;
    private int delayTime;
    private double distanceThreshold;

    public SimulatorParameters(){
        numberPeople = 1000;
        numberEvents = 500;
        simulationSteps = 80;
        delayTime = 50;
        distanceThreshold = 1.0;
    }

    public SimulatorParameters(int numPeople, int numEvents, int sSteps, int dTime, double distThresh){
        numberEvents = numEvents;
        numberPeople = numPeople;
        simulationSteps = sSteps;
        delayTime = dTime;
        distanceThreshold = distThresh;
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
