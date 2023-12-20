package edu.umb.cs680.hw06;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The ObservableStepCount class extends the Java built-in Observable class
 * and represents an observable entity that tracks changes in step counts.
 */
public class ObservableStepCount extends Observable {
    private int noOfSteps; // Current step count
    private List<StepCountObserver> observers = new ArrayList<>();

    /**
     * Registers an observer to receive updates when the step count changes.
     *
     * @param observer The observer to be registered.
     */
    public void registerObserver(StepCountObserver observer) {
        observers.add(observer);
    }

    /**
     * Unregisters an observer, removing it from the list of observers.
     *
     * @param observer The observer to be unregistered.
     */
    public void unregisterObserver(StepCountObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about a change in step count.
     *
     * @param event The StepCountChangeEvent object containing the new step count information.
     */
    public void notifyStepCountObservers(StepCountChangeEvent event) {
        // Iterate through each registered observer and update their step count.
        for (StepCountObserver observer : observers) {
            observer.updateStepCount(event);
        }
    }

    /**
     * Sets the new step count and notifies all registered observers about the change.
     *
     * @param event The new event.
     */
    public void setSteps(StepCountChangeEvent event) {
        this.noOfSteps = event.getSteps();
        notifyStepCountObservers(event);
    }

    /**
     * Retrieves the list of registered observers.
     *
     * @return The list of StepCountObserver objects.
     */
    public List<StepCountObserver> getObservers() {
        return observers;
    }
}
