package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class AlphabeticalComparatorTest
 * Contains tests for the AlphabeticalComparator class.
 */
class AlphabeticalComparatorTest {

    /**
     * Method compare
     * Tests the compare method of the AlphabeticalComparator.
     */
    @Test
    void compare() {
        // Create an instance of AlphabeticalComparator
        AlphabeticalComparator comparator = new AlphabeticalComparator();

        // Create FSElement instances with modified names and sizes
        Directory dir1 = new Directory(null, "folderX");
        Directory dir2 = new Directory(null, "folderY");
        File file1 = new File(null, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(null, "documentB.txt", 250, LocalDateTime.now());
        File file3 = new File(null, "documentC.txt", 220, LocalDateTime.now());

        // Create a list and add elements in a different order
        List<FSElement> elements = new LinkedList<>();
        elements.add(file3);
        elements.add(file1);
        elements.add(dir1);
        elements.add(file2);
        elements.add(dir2);

        // Sort the list using the AlphabeticalComparator
        elements.sort(comparator);

// Check if the list is sorted alphabetically
        assertEquals("documentA.txt", elements.get(0).getName());
        assertEquals("documentB.txt", elements.get(1).getName());
        assertEquals("documentC.txt", elements.get(2).getName());  // Update expected value here
        assertEquals("folderX", elements.get(3).getName());
        assertEquals("folderY", elements.get(4).getName());

    }
}
