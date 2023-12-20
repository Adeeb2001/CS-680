package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class FSElementImplementationTest
 * Contains tests for the FSElementImplementation class.
 */
class FSElementImplementationTest {

    /**
     * Method getName
     * Tests the getName method of the FSElementImplementation class.
     */
    @Test
    void getName() {
        // Create a sample FSElement
        File file = new File(null, "sample.txt", 50, LocalDateTime.now());
        FSElementImplementation element = new FSElementImplementation(file);

        // Test the getName method
        assertEquals("sample.txt", element.getName());
    }

    /**
     * Method getSize
     * Tests the getSize method of the FSElementImplementation class.
     */
    @Test
    void getSize() {
        // Create a sample FSElement
        File file = new File(null, "sample.txt", 50, LocalDateTime.now());
        FSElementImplementation element = new FSElementImplementation(file);

        // Test the getSize method
        assertEquals(50, element.getSize());
    }

    /**
     * Method getCreationTime
     * Tests the getCreationTime method of the FSElementImplementation class.
     */
    @Test
    void getCreationTime() {
        // Create a sample FSElement
        File file = new File(null, "sample.txt", 50, LocalDateTime.of(2023, 1, 1, 12, 0));
        FSElementImplementation element = new FSElementImplementation(file);

        // Test the getCreationTime method
        assertEquals(LocalDateTime.of(2023, 1, 1, 12, 0), element.getCreationTime());
    }

    /**
     * Method isDirectory
     * Tests the isDirectory method of the FSElementImplementation class.
     */
    @Test
    void isDirectory() {
        // Create a sample FSElement (File)
        File file = new File(null, "sample.txt", 50, LocalDateTime.now());
        FSElementImplementation fileElement = new FSElementImplementation(file);

        // Create a sample FSElement (Directory)
        Directory directory = new Directory(null, "dir");
        FSElementImplementation dirElement = new FSElementImplementation(directory);

        // Test the isDirectory method
        assertFalse(fileElement.isDirectory());
        assertTrue(dirElement.isDirectory());
    }

    /**
     * Method isLinked
     * Tests the isLinked method of the FSElementImplementation class.
     */
    @Test
    void isLinked() {
        // Create a sample FSElement
        File file = new File(null, "sample.txt", 50, LocalDateTime.now());
        FSElementImplementation element = new FSElementImplementation(file);

        // Test the isLinked method for a non-linked element
        assertFalse(element.isLinked());

        // Create a linked element
        Directory parent = new Directory(null, "parent");
        Link link = new Link(parent, "link", 0, LocalDateTime.now(), file);
        FSElementImplementation linkedElement = new FSElementImplementation(link);

        // Test the isLinked method for a linked element
        assertTrue(linkedElement.isLinked());
    }

    /**
     * Method getRealFSElement
     * Tests the getRealFSElement method of the FSElementImplementation class.
     */
    @Test
    void getRealFSElement() {
        // Create a sample FSElement
        File file = new File(null, "sample.txt", 50, LocalDateTime.now());
        FSElementImplementation element = new FSElementImplementation(file);

        // Test the getRealFSElement method
        assertSame(file, element.getRealFSElement());
    }

    /**
     * Method testEquals
     * Tests the equals method of the FSElementImplementation class.
     */
    @Test
    void testEquals() {
        // Create sample FSElements
        File file1 = new File(null, "sample.txt", 50, LocalDateTime.now());
        File file2 = new File(null, "sample.txt", 50, LocalDateTime.now());
        Directory directory = new Directory(null, "dir");

        FSElementImplementation element1 = new FSElementImplementation(file1);
        FSElementImplementation element2 = new FSElementImplementation(file2);
        FSElementImplementation element3 = new FSElementImplementation(directory);

        // Test the equals method
        assertTrue(element1.equals(element2));
        assertFalse(element1.equals(element3));
    }
}
