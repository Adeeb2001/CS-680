package edu.umb.cs680.hw04;

//context class
class Fan {
 private State state;

 public Fan() {
     state = new OffState(this);
 }

 public void setState(State state) {
     this.state = state;
 }

 public State getState() {
     return state;
 }

 public void pullChain() {
     state.pullChain();
 }
}