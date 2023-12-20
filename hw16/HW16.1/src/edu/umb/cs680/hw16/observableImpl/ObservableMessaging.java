package edu.umb.cs680.hw16.observableImpl;

import edu.umb.cs680.hw16.events.MessageEvent;
import edu.umb.cs680.hw16.observable.Observable;
import edu.umb.cs680.hw16.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableMessaging extends Observable<MessageEvent> {

    private List<Observer<MessageEvent>> observers;
    private List<String> messages;

    public ObservableMessaging() {
        this.observers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void sendMessage(MessageEvent event) {
        // Use lambda expression with Observer<T>
        observers.forEach(observer -> observer.update(this, event));

        messages.add(event.toString());
        notifyObservers(event);
    }

    @Override
    public void addObserver(Observer<MessageEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<MessageEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(MessageEvent event) {
        observers.forEach(observer -> observer.update(this, event));
    }

    public List<String> getMessages() {
        return messages;
    }
}
