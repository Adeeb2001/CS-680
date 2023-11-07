package edu.umb.cs680.hw03;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {
    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 2018, 50000, 25000.0f);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    private String[] carToStringArray(Car car) {
        String[] carInfo = new String[3];
        carInfo[0] = car.getMake();
        carInfo[1] = car.getModel();
        carInfo[2] = String.valueOf(car.getYear());
        return carInfo;
    }
}

