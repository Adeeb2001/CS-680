package edu.umb.cs680.hw11.strategy;

// Cosine.java
import java.util.List;

public class Cosine implements DistanceMetric {
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }

        double dotProduct = 0.0;
        double magnitudeP1 = 0.0;
        double magnitudeP2 = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
            magnitudeP1 += Math.pow(p1.get(i), 2);
            magnitudeP2 += Math.pow(p2.get(i), 2);
        }

        magnitudeP1 = Math.sqrt(magnitudeP1);
        magnitudeP2 = Math.sqrt(magnitudeP2);

        if (magnitudeP1 == 0 || magnitudeP2 == 0) {
            return 0.0; // Avoid division by zero
        }

        return dotProduct / (magnitudeP1 * magnitudeP2);
    }
}