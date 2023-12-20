// The PriceComparator class implements the Comparator interface for comparing Car objects based on their prices.
// It provides a specific implementation of the compare method to compare two Car objects by their price attribute.

package edu.umb.cs680.hw12.strategy;

import edu.umb.cs680.hw12.Car;

import java.util.Comparator; 

// The PriceComparator class is responsible for comparing Car objects based on their price attribute.
public class PriceComparator implements Comparator<Car> {
    // Override the compare method to compare two Car objects based on their price.
    // Returns:
    //   - negative value if car1 has lower price than car2,
    //   - positive value if car1 has higher price than car2,
    //   - zero if car1 and car2 have equal prices.
    @Override
    public int compare(Car car1, Car car2) {
        // Using Double.compare to compare the price values of car1 and car2.
        // This method returns the difference between the two values.
        // This follows the contract of the compare method, where a negative value
        // indicates car1 is "less than" car2, a positive value indicates car1 is
        // "greater than" car2, and zero indicates equality.
        return Double.compare(car1.getPrice(), car2.getPrice());
    }
}
