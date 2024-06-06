package GUIFundamentals.test;

import GUIFundamentals.main.SimulatorParameters;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimulatorParametersTest {

    @Test
    void testDefaultConstructor() {
        SimulatorParameters parameters = new SimulatorParameters();
        assertEquals(1000, parameters.getNumberPeople());
        assertEquals(500, parameters.getNumberEvents());
        assertEquals(80, parameters.getSimulationSteps());
        assertEquals(50, parameters.getDelayTime());
        assertEquals(1.0, parameters.getDistanceThreshold(), 0.01); // Use delta for double comparison
    }

    @Test
    void testParameterizedConstructor() {
        SimulatorParameters parameters = new SimulatorParameters(1500, 700, 90, 60, 1.5);
        assertEquals(1500, parameters.getNumberPeople());
        assertEquals(700, parameters.getNumberEvents());
        assertEquals(90, parameters.getSimulationSteps());
        assertEquals(60, parameters.getDelayTime());
        assertEquals(1.5, parameters.getDistanceThreshold(), 0.01); // Use delta for double comparison
    }

    @Test
    void testGettersAndSetters() {
        SimulatorParameters parameters = new SimulatorParameters();

        parameters.setNumberPeople(1200);
        assertEquals(1200, parameters.getNumberPeople());

        parameters.setNumberEvents(600);
        assertEquals(600, parameters.getNumberEvents());

        parameters.setSimulationSteps(100);
        assertEquals(100, parameters.getSimulationSteps());

        parameters.setDelayTime(30);
        assertEquals(30, parameters.getDelayTime());

        parameters.setDistanceThreshold(2.5);
        assertEquals(2.5, parameters.getDistanceThreshold(), 0.01); // Use delta for double comparison
    }


    @Test
    @Disabled("toString is provided in the starter code, so no need to test it")
    void testToString() {
        SimulatorParameters parameters = new SimulatorParameters(1500, 700, 90, 60, 1.5);
        String expected = "<html><b>Simulator Parameters:</b><br>" +
                "<br>Number of People=1500" +
                "<br>Number of Events=700" +
                "<br>Simulation Steps=90" +
                "<br>Distance Threshold=1.5" +
                "<br>Thread Delay Time=60</html>";
        assertEquals(expected, parameters.toString());
    }
}
