package edu.umb.cs680.hw04;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();

        System.out.println("Fan is initially off.");
        fan.pullChain(); // Turning fan to low
        fan.pullChain(); // Turning fan to medium
        fan.pullChain(); // Turning fan to high
        fan.pullChain(); // Turning fan off
    }
}
