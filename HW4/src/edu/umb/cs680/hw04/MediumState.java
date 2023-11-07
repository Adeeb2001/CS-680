package edu.umb.cs680.hw04;

class MediumState implements State {
    private Fan fan;

    public MediumState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void pullChain() {
        System.out.println("Turning fan to high.");
        fan.setState(new HighState(fan));
    }
}
