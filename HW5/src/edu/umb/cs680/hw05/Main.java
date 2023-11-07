package edu.umb.cs680.hw05;

public class Main {
    public static void main(String[] args) {
        MessagingApp messagingApp = new MessagingApp();

        UserAccount user1 = new UserAccount("Alice", messagingApp);
        UserAccount user2 = new UserAccount("Bob", messagingApp);

        messagingApp.sendMessage("Hello, everyone!");
    }
}

