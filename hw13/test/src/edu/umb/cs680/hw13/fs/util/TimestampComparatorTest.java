package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class TimestampComparatorTest
 * Contains tests for the TimestampComparator class.
 */
class TimestampComparatorTest {

    /**
     * Method compare
     * Tests the compare method of the TimestampComparator.
     */
    @Test
    void compare() {
        // Create FSElements with different creation times and modified names
        Directory folderX = new Directory(null, "folderX");
        Directory folderY = new Directory(null, "folderY");
        File documentA = new File(null, "documentA.txt", 100, LocalDateTime.of(2022, 1, 1, 12, 0));
        File documentB = new File(null, "documentB.txt", 150, LocalDateTime.of(2022, 1, 1, 14, 0));

        // Create a TimestampComparator
        TimestampComparator comparator = new TimestampComparator();

        // Test if compare method returns a negative value for documentA and documentB
        assertTrue(comparator.compare(documentA, documentB) < 0);
    }
}
