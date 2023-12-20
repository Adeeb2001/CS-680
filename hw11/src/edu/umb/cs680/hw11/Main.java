package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.umb.cs680.hw11.strategy.Cosine;
import edu.umb.cs680.hw11.strategy.Euclidean;
import edu.umb.cs680.hw11.strategy.Manhattan;

public class Main {
    public static void main(String[] args) {
        // Creating sample car data
        Car car1 = new Car("Toyota", "Camry", 2020, 15000, 25000.0f);
        Car car2 = new Car("Honda", "Accord", 2019, 20000, 22000.0f);
        Car car3 = new Car("Ford", "Fusion", 2021, 18000, 27000.0f);

        // Creating a list of cars
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // Creating a list of points based on car attributes
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars) {
            List<Double> point = Arrays.asList(
                    (double) car.getYear(),
                    (double) car.getMileage(),
                    (double) car.getPrice()
            );
            points.add(point);
        }

        // Calculating Euclidean distance between two cars
        double euclideanDistance = Distance.get(points.get(0), points.get(1), new Euclidean());
        System.out.println("Euclidean Distance between car1 and car2: " + euclideanDistance);

        // Calculating Manhattan distance between two cars
        double manhattanDistance = Distance.get(points.get(0), points.get(1), new Manhattan());
        System.out.println("Manhattan Distance between car1 and car2: " + manhattanDistance);

        // Calculating Cosine distance between two cars
        double cosineDistance = Distance.get(points.get(0), points.get(1), new Cosine());
        System.out.println("Cosine Distance between car1 and car2: " + cosineDistance);


        List<Car> carss = Arrays.asList(car1, car2, car3);

        // Step 1: Convert each car's attributes into a list of 3 values
        List<List<Double>> originalPoints = new ArrayList<>();
        for (Car car : carss) {
            List<Double> point = Arrays.asList(
                    (double) car.getYear(),
                    (double) car.getMileage(),
                    (double) car.getPrice()
            );
            originalPoints.add(point);
        }

        // Step 2: Apply min-max normalization to each of the 3 values
        List<List<Double>> normalizedPoints = normalize(originalPoints);

        // Step 3: Use Distance.matrix() with 3 distance metrics
        double[][] euclideanMatrix = toDoubleArrayMatrix(Distance.matrix(normalizedPoints, new Euclidean()));
        double[][] manhattanMatrix = toDoubleArrayMatrix(Distance.matrix(normalizedPoints, new Manhattan()));
        double[][] cosineMatrix = toDoubleArrayMatrix(Distance.matrix(normalizedPoints, new Cosine()));

        // Display the results (printing just a portion for brevity)
        displayMatrix("Euclidean Distance Matrix:", euclideanMatrix);
        displayMatrix("Manhattan Distance Matrix:", manhattanMatrix);
        displayMatrix("Cosine Distance Matrix:", cosineMatrix);
    }
    private static List<List<Double>> normalize(List<List<Double>> originalPoints) {
        List<List<Double>> normalizedPoints = new ArrayList<>();

        // Finding min and max for each dimension
        List<Double> minValues = Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        List<Double> maxValues = Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);

        for (List<Double> point : originalPoints) {
            for (int i = 0; i < point.size(); i++) {
                double value = point.get(i);
                minValues.set(i, Math.min(minValues.get(i), value));
                maxValues.set(i, Math.max(maxValues.get(i), value));
            }
        }

        // Applying min-max normalization
        for (List<Double> point : originalPoints) {
            List<Double> normalizedPoint = new ArrayList<>();
            for (int i = 0; i < point.size(); i++) {
                double normalizedValue = (point.get(i) - minValues.get(i)) / (maxValues.get(i) - minValues.get(i));
                normalizedPoint.add(normalizedValue);
            }
            normalizedPoints.add(normalizedPoint);
        }

        return normalizedPoints;
    }

    private static double[][] toDoubleArrayMatrix(List<List<Double>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix.get(i).get(j);
            }
        }

        return result;
    }

    private static void displayMatrix(String title, double[][] matrix) {
        System.out.println(title);
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
