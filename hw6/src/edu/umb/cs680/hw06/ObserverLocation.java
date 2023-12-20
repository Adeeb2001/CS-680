package edu.umb.cs680.hw06;

import java.util.Observer;

/**
 * The ObserverLocation interface extends the Java built-in Observer interface
 * and defines an additional method, `updateLocation`, for receiving location
 * update notifications from observable objects.
 */
public interface ObserverLocation extends Observer {

    /**
     * The updateLocation method is called when a location update occurs in the
     * observable object. Observers implementing this method can respond to
     * changes in location information.
     *
     * @param event The LocationEvent object containing updated latitude and longitude.
     */
    void updateLocation(LocationChangeEvent event);
}
