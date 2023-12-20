package edu.umb.cs680.hw13.fs.util;

/**
 * Interface Comparator<T>
 * This interface extends java.util.Comparator and defines a method to compare two objects of type T.
 * Implementing classes are expected to provide a concrete implementation of the compare method.
 * 
 * @param <T> The type of objects to be compared.
 */
public interface Comparator<T> extends java.util.Comparator<T> {

    /**
     * Method compare
     * Compares two objects of type T and returns an integer value representing the result of the comparison.
     * 
     * @param element1 The first object of type T to be compared.
     * @param element2 The second object of type T to be compared.
     * @return An integer value representing the result of the comparison.
     */
    int compare(T element1, T element2);
}
