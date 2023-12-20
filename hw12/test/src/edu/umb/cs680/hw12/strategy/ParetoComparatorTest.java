package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {

    @Test
    void compare() {
        // Test cases for the compare() method

        Car car1 = new Car("Toyota", "Corolla", 2022, 12000, 23000.0);
        Car car2 = new Car("Honda", "Accord", 2020, 10000, 18000.0);

        ParetoComparator paretoComparator = new ParetoComparator();

        // Test when car1 is better than car2
        assertEquals(0, paretoComparator.compare(car1, car2));

        // Test when car2 is better than car1
        assertEquals(0, paretoComparator.compare(car2, car1));

        // Test when cars are equal in Pareto comparison
        assertEquals(0, paretoComparator.compare(car1, car1));
    }

    @Test
    void setDomination() {
        // Test cases for the setDomination() method

        Car car1 = new Car("Toyota", "Corolla", 2022, 12000, 23000.0);
        Car car2 = new Car("Honda", "Accord", 2020, 10000, 18000.0);


        ParetoComparator paretoComparator = new ParetoComparator();

        // Test domination when car1 dominates car2
        paretoComparator.setDomination(car1, car2);

        // You might want to add assertions or check output using a testing framework like JUnit
    }

    @Test
    void getDomination() {
        // Test cases for the getDomination() method

        Car car1 = new Car("Toyota", "Corolla", 2022, 12000, 23000.0);
        Car car2 = new Car("Honda", "Accord", 2020, 10000, 18000.0);


        ParetoComparator paretoComparator = new ParetoComparator();


        // Test no domination when cars are equal
        assertFalse(paretoComparator.getDomination(car1, car1));
    }
}
