package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void getMake() {
        Car car1 = new Car("Chevrolet", "Malibu", 2022, 5000, 25000.0);
        assertEquals("Chevrolet", car1.getMake());
    }

    @Test
    void testEquals() {
        Car car1 = new Car("Chevrolet", "Malibu", 2022, 5000, 25000.0);
        Car car2 = new Car("Nissan", "Altima", 2020, 8000, 20000.0);
        Car car3 = new Car("Volkswagen", "Jetta", 2022, 5000, 25000.0);

        assertNotEquals(car1, car2);
        assertNotEquals(car1, car3);
    }
}
