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
 * Class ReverseAlphabeticalComparatorTest
 * Contains tests for the ReverseAlphabeticalComparator class.
 */
class ReverseAlphabeticalComparatorTest {

    /**
     * Method compare
     * Tests the compare method of the ReverseAlphabeticalComparator.
     */
    @Test
    void compare() {
        // Create a ReverseAlphabeticalComparator
        ReverseAlphabeticalComparator comparator = new ReverseAlphabeticalComparator();

        // Create FSElement instances with modified names and sizes
        Directory dir1 = new Directory(null, "folderX");
        Directory dir2 = new Directory(null, "folderY");
        File file1 = new File(null, "documentC.txt", 200, LocalDateTime.now());
        File file2 = new File(null, "documentB.txt", 150, LocalDateTime.now());
        File file3 = new File(null, "documentA.txt", 120, LocalDateTime.now());

        // Create a list and add elements in a different order
        List<FSElement> elements = new LinkedList<>();
        elements.add(file3);
        elements.add(file1);
        elements.add(dir1);
        elements.add(file2);
        elements.add(dir2);

        // Sort the list using the ReverseAlphabeticalComparator
        elements.sort(comparator);

        // Check if the list is sorted in reverse alphabetical order
        assertEquals("folderY", elements.get(0).getName());
        assertEquals("folderX", elements.get(1).getName());
        assertEquals("documentC.txt", elements.get(2).getName());
        assertEquals("documentB.txt", elements.get(3).getName());
        assertEquals("documentA.txt", elements.get(4).getName());
    }
}
