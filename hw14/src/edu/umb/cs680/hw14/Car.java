package edu.umb.cs680.hw14;
import java.util.Objects;

/**
 * The {@code Car} class represents a car with basic attributes like make, model, year, mileage, and price.
 * This class provides methods for accessing and comparing car properties.
 */
public class Car {

    // Instance variables to store car attributes
    private String make;
    private String model;
    private int year;
    private int mileage;
    private double price;

    /**
     * Constructs a new {@code Car} object with the specified make, model, year, mileage, and price.
     *
     * @param make     The make of the car.
     * @param model    The model of the car.
     * @param year     The manufacturing year of the car.
     * @param mileage  The mileage (distance traveled) of the car.
     * @param price    The price of the car.
     */
    public Car(String make, String model, int year, int mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    /**
     * Gets the make of the car.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the manufacturing year of the car.
     *
     * @return The manufacturing year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the mileage (distance traveled) of the car.
     *
     * @return The mileage of the car.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Gets the price of the car.
     *
     * @return The price of the car.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks if this car is equal to another object.
     * Two cars are considered equal if they have the same make, model, year, mileage, and price.
     *
     * @param o The object to compare with this car.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                mileage == car.mileage &&
                Double.compare(car.price, price) == 0 &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model);
    }

    /**
     * Generates a hash code for this car.
     * The hash code is based on the make, model, year, mileage, and price.
     *
     * @return A hash code value for this car.
     */
    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, mileage, price);
    }

    /**
     * Returns a string representation of this car.
     * The string includes the make, model, year, mileage, and price.
     *
     * @return A string representation of this car.
     */
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
