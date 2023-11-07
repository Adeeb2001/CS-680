package edu.umb.cs680.hw04;

class HighState implements State {
    private Fan fan;

    public HighState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void pullChain() {
        System.out.println("Turning fan off.");
        fan.setState(new OffState(fan));
    }
}