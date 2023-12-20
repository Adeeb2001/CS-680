package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void getName() {
        // Create a file with a name
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Test if getName returns the correct name
        assertEquals("testFile.txt", file.getName());
    }

    @Test
    void getSize() {
        // Create a file with a size
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 150, LocalDateTime.now());

        // Test if getSize returns the correct size
        assertEquals(150, file.getSize());
    }

    @Test
    void getCreationTime() {
        // Create a file
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.of(2022, 1, 1, 12, 0));

        // Test if getCreationTime returns the correct creation time
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), file.getCreationTime());
    }

    @Test
    void isDirectory() {
        // Create a file
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Test if isDirectory returns false for files
        assertFalse(file.isDirectory());
    }

    @Test
    void getParent() {
        // Create a file with a parent directory
        Directory parent = new Directory(null, "testDir");
        File file = new File(parent, "testFile.txt", 100, LocalDateTime.now());

        // Test if getParent returns the correct parent directory
        assertSame(parent, file.getParent());
    }
}
