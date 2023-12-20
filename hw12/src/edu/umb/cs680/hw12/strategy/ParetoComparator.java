package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    private boolean dominates(Car car1, Car car2) {
        return car1.getPrice() < car2.getPrice() && car1.getMileage() > car2.getMileage();
    }

    @Override
    public int compare(Car car1, Car car2) {
        if (dominates(car1, car2)) {
            return -1;  // car1 is better
        } else if (dominates(car2, car1)) {
            return 1;   // car2 is better
        } else {
            return 0;   // cars are equal in Pareto comparison
        }
    }

    // Set domination status for car1 relative to car2.
    public void setDomination(Car car1, Car car2) {
        if (dominates(car1, car2)) {
            System.out.println(car1.getMake() + " " + car1.getModel() + " dominates " +
                    car2.getMake() + " " + car2.getModel() + " in Pareto comparison.");
        } else if (dominates(car2, car1)) {
            System.out.println(car2.getMake() + " " + car2.getModel() + " dominates " +
                    car1.getMake() + " " + car1.getModel() + " in Pareto comparison.");
        } else {
            System.out.println("No domination between " + car1.getMake() + " " + car1.getModel() +
                    " and " + car2.getMake() + " " + car2.getModel() + " in Pareto comparison.");
        }
    }

    // Get domination status for car1 relative to car2.
    public boolean getDomination(Car car1, Car car2) {
        return dominates(car1, car2) || dominates(car2, car1);
    }
}
