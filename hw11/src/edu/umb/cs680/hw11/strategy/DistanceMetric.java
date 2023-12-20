package edu.umb.cs680.hw11.strategy;
// DistanceMetric.java
import java.util.List;

public interface DistanceMetric {
    double distance(List<Double> p1, List<Double> p2);
}

