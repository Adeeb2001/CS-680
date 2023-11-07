package edu.umb.cs680.hw05;

//Subject interface
interface MessageSubject {
 void registerObserver(MessageObserver observer);
 void removeObserver(MessageObserver observer);
 void notifyObservers(String message);
}
