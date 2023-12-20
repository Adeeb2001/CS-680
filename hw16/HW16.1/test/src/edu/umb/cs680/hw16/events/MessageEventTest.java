package edu.umb.cs680.hw16.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageEventTest {

    @Test
    void getSender() {
        MessageEvent messageEvent = new MessageEvent("Sender", "Hello, World!");
        assertEquals("Sender", messageEvent.getSender());
    }

    @Test
    void getMessage() {
        MessageEvent messageEvent = new MessageEvent("Sender", "Hello, World!");
        assertEquals("Hello, World!", messageEvent.getMessage());
    }

    @Test
    void testToString() {
        MessageEvent messageEvent = new MessageEvent("Sender", "Hello, World!");
        assertEquals("MessageEvent{sender='Sender', message='Hello, World!'}", messageEvent.toString());
    }
}
