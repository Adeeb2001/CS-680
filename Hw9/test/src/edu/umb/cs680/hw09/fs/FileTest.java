package edu.umb.cs680.hw09.fs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void getName() {
        // Create a file with a name
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 120, LocalDateTime.now());

        // Ensure that getName returns the correct name
        assertEquals("testFile.txt", file.getName());
    }

    @Test
    void getSize() {
        // Create a file with a size
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 180, LocalDateTime.now());

        // Ensure that getSize returns the correct size
        assertEquals(180, file.getSize());
    }

    @Test
    void getCreationTime() {
        // Create a file
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 120, LocalDateTime.of(2023, 3, 15, 9, 30));

        // Ensure that getCreationTime returns the correct creation time
        assertEquals(LocalDateTime.of(2023, 3, 15, 9, 30), file.getCreationTime());
    }

    @Test
    void isDirectory() {
        // Create a file
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 120, LocalDateTime.now());

        // Ensure that isDirectory returns false for files
        assertFalse(file.isDirectory());
    }

    @Test
    void accept() {
        // Create a file
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 120, LocalDateTime.now());

        // Ensure that accept does not throw an exception
        assertDoesNotThrow(() -> file.accept(new TestVisitor()));
    }

    @Test
    void getParent() {
        // Create a file with a parent directory
        Directory parent = new Directory(null, "parentDir", LocalDateTime.now());
        File file = new File(parent, "testFile.txt", 120, LocalDateTime.now());

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
