package edu.umb.cs680.hw05;

import java.util.ArrayList;
import java.util.List;

//Concrete subject class
class MessagingApp implements MessageSubject {
 private List<MessageObserver> observers = new ArrayList<>();

 @Override
 public void registerObserver(MessageObserver observer) {
     observers.add(observer);
 }

 @Override
 public void removeObserver(MessageObserver observer) {
     observers.remove(observer);
 }

 @Override
 public void notifyObservers(String message) {
     for (MessageObserver observer : observers) {
         observer.receiveMessage(message);
     }
 }

 public void sendMessage(String message) {
     System.out.println("Sending message: " + message);
     notifyObservers(message);
 }
}