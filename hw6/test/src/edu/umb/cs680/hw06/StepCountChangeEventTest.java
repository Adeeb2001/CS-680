package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The StepCountChangeEventTest class contains JUnit tests for the StepCountChangeEvent class,
 * ensuring the correctness of the implementation of the StepCountChangeEvent methods.
 */
class StepCountChangeEventTest {
    /**
     * Test the getSteps method of the StepCountChangeEvent class.
     * It creates a StepCountChangeEvent instance, sets the number of steps,
     * and then verifies that the getSteps method returns the expected number of steps.
     */
    @Test
    void testGetSteps() {
        // Set expected number of steps
        int expectedSteps = 4867;

        // Create a StepCountChangeEvent instance
        StepCountChangeEvent stepCountChangeEvent = new StepCountChangeEvent(expectedSteps);

        // Verify that getSteps returns the expected number of steps
        assertEquals(expectedSteps, stepCountChangeEvent.getSteps());
    }
}
