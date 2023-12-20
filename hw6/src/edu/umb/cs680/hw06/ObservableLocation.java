package edu.umb.cs680.hw06;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The ObservableLocation class extends the Java built-in Observable class
 * and represents an observable entity that tracks changes in location.
 */
public class ObservableLocation extends Observable {
    private double latitude;
    private double longitude;
    private List<ObserverLocation> observers = new ArrayList<>();

    /**
     * Registers an observer to receive updates when the location changes.
     *
     * @param observer The observer to be registered.
     */
    public void registerObserver(ObserverLocation observer) {
        observers.add(observer);
    }

    /**
     * Unregisters an observer, removing it from the list of observers.
     *
     * @param observer The observer to be unregistered.
     */
    public void unregisterObserver(ObserverLocation observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about a change in location.
     *
     * @param event The LocationChangeEvent object containing the new location information.
     */
    public void notifyLocationObservers(LocationChangeEvent event) {
        // Iterate through each registered observer and update their location.
        for (ObserverLocation observer : observers) {
            observer.updateLocation(event);
        }
    }

    /**
     * Sets the new location and notifies all registered observers about the change.
     *
     * @param event  The event value.
     */
    public void setLocation(LocationChangeEvent event) {
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
        notifyLocationObservers(event);
    }

    /**
     * Retrieves the list of registered observers.
     *
     * @return The list of ObserverLocattion objects.
     */
    public List<ObserverLocation> getObservers() {
        return observers;
    }
}
