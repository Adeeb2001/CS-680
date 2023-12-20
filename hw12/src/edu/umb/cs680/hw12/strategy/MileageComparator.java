// The MileageComparator class implements the Comparator interface for comparing Car objects based on their mileage.
// It provides a specific implementation of the compare method to compare two Car objects by their mileage attribute.

package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;  // Importing the Car class for use in the MileageComparator.

import java.util.Comparator;  // Importing the Comparator interface for implementation.

public class MileageComparator implements Comparator<Car> {
    // Override the compare method to compare two Car objects based on their mileage.
    // Returns:
    //   - negative value if car1 has lower mileage than car2,
    //   - positive value if car1 has higher mileage than car2,
    //   - zero if car1 and car2 have equal mileage.
    @Override
    public int compare(Car car1, Car car2) {
        // Using Integer.compare to compare the mileage values of car1 and car2.
        // This method returns the difference between the two values.
        // This follows the contract of the compare method, where a negative value
        // indicates car1 is "less than" car2, a positive value indicates car1 is
        // "greater than" car2, and zero indicates equality.
        return Integer.compare(car1.getMileage(), car2.getMileage());
    }
}
