// The MileageComparatorTest class contains JUnit tests for the MileageComparator class.
// It tests the compare method to ensure correct functionality when comparing Car objects based on mileage.

package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// The MileageComparatorTest class tests the MileageComparator for correct comparison logic.
class MileageComparatorTest {

    // The compare method should return a positive value when car1 has higher mileage than car2.
    @Test
    void compare() {
        // Create two Car objects for testing with different mileage.
        Car car1 = new Car("Toyota", "Corolla", 2022, 12000, 23000.0);
        Car car2 = new Car("Honda", "Accord", 2020, 10000, 18000.0);


        // Create an instance of the MileageComparator.
        MileageComparator comparator = new MileageComparator();

        // Perform the comparison and assert that the result is greater than 0.
        int result = comparator.compare(car1, car2);
        assertTrue(result > 0, "Mileage of car1 should be less than car2");
    }
}
