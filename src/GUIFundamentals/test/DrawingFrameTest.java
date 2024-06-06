package GUIFundamentals.test;

import GUIFundamentals.main.DrawingFrame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawingFrameTest {

    private DrawingFrame drawingFrame;
    private Robot robot;

    @BeforeEach
    public void setUp() {
        drawingFrame = new DrawingFrame();
        drawingFrame.createAndShowGUI();
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Disabled("DefaultShapeSelection is provided in the starter code, so no need to test it")
    public void testDefaultShapeSelection() {
        assertEquals("Oval", drawingFrame.getSelectedShape());
    }

    @Test
    public void testDefaultColorSelection() {
        assertEquals(Color.BLACK, drawingFrame.getSelectedColor());
    }

    @Test
    public void testShapeSelection() {
        robot.mouseMove(drawingFrame.getX() + 140, drawingFrame.getY() + 375); // Move the mouse over the "Circle" button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Simulate a left-click
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep(1000); // Wait for the UI to update
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Circle", drawingFrame.getSelectedShape());
    }

    @Test
    public void testColorSelection() {
        // Move the mouse over the color combo box's pull-down button and click it
        robot.mouseMove(drawingFrame.getX() + 170, drawingFrame.getY() + 50);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Simulate a left-click
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // Move the mouse over the color combo box's orange button and click it
        robot.mouseMove(drawingFrame.getX() + 136, drawingFrame.getY() + 108); // Move the mouse over the color combo box
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Simulate a left-click
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep(500); // Wait for the combo box to drop down
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(Color.ORANGE, drawingFrame.getSelectedColor());
    }

    @Test
    public void testSliderChange() {
        // Set the initial value of the slider
        int initialValue = drawingFrame.getShapeSize();
        assertEquals(50, initialValue);

        // Use the Robot class to simulate sliding the slider to a new value
        robot.mouseMove(297, 322); // Move to a position on the slider to the right
        // simulate to click the slider 3 times to change the value from 50 to 53
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);      // Press left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // Release mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);      // Press left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // Release mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);      // Press left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // Release mouse button

        // Delay to allow the slider change to register
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the slider's value has changed
        int updatedValue = drawingFrame.getShapeSize();
        assertEquals(53, updatedValue);
    }

    @AfterEach
    void cleanUp()
    {
        drawingFrame.dispose();
    }
}
