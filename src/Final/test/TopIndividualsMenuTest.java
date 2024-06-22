package Final.test;

import Final.main.TopIndividualsMenu;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopIndividualsMenuTest {

    @Test
    void calculateCapitalPercentageTest() {
        // Arrange
        ArrayList<Double> capitals = new ArrayList<>(Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0, 60.0));
        TopIndividualsMenu topIndividualsMenu = new TopIndividualsMenu(new Frame(), true, capitals);

        // Act
        String result = topIndividualsMenu.calculateCapitalPercentage(50);

        // Assert
        assertEquals("71.43", result); // Sum of 50% of the richest individuals in the provided list
    }

    @Test
    void sliderChangeListenerTest() {
        // Arrange
        ArrayList<Double> capitals = new ArrayList<>(Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0, 60.0));
        TopIndividualsMenu topIndividualsMenu = new TopIndividualsMenu(new Frame(), true, capitals);

        // Act
        topIndividualsMenu.new SliderChangeListener().stateChanged(null);

        // Assert
        assertEquals("Selected Percentage: 50%, Sum of Richest Individuals: 71.43%",
                topIndividualsMenu.getPercentageOutputLabel().getText());
    }


}
