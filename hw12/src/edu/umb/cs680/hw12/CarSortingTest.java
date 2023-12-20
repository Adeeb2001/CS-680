package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.strategy.MileageComparator;
import edu.umb.cs680.hw12.strategy.ParetoComparator;
import edu.umb.cs680.hw12.strategy.PriceComparator;
import edu.umb.cs680.hw12.strategy.YearComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// The CarSortingTest class contains the main method to test the sorting functionality of various comparators.
public class CarSortingTest {
    public static void main(String[] args) {
        // Create a list of used cars for testing.
        List<Car> usedCars = new ArrayList<>();
        usedCars.add(new Car("Toyota", "Corolla", 2022, 4000, 21000.0));
        usedCars.add(new Car("Honda", "Accord", 2021, 7000, 18000.0));
        usedCars.add(new Car("Ford", "Mustang", 2020, 5500, 30000.0));

        // Test sorting with PriceComparator
        System.out.println("Sorting by Price:");
        Collections.sort(usedCars, new PriceComparator());
        printCars(usedCars);

        // Test sorting with YearComparator
        System.out.println("\nSorting by Year:");
        Collections.sort(usedCars, new YearComparator());
        printCars(usedCars);

        // Test sorting with MileageComparator
        System.out.println("\nSorting by Mileage:");
        Collections.sort(usedCars, new MileageComparator());
        printCars(usedCars);

        // Test sorting with ParetoComparator
        System.out.println("\nSorting by Pareto Comparison:");
        ParetoComparator paretoComparator = new ParetoComparator();
        Collections.sort(usedCars, paretoComparator);
        printCars(usedCars);

        // Example of using setDomination() and getDomination()
        Car car1 = usedCars.get(0);
        Car car2 = usedCars.get(1);
        paretoComparator.setDomination(car1, car2);
        boolean dominationStatus = paretoComparator.getDomination(car1, car2);
        System.out.println("Domination status: " + dominationStatus);
    }

    // Helper method to print the details of each car in the list.
    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getMake() + " " + car.getModel() + " - Year: " +
                    car.getYear() + ", Mileage: " + car.getMileage() + ", Price: $" + car.getPrice());
        }
    }
}
