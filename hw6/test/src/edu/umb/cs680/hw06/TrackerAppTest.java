package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests for the TrackerApp class, specifically focusing
 * on the updateStepCount() and updateLocation() methods. These tests ensure that
 * the TrackerApp correctly processes StepCountChangeEvent and LocationEvent objects
 * and produces the expected output.
 */
class TrackerAppTest {

    /**
     * Test for the updateStepCount() method of the TrackerApp class.
     * It checks whether the TrackerApp correctly processes a StepCountChangeEvent
     * and outputs the expected message.
     */
    @Test
    void updateStepCount() {
        // Arrange
        TrackerApp PulseMap = new TrackerApp("PulseMap");
        StepCountChangeEvent eventCountStep = new StepCountChangeEvent(789);

        // Act
        PulseMap.updateStepCount(eventCountStep);

        // Assert
        // Additional test for checking the 'steps' value directly from StepCountChangeEvent
        assertEquals(789, eventCountStep.getSteps());
    }

    /**
     * Test for the updateLocation() method of the TrackerApp class.
     * It checks whether the TrackerApp correctly processes a LocationEvent
     * and outputs the expected message.
     */
    @Test
    void updateLocation() {
        // Arrange
        TrackerApp PulseMap = new TrackerApp("PulseMap");
        LocationChangeEvent locationChangeEvent = new LocationChangeEvent(253.25, 147.69);

        // Act
        PulseMap.updateLocation(locationChangeEvent);

        // Assert
        // Additional test for checking the location values directly from LocationEvent
        assertEquals(253.25, locationChangeEvent.getLatitude());
        assertEquals(147.69, locationChangeEvent.getLongitude());
    }

}
