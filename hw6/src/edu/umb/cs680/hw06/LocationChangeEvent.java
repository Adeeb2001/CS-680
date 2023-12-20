package edu.umb.cs680.hw06;

/**
 * The LocationChangeEvent class represents an event object that encapsulates
 * information about a specific location, including latitude and longitude.
 * This class is designed to be used in scenarios where location updates
 * need to be communicated between components or modules.
 */
public class LocationChangeEvent {

    // Private instance variables to store latitude and longitude
    private double latitude;    // The latitude of the location
    private double longitude;   // The longitude of the location

    /**
     * Constructor for creating an LocationChangeEvent object with the specified
     * latitude and longitude values.
     *
     * @param latitude  The latitude of the location.
     * @param longitude The longitude of the location.
     */
    public LocationChangeEvent(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter method to retrieve the latitude of the location.
     *
     * @return The latitude value.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter method to retrieve the longitude of the location.
     *
     * @return The longitude value.
     */
    public double getLongitude() {
        return longitude;
    }
}
