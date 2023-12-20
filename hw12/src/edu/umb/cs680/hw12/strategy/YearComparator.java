// The YearComparator class implements the Comparator interface for comparing Car objects based on their manufacturing year.
// It provides a specific implementation of the compare method to compare two Car objects by their year attribute.

package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;
import java.util.Comparator;

// The YearComparator class is responsible for comparing Car objects based on their manufacturing year.
public class YearComparator implements Comparator<Car> {
    // Override the compare method to compare two Car objects based on their manufacturing year.
    // Returns:
    //   - negative value if car1 was manufactured earlier than car2,
    //   - positive value if car1 was manufactured later than car2,
    //   - zero if car1 and car2 were manufactured in the same year.
    @Override
    public int compare(Car car1, Car car2) {
        // Using Integer.compare to compare the year values of car1 and car2.
        // This method returns the difference between the two values.
        // This follows the contract of the compare method, where a negative value
        // indicates car1 is "less than" car2, a positive value indicates car1 is
        // "greater than" car2, and zero indicates equality.
        return Integer.compare(car1.getYear(), car2.getYear());
    }
}
