package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Locale;

/**
 * Class ReverseAlphabeticalComparator
 * A concrete implementation of the Comparator interface for FSElement objects,
 * providing a way to compare them in reverse alphabetical order by their names.
 */
public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    /**
     * Override method compare
     * This method is required to be implemented as part of the Comparator interface.
     * It compares two FSElement objects in reverse alphabetical order by their names.
     *
     * @param element1 The first FSElement to be compared.
     * @param element2 The second FSElement to be compared.
     * @return An integer value representing the result of the reverse alphabetical comparison.
     */
    @Override
    public int compare(FSElement element1, FSElement element2) {
        // Get the names of the two FSElement objects and convert them to lowercase using Locale.ROOT
        String name1 = element1.getName().toLowerCase(Locale.ROOT);
        String name2 = element2.getName().toLowerCase(Locale.ROOT);

        // Use the compareTo method to compare the two lowercase names in reverse order
        // and return the result as the comparison
        return name2.compareTo(name1);
    }
}
