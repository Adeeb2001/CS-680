package edu.umb.cs680.hw13.fs.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Class SizeComparatorTest
 * Contains tests for the SizeComparator class.
 */
class SizeComparatorTest {

    /**
     * Method compare
     * Tests the compare method of the SizeComparator.
     */
    @Test
    void compare() {
        // Create a SizeComparator
        SizeComparator comparator = new SizeComparator();

        // Create FSElement instances with modified sizes
        Directory dir1 = new Directory(null, "folderX");
        Directory dir2 = new Directory(null, "folderY");
        File file1 = new File(null, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(null, "documentB.txt", 250, LocalDateTime.now());
        File file3 = new File(null, "documentC.txt", 120, LocalDateTime.now());

        // Create a list and add elements in a different order
        List<FSElement> elements = new LinkedList<>();
        elements.add(file3);
        elements.add(file1);
        elements.add(dir1);
        elements.add(file2);
        elements.add(dir2);

        // Sort the list using the SizeComparator
        elements.sort(comparator);

        // Check if the list is sorted by size
        assertEquals("folderX", elements.get(0).getName());
        assertEquals("folderY", elements.get(1).getName());
        assertEquals("documentC.txt", elements.get(2).getName());
        assertEquals("documentA.txt", elements.get(3).getName());
        assertEquals("documentB.txt", elements.get(4).getName());
    }
}
