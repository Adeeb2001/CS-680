package edu.umb.cs680.hw05;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MessagingAppTest {
    private MessagingApp messagingApp;
    private UserAccount user1;
    private UserAccount user2;
    private String messageReceivedByUser1;
    private String messageReceivedByUser2;

    @Before
    public void setUp() {
        messagingApp = new MessagingApp();
        user1 = new UserAccount("Alice", messagingApp);
        user2 = new UserAccount("Bob", messagingApp);
        messageReceivedByUser1 = "";
        messageReceivedByUser2 = "";
    }

    @Test
    public void testSendMessage() {
        messagingApp.sendMessage("Hello, Alice and Bob!");

        // Verify that both users received the message
        assertEquals("Alice received a message: Hello, Alice and Bob!", messageReceivedByUser1);
        assertEquals("Bob received a message: Hello, Alice and Bob!", messageReceivedByUser2);
    }

    class UserAccount implements MessageObserver {
        private String username;

        public UserAccount(String username, MessageSubject messagingApp) {
            this.username = username;
            messagingApp.registerObserver(this);
        }

        @Override
        public void receiveMessage(String message) {
            if (username.equals("Alice")) {
                messageReceivedByUser1 = username + " received a message: " + message;
            } else if (username.equals("Bob")) {
                messageReceivedByUser2 = username + " received a message: " + message;
            }
        }
    }
}
