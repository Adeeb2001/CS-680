package edu.umb.cs680.hw11.strategy;

// Manhattan.java
import java.util.List;

public class Manhattan implements DistanceMetric {
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }

        double sumOfAbsDiff = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            sumOfAbsDiff += Math.abs(p1.get(i) - p2.get(i));
        }

        return sumOfAbsDiff;
    }
}