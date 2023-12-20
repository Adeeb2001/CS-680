package edu.umb.cs680.hw17;

@FunctionalInterface
public interface Comparator<FSElement> extends java.util.Comparator<FSElement> {
    int compare(FSElement element1, FSElement element2);
}
