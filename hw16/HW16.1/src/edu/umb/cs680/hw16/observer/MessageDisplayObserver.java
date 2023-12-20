package edu.umb.cs680.hw16.observer;

import edu.umb.cs680.hw16.events.MessageEvent;
import edu.umb.cs680.hw16.observable.Observable;

public class MessageDisplayObserver implements Observer<MessageEvent> {

    private String userName;
    private String lastMessage;

    public MessageDisplayObserver(String userName, Observable<MessageEvent> observable) {
        this.userName = userName;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable<MessageEvent> sender, MessageEvent event) {
        String message = String.format("%s received a message: %s", userName, event.getMessage());
        displayMessage(message);
    }

    private void displayMessage(String message) {
        // Logic to display the message, e.g., printing to console
        System.out.println(message);
        // Update the lastMessage field
        lastMessage = message;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
