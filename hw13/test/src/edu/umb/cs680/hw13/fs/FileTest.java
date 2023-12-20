package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class FileTest
 * Contains tests for the File class.
 */
class FileTest {

    /**
     * Method getName
     * Tests the getName method of the File class.
     */
    @Test
    void getName() {
        // Create a file with a name
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Ensure that getName returns the correct name
        assertEquals("testFile.txt", file.getName());
    }

    /**
     * Method getSize
     * Tests the getSize method of the File class.
     */
    @Test
    void getSize() {
        // Create a file with a size
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 150, LocalDateTime.now());

        // Ensure that getSize returns the correct size
        assertEquals(150, file.getSize());
    }

    /**
     * Method getCreationTime
     * Tests the getCreationTime method of the File class.
     */
    @Test
    void getCreationTime() {
        // Create a file
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.of(2022, 1, 1, 12, 0));

        // Ensure that getCreationTime returns the correct creation time
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), file.getCreationTime());
    }

    /**
     * Method isDirectory
     * Tests the isDirectory method of the File class.
     */
    @Test
    void isDirectory() {
        // Create a file
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Ensure that isDirectory returns false for files
        assertFalse(file.isDirectory());
    }

    /**
     * Method accept
     * Tests the accept method of the File class.
     */
    @Test
    void accept() {
        // Create a file
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Ensure that accept does not throw an exception
        assertDoesNotThrow(() -> file.accept(new TestVisitor()));
    }

    /**
     * Method getParent
     * Tests the getParent method of the File class.
     */
    @Test
    void getParent() {
        // Create a file with a parent directory
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Ensure that getParent returns the correct parent directory
        assertSame(parent, file.getParent());
    }

    // Custom test visitor class for testing accept method
    private static class TestVisitor implements FSVisitor {
        @Override
        public void visit(Link link) {
            // Do nothing
        }

        @Override
        public void visit(Directory directory) {
            // Do nothing
        }

        @Override
        public void visit(File file) {
            // Do nothing
        }
    }
}
