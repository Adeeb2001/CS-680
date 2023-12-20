package edu.umb.cs680.hw06;

import java.util.Observer;

/**
 * The StepCountObserver interface extends the Java built-in Observer interface
 * and defines an additional method, `updateStepCount`, for receiving step count
 * update notifications from observable objects.
 */
public interface StepCountObserver extends Observer {

    /**
     * The updateStepCount method is called when a step count update occurs in the
     * observable object. Observers implementing this method can respond to changes
     * in step count information.
     *
     * @param event The StepCountChangeEvent object containing the updated number of steps.
     */
    void updateStepCount(StepCountChangeEvent event);
}
