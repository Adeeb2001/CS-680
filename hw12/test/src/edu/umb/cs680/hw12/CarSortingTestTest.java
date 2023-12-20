package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.strategy.MileageComparator;
import edu.umb.cs680.hw12.strategy.ParetoComparator;
import edu.umb.cs680.hw12.strategy.PriceComparator;
import edu.umb.cs680.hw12.strategy.YearComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// The CarSortingTestTest class tests the sorting functionality of Car objects in the CarSortingTest class.
class CarSortingTestTest {

    // Test sorting by PriceComparator.
    @Test
    void testSortByPrice() {
        List<Car> usedCars = createCarList();
        Collections.sort(usedCars, new PriceComparator());

        assertEquals("Nissan Sentra", usedCars.get(0).getMake() + " " + usedCars.get(0).getModel());
        assertEquals("Mazda 3", usedCars.get(1).getMake() + " " + usedCars.get(1).getModel());
        assertEquals("Chevrolet Malibu", usedCars.get(2).getMake() + " " + usedCars.get(2).getModel());
    }

    // Test sorting by YearComparator.
    @Test
    void testSortByYear() {
        List<Car> usedCars = createCarList();
        Collections.sort(usedCars, new YearComparator());

        assertEquals("Nissan Sentra", usedCars.get(0).getMake() + " " + usedCars.get(0).getModel());
        assertEquals("Mazda 3", usedCars.get(1).getMake() + " " + usedCars.get(1).getModel());
        assertEquals("Chevrolet Malibu", usedCars.get(2).getMake() + " " + usedCars.get(2).getModel());
    }

    // Test sorting by MileageComparator.
    @Test
    void testSortByMileage() {
        List<Car> usedCars = createCarList();
        Collections.sort(usedCars, new MileageComparator());

        assertEquals("Chevrolet Malibu", usedCars.get(0).getMake() + " " + usedCars.get(0).getModel());
        assertEquals("Mazda 3", usedCars.get(1).getMake() + " " + usedCars.get(1).getModel());
        assertEquals("Nissan Sentra", usedCars.get(2).getMake() + " " + usedCars.get(2).getModel());
    }

    // Test sorting by ParetoComparator.
    @Test
    void testSortByParetoComparison() {
        List<Car> usedCars = createCarList();
        Collections.sort(usedCars, new ParetoComparator());

        assertEquals("Nissan Sentra", usedCars.get(0).getMake() + " " + usedCars.get(0).getModel());
        assertEquals("Mazda 3", usedCars.get(1).getMake() + " " + usedCars.get(1).getModel());
        assertEquals("Chevrolet Malibu", usedCars.get(2).getMake() + " " + usedCars.get(2).getModel());
    }

    // Helper method to create a list of Cars for testing.
    private List<Car> createCarList() {
        List<Car> usedCars = new ArrayList<>();
        usedCars.add(new Car("Chevrolet", "Malibu", 2022, 5000, 25000.0));
        usedCars.add(new Car("Nissan", "Sentra", 2020, 8000, 20000.0));
        usedCars.add(new Car("Mazda", "3", 2021, 6000, 22000.0));
        return usedCars;
    }
}
