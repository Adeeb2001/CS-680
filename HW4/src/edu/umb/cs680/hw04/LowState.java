package edu.umb.cs680.hw04;

class LowState implements State {
    private Fan fan;

    public LowState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void pullChain() {
        System.out.println("Turning fan to medium.");
        fan.setState(new MediumState(fan));
    }
}