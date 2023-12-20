package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The ObservableLocationTest class contains JUnit tests for the ObservableLocation class,
 * ensuring the correctness of the implementation of its methods.
 */
class ObservableLocationTest {

    /**
     * Test the registerObserver method of the ObservableLocation class.
     * It creates a ObservableLocation instance, registers a test observer,
     * and then verifies that the observer is in the list of registered observers.
     */
    @Test
    void registerObserver() {
        // Arrange
        ObservableLocation sensor = new ObservableLocation();
        TestObserverLocation observer = new TestObserverLocation();

        // Act
        sensor.registerObserver(observer);

        // Assert
        assertTrue(sensor.getObservers().contains(observer));
    }

    /**
     * Test the unregisterObserver method of the ObservableLocation class.
     * It creates a ObservableLocation instance, registers and then unregisters
     * a test observer, and then verifies that the observer is not in the list of registered observers.
     */
    @Test
    void unregisterObserver() {
        // Arrange
        ObservableLocation sensor = new ObservableLocation();
        TestObserverLocation observer = new TestObserverLocation();
        sensor.registerObserver(observer);

        // Act
        sensor.unregisterObserver(observer);

        // Assert
        assertFalse(sensor.getObservers().contains(observer));
    }

    /**
     * Test the notifyLocationObservers method of the ObservableLocation class.
     * It creates a ObservableLocation instance, registers a test observer,
     * and then simulates a location event. It verifies that the observer receives
     * the correct event information.
     */
    @Test
    void notifyLocationObservers() {
        // Arrange
        ObservableLocation sensor = new ObservableLocation();
        TestObserverLocation observer = new TestObserverLocation();
        sensor.registerObserver(observer);

        double expectedLatitude = 416.549;
        double expectedLongitude = 562.614;

        // Act
        sensor.notifyLocationObservers(new LocationChangeEvent(expectedLatitude, expectedLongitude));

        // Assert
        assertEquals(expectedLatitude, observer.getEvent().getLatitude());
        assertEquals(expectedLongitude, observer.getEvent().getLongitude());
    }

    /**
     * Test the setLocation method of the ObservableLocation class.
     * It creates a ObservableLocation instance, registers a test observer,
     * and then sets a new location. It verifies that the observer receives
     * the correct event information.
     */
    @Test
    void setLocation() {
        // Arrange
        ObservableLocation locationSensor = new ObservableLocation();
        TestObserverLocation observer = new TestObserverLocation();
        locationSensor.registerObserver(observer);

        double expectedLatitude = 474.7985;
        double expectedLongitude = -492.414;
        LocationChangeEvent event = new LocationChangeEvent(expectedLatitude, expectedLongitude);

        // Act
        locationSensor.setLocation(event);

        // Assert
        assertEquals(expectedLatitude, observer.getEvent().getLatitude());
        assertEquals(expectedLongitude, observer.getEvent().getLongitude());
    }

    // Helper class to capture events for testing
    private static class TestObserverLocation implements ObserverLocation {
        private LocationChangeEvent event;

        @Override
        public void updateLocation(LocationChangeEvent event) {
            this.event = event;
        }

        public LocationChangeEvent getEvent() {
            return event;
        }

        @Override
        public void update(Observable o, Object arg) {
            // Unused for testing purposes
        }
    }
}
