package edu.umb.cs680.hw16;

import edu.umb.cs680.hw16.events.MessageEvent;
import edu.umb.cs680.hw16.observableImpl.ObservableMessaging;
import edu.umb.cs680.hw16.observer.MessageDisplayObserver;

public class Main {
    public static void main(String[] args) {
        // Create an observable messaging instance
        ObservableMessaging messagingApp = new ObservableMessaging();

        // Create message display observers
        MessageDisplayObserver user1Observer = new MessageDisplayObserver("User 1", messagingApp);
        MessageDisplayObserver user2Observer = new MessageDisplayObserver("User 2", messagingApp);

        // Send some messages using the new MessageEvent
        MessageEvent message1 = new MessageEvent("User 1", "Hello, User 2!");
        messagingApp.sendMessage(message1);

        MessageEvent message2 = new MessageEvent("User 2", "Hi, User 1! How are you?");
        messagingApp.sendMessage(message2);
    }
}
