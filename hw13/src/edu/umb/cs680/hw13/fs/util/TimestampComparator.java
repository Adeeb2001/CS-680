package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.FSElement;

/**
 * Class TimestampComparator
 * A concrete implementation of the Comparator interface for FSElement objects,
 * providing a way to compare them based on their creation timestamps.
 */
public class TimestampComparator implements Comparator<FSElement> {

    /**
     * Override method compare
     * This method is required to be implemented as part of the Comparator interface.
     * It compares two FSElement objects based on their creation timestamps.
     *
     * @param elem1 The first FSElement to be compared.
     * @param elem2 The second FSElement to be compared.
     * @return An integer value representing the result of the timestamp-based comparison.
     */
    @Override
    public int compare(FSElement elem1, FSElement elem2) {
        // Use the compareTo method of LocalDateTime to compare the creation timestamps
        return elem1.getCreationTime().compareTo(elem2.getCreationTime());
    }
}
