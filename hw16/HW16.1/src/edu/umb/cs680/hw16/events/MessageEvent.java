package edu.umb.cs680.hw16.events;

public class MessageEvent {

    private final String sender;
    private final String message;

    public MessageEvent(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
