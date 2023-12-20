package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.FSElement;

/**
 * Class SizeComparator
 * A concrete implementation of the Comparator interface for FSElement objects,
 * providing a way to compare them based on their sizes.
 */
public class SizeComparator implements Comparator<FSElement> {

    /**
     * Override method compare
     * This method is required to be implemented as part of the Comparator interface.
     * It compares two FSElement objects based on their sizes.
     *
     * @param element1 The first FSElement to be compared.
     * @param element2 The second FSElement to be compared.
     * @return An integer value representing the result of the size-based comparison.
     */
    @Override
    public int compare(FSElement element1, FSElement element2) {
        // Use Integer.compare to compare the sizes of the two FSElement objects
        return Integer.compare(element1.getSize(), element2.getSize());
    }
}
