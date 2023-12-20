package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The LocationEventTest class contains JUnit tests for the LocationEvent class,
 * ensuring the correctness of the implementation of the LocationEvent methods.
 */
class LocationChangeEventTest {

    /**
     * Test the getLatitude method of the LocationEvent class.
     * It creates a LocationEvent instance, sets the latitude and longitude,
     * and then verifies that the getLatitude method returns the expected latitude.
     */
    @Test
    void testGetLatitude() {
        // Set expected latitude and longitude values
        double expectedLatitude = 03.89;
        double expectedLongitude = 15.54;

        // Create a LocationEvent instance
        LocationChangeEvent locationChangeEvent = new LocationChangeEvent(expectedLatitude, expectedLongitude);

        // Verify that getLatitude returns the expected latitude
        assertEquals(expectedLatitude, locationChangeEvent.getLatitude());
    }

    /**
     * Test the getLongitude method of the LocationEvent class.
     * It creates a LocationEvent instance, sets the latitude and longitude,
     * and then verifies that the getLongitude method returns the expected longitude.
     */
    @Test
    void testGetLongitude() {
        // Set expected latitude and longitude values
        double expectedLatitude = 52.98;
        double expectedLongitude = -82.4544;

        // Create a LocationEvent instance
        LocationChangeEvent locationChangeEvent = new LocationChangeEvent(expectedLatitude, expectedLongitude);

        // Verify that getLongitude returns the expected longitude
        assertEquals(expectedLongitude, locationChangeEvent.getLongitude());
    }
}
