package edu.umb.cs680.hw04;

//Concrete states
class OffState implements State {
 private Fan fan;

 public OffState(Fan fan) {
     this.fan = fan;
 }

 @Override
 public void pullChain() {
     System.out.println("Turning fan to low.");
     fan.setState(new LowState(fan));
 }
}