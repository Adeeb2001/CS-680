package edu.umb.cs680.hw16.observableImpl;

import edu.umb.cs680.hw16.events.MessageEvent;
import edu.umb.cs680.hw16.observable.Observable;
import edu.umb.cs680.hw16.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObservableMessagingTest {

    private ObservableMessaging observableMessaging;
    private MockObserver<MessageEvent> observer;

    @BeforeEach
    void setUp() {
        observableMessaging = new ObservableMessaging();
        observer = new MockObserver<>();
    }

    @Test
    void sendMessage() {
        // Add the observer
        observableMessaging.addObserver(observer);

        // Send a message
        MessageEvent messageEvent = new MessageEvent("User", "Hello, World!");
        observableMessaging.sendMessage(messageEvent);

        // Check if the observer was notified
        assertTrue(observer.isUpdated());
    }


    @Test
    void removeObserver() {
        // Add the observer
        observableMessaging.addObserver(observer);

        // Remove the observer
        observableMessaging.removeObserver(observer);

        // Check if the observer is removed
        assertEquals(0, observableMessaging.countObservers());
    }

    @Test
    void notifyObservers() {
        // Add the observer
        observableMessaging.addObserver(observer);

        // Send a message
        MessageEvent messageEvent = new MessageEvent("User", "Hello, World!");
        observableMessaging.notifyObservers(messageEvent);

        // Check if the observer was notified
        assertTrue(observer.isUpdated());
    }

    @Test
    void getMessages() {
        // Send messages
        MessageEvent message1 = new MessageEvent("User1", "Hello, User2!");
        MessageEvent message2 = new MessageEvent("User2", "Hi, User1!");

        observableMessaging.sendMessage(message1);
        observableMessaging.sendMessage(message2);

        // Get the list of messages
        List<String> messages = observableMessaging.getMessages();

        // Check if the list contains the correct messages
        assertTrue(messages.contains(message1.toString()));
        assertTrue(messages.contains(message2.toString()));
    }

    // Helper class for testing Observer
    private static class MockObserver<T> implements Observer<T> {
        private boolean updated = false;

        @Override
        public void update(Observable<T> sender, T event) {
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }
    }

}
