package edu.umb.cs680.hw06;

/**
 * The Main class serves as the entry point for the TrackerApp application.
 * It demonstrates the use of the observer pattern with ObservableStepCount
 * and ObservableLocation, as well as TrackerApp observers.
 */
public class Main {

    /**
     * The main method creates instances of observables, observers (TrackerApp),
     * and demonstrates the registration of observers to respective observables.
     * It also simulates step count and location updates to observe the behavior
     * of the TrackerApp instances.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create instances of observables
        ObservableStepCount stepCountObservable = new ObservableStepCount();
        ObservableLocation locationObservable = new ObservableLocation();

        // Create instances of TrackerApp observers
        TrackerApp FitTrackr = new TrackerApp("FitTrackr");
        TrackerApp PulseMap = new TrackerApp("PulseMap");
        TrackerApp StepSync= new TrackerApp("StepSync");
        TrackerApp FitFocus= new TrackerApp("FitFocus");

        // Register observers to respective observables
        stepCountObservable.registerObserver(FitTrackr);
        stepCountObservable.registerObserver(PulseMap);
        locationObservable.registerObserver(StepSync);
        locationObservable.registerObserver(FitFocus);

        // Simulate events
        stepCountObservable.setSteps(new StepCountChangeEvent(1024));
        locationObservable.setLocation(new LocationChangeEvent(10.52, 98.74));
    }
}
