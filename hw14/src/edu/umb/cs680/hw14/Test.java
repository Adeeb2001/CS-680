package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Car> carList = createCarList();

        System.out.println("Ascending Order by Year:");
        Collections.sort(carList, Comparator.comparing(Car::getYear));
        printCarList(carList);

        System.out.println("\nAscending Order by Price:");
        Collections.sort(carList, Comparator.comparing(Car::getPrice));
        printCarList(carList);

        System.out.println("\nAscending Order by Mileage:");
        Collections.sort(carList, Comparator.comparing(Car::getMileage));
        printCarList(carList);

        System.out.println("\nAscending Order by Make:");
        Collections.sort(carList, Comparator.comparing(Car::getMake));
        printCarList(carList);

        System.out.println("\nDescending Order by Year:");
        Collections.sort(carList, Comparator.comparing(Car::getYear).reversed());
        printCarList(carList);

        System.out.println("\nDescending Order by Price:");
        Collections.sort(carList, Comparator.comparing(Car::getPrice).reversed());
        printCarList(carList);

        System.out.println("\nDescending Order by Mileage:");
        Collections.sort(carList, Comparator.comparing(Car::getMileage).reversed());
        printCarList(carList);
    }

    private static List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();

        // Add several Car instances to the list
        carList.add(new Car("Tesla", "Model S", 2022, 5000, 80000.0));
        carList.add(new Car("BMW", "3 Series", 2020, 8000, 45000.0));
        carList.add(new Car("Mercedes-Benz", "C-Class", 2021, 6000, 50000.0));
        return carList;
    }
    private static void printCarList(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
