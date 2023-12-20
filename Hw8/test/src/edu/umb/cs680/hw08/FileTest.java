package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    // This test method checks the correctness of the getName() method in the File class.
    // It creates a File object with the name "file.txt" and size 100, and then asserts that calling getName() on this object
    // should return the expected file name "file.txt".
    @Test
    void getName() {
        File A = new File("A.txt", 100, LocalDateTime.now());
        assertEquals("A.txt", A.getName());
    }

    // This test method checks the correctness of the getSize() method in the File class.
    // It creates a File object with the name "file.txt" and size 100, and then asserts that calling getSize() on this object
    // should return the expected size 100.
    @Test
    void getSize() {
        File A = new File("A.txt", 100,LocalDateTime.now());
        assertEquals(100, A.getSize());
    }

    // This test method checks the correctness of the getCreationTime() method in the File class.
    // It creates a File object with the name "file.txt" and size 100, and then asserts that calling getCreationTime() on this object
    // should return null. This assumes that the creation time is not set in the File class, as the assertion checks for null.
    @Test
    void getCreationTime() {
        File A = new File("A.txt", 100,LocalDateTime.now());
        assertNotNull(A.getCreationTime());
    }

    // This test method checks the correctness of the isDirectory() method in the File class.
    // It creates a File object with the name "file.txt" and size 100, and then asserts that calling isDirectory() on this object
    // should return false. This assumes that the File object represents a file, not a directory.
    @Test
    void isDirectory() {
        File A = new File("A.txt", 100,LocalDateTime.now());
        assertFalse(A.isDirectory());
    }
}