package edu.umb.cs680.hw16.observer;

import edu.umb.cs680.hw16.observable.Observable;


@FunctionalInterface
public interface Observer<T> {
    public void update(Observable<T> sender, T event);
}
