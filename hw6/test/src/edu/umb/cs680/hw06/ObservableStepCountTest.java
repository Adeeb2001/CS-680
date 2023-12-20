package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The ObservableStepCountTest class contains JUnit tests for the ObservableStepCount class,
 * ensuring the correctness of the implementation of its methods.
 */
class ObservableStepCountTest {

    /**
     * Test the registerObserver method of the ObservableStepCount class.
     * It creates a ObservableStepCount instance, registers a test observer,
     * and then verifies that the observer is in the list of registered observers.
     */
    @Test
    void registerObserver() {
        // Arrange
        ObservableStepCount counter = new ObservableStepCount();
        TestStepCountObserver observer = new TestStepCountObserver();

        // Act
        counter.registerObserver(observer);

        // Assert
        assertTrue(counter.getObservers().contains(observer));
    }

    /**
     * Test the unregisterObserver method of the ObservableStepCount class.
     * It creates a ObservableStepCount instance, registers and then unregisters
     * a test observer, and then verifies that the observer is not in the list of registered observers.
     */
    @Test
    void unregisterObserver() {
        // Arrange
        ObservableStepCount counter = new ObservableStepCount();
        TestStepCountObserver observer = new TestStepCountObserver();
        counter.registerObserver(observer);

        // Act
        counter.unregisterObserver(observer);

        // Assert
        assertFalse(counter.getObservers().contains(observer));
    }

    /**
     * Test the notifyStepCountObservers method of the ObservableStepCount class.
     * It creates a ObservableStepCount instance, registers two test observers,
     * and then simulates a step count event. It verifies that both observers receive
     * the correct event information.
     */
    @Test
    void notifyStepCountObservers() {
        // Arrange
        ObservableStepCount counter = new ObservableStepCount();
        TestStepCountObserver obv1 = new TestStepCountObserver();
        TestStepCountObserver obv2 = new TestStepCountObserver();
        counter.registerObserver(obv1);
        counter.registerObserver(obv2);

        int expectedSteps = 2130;

        // Act
        counter.notifyStepCountObservers(new StepCountChangeEvent(expectedSteps));

        // Assert
        assertEquals(expectedSteps, obv1.getEvent().getSteps());
        assertEquals(expectedSteps, obv2.getEvent().getSteps());
    }

    /**
     * Test the setSteps method of the ObservableStepCount class.
     * It creates a ObservableStepCount instance, registers a test observer,
     * and then sets a new number of steps. It verifies that the observer receives
     * the correct event information.
     */
    @Test
    void setSteps() {
        // Arrange
        ObservableStepCount counter = new ObservableStepCount();
        TestStepCountObserver obv = new TestStepCountObserver();
        counter.registerObserver(obv);

        int expectedSteps = 1770;
        StepCountChangeEvent event = new StepCountChangeEvent(expectedSteps);

        // Act
        counter.setSteps(event);

        // Assert
        assertEquals(expectedSteps, obv.getEvent().getSteps());
    }

    // Helper class to capture events for testing
    private static class TestStepCountObserver implements StepCountObserver {
        private StepCountChangeEvent event;

        @Override
        public void updateStepCount(StepCountChangeEvent event) {
            this.event = event;
        }

        public StepCountChangeEvent getEvent() {
            return event;
        }

        @Override
        public void update(Observable o, Object arg) {
            // Unused for testing purposes
        }
    }
}
