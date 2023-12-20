package edu.umb.cs680.hw12;

import java.util.Objects;

// The Car class represents a simple model of a car with basic attributes.
public class Car {
    // Private instance variables to store the details of a car.
    private String make;    // Make of the car (e.g., Toyota, Honda)
    private String model;   // Model of the car (e.g., Camry, Accord)
    private int year;       // Year of manufacture
    private int mileage;    // Mileage of the car in miles
    private double price;   // Price of the car

    // Constructor to initialize the Car object with provided details.
    public Car(String make, String model, int year, int mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    // Getter method to retrieve the make of the car.
    public String getMake() {
        return make;
    }

    // Getter method to retrieve the model of the car.
    public String getModel() {
        return model;
    }

    // Getter method to retrieve the year of manufacture of the car.
    public int getYear() {
        return year;
    }

    // Getter method to retrieve the mileage of the car.
    public int getMileage() {
        return mileage;
    }

    // Getter method to retrieve the price of the car.
    public double getPrice() {
        return price;
    }

    // Override the equals method to compare Car objects based on their attributes.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // If the objects are the same, they are equal.
        if (o == null || getClass() != o.getClass()) return false;  // If the classes are different, they are not equal.
        Car car = (Car) o;  // Cast the object to a Car for attribute comparison.
        // Compare each attribute for equality.
        return year == car.year &&
                mileage == car.mileage &&
                Double.compare(car.price, price) == 0 &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model);
    }

    // Override the hashCode method to generate a hash code based on the attributes.
    @Override
    public int hashCode() {
        // Generate hash code using the Objects class, which provides a convenient method for this purpose.
        return Objects.hash(make, model, year, mileage, price);
    }
}
