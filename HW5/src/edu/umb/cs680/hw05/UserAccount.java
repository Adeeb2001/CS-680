package edu.umb.cs680.hw05;

//Concrete observers (user accounts)
class UserAccount implements MessageObserver {
 private String username;

 public UserAccount(String username, MessageSubject messagingApp) {
     this.username = username;
     messagingApp.registerObserver(this);
 }

 @Override
 public void receiveMessage(String message) {
     System.out.println(username + " received a message: " + message);
 }
}