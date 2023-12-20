package edu.umb.cs680.hw16.observer;

import edu.umb.cs680.hw16.events.MessageEvent;
import edu.umb.cs680.hw16.observable.Observable;
import edu.umb.cs680.hw16.observableImpl.ObservableMessaging;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageDisplayObserverTest {

    @Test
    void update() {
        // Create an observable messaging instance
        ObservableMessaging observableMessaging = new ObservableMessaging();

        // Create a MessageDisplayObserver
        MessageDisplayObserver messageDisplayObserver = new MessageDisplayObserver("User", observableMessaging);

        // Send a message
        MessageEvent messageEvent = new MessageEvent("OtherUser", "Hello, User!");
        observableMessaging.sendMessage(messageEvent);

        // Check if the observer updated correctly
        assertEquals("User received a message: Hello, User!", messageDisplayObserver.getLastMessage());
    }
}
