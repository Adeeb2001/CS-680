package edu.umb.cs680.hw11.strategy;

// Euclidean.java
import java.util.List;

public class Euclidean implements DistanceMetric {
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }

        double sumOfSquared = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            sumOfSquared += Math.pow(p1.get(i) - p2.get(i), 2);
        }

        return Math.sqrt(sumOfSquared);
    }
}