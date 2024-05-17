package InheritanceAndInterface.Tests;

import InheritanceAndInterface.Main.DrawablePerson;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DrawablePersonTest {

    @Test
    void compareTo_WhenCapitalEqual_ShouldReturnZero() {
        // Arrange
        DrawablePerson person1 = new DrawablePerson(50.0, createImage());
        DrawablePerson person2 = new DrawablePerson(60.0, createImage());
        person1.setCapital(100.0);
        person2.setCapital(100.0);

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void compareTo_WhenCapitalGreaterThanOther_ShouldReturnPositive() {
        // Arrange
        DrawablePerson person1 = new DrawablePerson(10.0, createImage());
        DrawablePerson person2 = new DrawablePerson(10.0, createImage());
        person1.setCapital(35.0);
        person2.setCapital(22.0);

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    void compareTo_WhenCapitalLessThanOther_ShouldReturnNegative() {
        // Arrange
        DrawablePerson person1 = new DrawablePerson(10.0, createImage());
        DrawablePerson person2 = new DrawablePerson(10.0, createImage());
        person1.setCapital(15.0);
        person2.setCapital(16.0);

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    void draw_ShouldNotThrowException() {
        // Arrange
        DrawablePerson person = new DrawablePerson(50.0, createImage());
        Graphics graphics = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();

        // Act & Assert
        assertDoesNotThrow(() -> person.draw(graphics));
    }

    private Image createImage() {
        // Create a dummy image for testing
        return new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    }

    @Test
    void draw_ShouldDrawImageOnGraphics() {
        // Arrange
        Image image = createImage();
        DrawablePerson person = new DrawablePerson(50.0, image);
        Graphics graphicsMock = mock(Graphics.class);

        // Act
        person.draw(graphicsMock);

        // Assert
        // Verify that the drawImage method on the Graphics object was called with the expected parameters
        verify(graphicsMock).drawImage(eq(image), anyInt(), anyInt(), any());
    }

}
