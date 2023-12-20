// The YearComparatorTest class contains JUnit tests for the YearComparator class.
// It tests the compare method to ensure correct functionality when comparing Car objects based on the manufacturing year.

package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// The YearComparatorTest class tests the YearComparator for correct comparison logic.
class YearComparatorTest {

    // The compare method should return a positive value when car1 was manufactured later than car2.
    @Test
    void compare() {
        // Create two Car objects for testing with different manufacturing years.
        Car car1 = new Car("Toyota", "Corolla", 2022, 12000, 23000.0);
        Car car2 = new Car("Honda", "Accord", 2020, 10000, 18000.0);


        // Create an instance of the YearComparator.
        YearComparator comparator = new YearComparator();

        // Perform the comparison and assert that the result is greater than 0.
        int result = comparator.compare(car1, car2);

        // Assert the expected result based on the comparison logic
        assertTrue(result > 0); // car1 is newer than car2
    }
}
