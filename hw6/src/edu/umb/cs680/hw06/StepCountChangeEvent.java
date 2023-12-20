package edu.umb.cs680.hw06;

/**
 * The StepCountChangeEvent class represents an event object that encapsulates
 * information about the number of steps taken. This class is designed to
 * be used in scenarios where step count updates need to be communicated
 * between components or modules.
 */
public class StepCountChangeEvent {

    // Private instance variable to store the number of steps
    private int noOfSteps;   // Number of steps taken

    /**
     * Constructor for creating a StepCountChangeEvent object with the specified
     * number of steps.
     *
     * @param steps The number of steps taken.
     */
    public StepCountChangeEvent(int steps) {
        this.noOfSteps = steps;
    }

    /**
     * Getter method to retrieve the number of steps taken.
     *
     * @return The number of steps.
     */
    public int getSteps() {
        return noOfSteps;
    }
}
