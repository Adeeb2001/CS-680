package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = createCarList();

        // Ascending ordering with lambda expressions
        Collections.sort(carList, (car1, car2) -> compareByYear(car1, car2));
        printCarList("Ascending Order by Year:", carList);

        Collections.sort(carList, (car1, car2) -> compareByPrice(car1, car2));
        printCarList("Ascending Order by Price:", carList);

        Collections.sort(carList, (car1, car2) -> compareByMileage(car1, car2));
        printCarList("Ascending Order by Mileage:", carList);


        // Descending ordering using reverseOrder() of Comparator
        Collections.sort(carList, Collections.reverseOrder((car1, car2) -> compareByYear(car1, car2)));
        printCarList("Descending Order by Year:", carList);

        Collections.sort(carList, Collections.reverseOrder((car1, car2) -> compareByPrice(car1, car2)));
        printCarList("Descending Order by Price:", carList);

        Collections.sort(carList, Collections.reverseOrder((car1, car2) -> compareByMileage(car1, car2)));
        printCarList("Descending Order by Mileage:", carList);
    }

    private static List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();

        // Add several Car instances to the list
        carList.add(new Car("Tesla", "Model S", 2022, 5000, 80000.0));
        carList.add(new Car("BMW", "3 Series", 2020, 8000, 45000.0));
        carList.add(new Car("Mercedes-Benz", "C-Class", 2021, 6000, 50000.0));
// Add more cars as needed


        return carList;
    }


    private static void printCarList(String message, List<Car> carList) {
        System.out.println(message);
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    // Functional Interface implementation for each comparison logic
    private static int compareByYear(Car car1, Car car2) {
        return Integer.compare(car1.getYear(), car2.getYear());
    }

    private static int compareByPrice(Car car1, Car car2) {
        return Double.compare(car1.getPrice(), car2.getPrice());
    }

    private static int compareByMileage(Car car1, Car car2) {
        return Integer.compare(car1.getMileage(), car2.getMileage());
    }
}