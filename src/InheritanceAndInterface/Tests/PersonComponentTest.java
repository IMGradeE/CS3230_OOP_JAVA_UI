package InheritanceAndInterface.Tests;

import  InheritanceAndInterface.Main.DrawablePerson;
import InheritanceAndInterface.Main.PersonComponent;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonComponentTest {

    @Test
    void constructor_ShouldGeneratePeople() {
        // Arrange
        PersonComponent personComponent = new PersonComponent(5);

        // Act
        ArrayList<DrawablePerson> people = personComponent.getPeople();

        // Assert
        assertEquals(5, people.size());
    }

    @Test
    void constructor_ShouldSetPanelWidthAndHeight() {
        // Arrange
        PersonComponent personComponent = new PersonComponent();

        // Act
        personComponent.setPanelWidth(500);
        personComponent.setPanelHeight(600);

        // Assert
        assertEquals(500, personComponent.getPanelWidth());
        assertEquals(600, personComponent.getPanelHeight());
    }

    @Test
    void paintComponent_ShouldInvokeDrawOnEachPerson() {
        // Arrange
        PersonComponent personComponent = new PersonComponent(3);
        Graphics graphicsMock = mock(Graphics.class);

        // Act
        personComponent.paintComponent(graphicsMock);

        // Assert
        verify(graphicsMock, times(3)).drawImage(any(), anyInt(), anyInt(), any());
    }

}
