package edu.umb.cs680.hw06;

import java.util.Observable;

/**
 * The TrackerApp class represents a concrete implementation of both StepCountObserver
 * and ObserverLocation. It acts as an observer for ObservableStepCount and
 * ObservableLocation, receiving and processing step count and location updates.
 */
public class TrackerApp implements StepCountObserver, ObserverLocation {

    // Private instance variable to store the app name
    private String trackerName;

    /**
     * Constructor for creating a TrackerApp with the specified app name.
     *
     * @param appName The name of the tracker app.
     */
    public TrackerApp(String appName) {
        this.trackerName = appName;
    }

    /**
     * Implementation of the updateStepCount method from StepCountObserver.
     * Prints step count information received from ObservableStepCount.
     *
     * @param event The StepCountChangeEvent containing the updated number of steps.
     */
    @Override
    public void updateStepCount(StepCountChangeEvent event) {
        System.out.println(trackerName + " received StepCount event. Steps: " + event.getSteps());
    }

    /**
     * Implementation of the updateLocation method from ObserverLocation.
     * Prints location information received from ObservableLocation.
     *
     * @param event The LocationEvent containing the updated latitude and longitude.
     */
    @Override
    public void updateLocation(LocationChangeEvent event) {
        System.out.println(trackerName + " received Location event. Latitude: " + event.getLatitude() +
                ", Longitude: " + event.getLongitude());
    }

    /**
     * Implementation of the update method from the Java built-in Observer interface.
     * Determines the type of observable and delegates the update to the appropriate method.
     *
     * @param o   The observable object.
     * @param arg The argument passed to notifyObservers method (an event object).
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ObservableStepCount) {
            updateStepCount((StepCountChangeEvent) arg);
        } else if (o instanceof ObservableLocation) {
            updateLocation((LocationChangeEvent) arg);
        }
    }
}
