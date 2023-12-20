package edu.umb.cs680.hw12.strategy;

// The Comparator interface defines a contract for objects that can compare two objects of the same type.
// It is a generic interface with a type parameter T, indicating the type of objects being compared.
public interface Comparator<T> {
    // The compare method is responsible for comparing two objects of type T.
    // It returns an integer value:
    //   - negative value if obj1 is less than obj2,
    //   - positive value if obj1 is greater than obj2,
    //   - zero if obj1 is equal to obj2.
    int compare(T obj1, T obj2);
}
