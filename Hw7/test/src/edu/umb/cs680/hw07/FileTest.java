package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


/**
 * The FileTest class contains JUnit tests for the File class.
 * It covers various methods of the File class to ensure their correctness.
 */
class FileTest {

    /**
     * Test for the getParent method.
     * Verifies that the getParent method returns the correct parent directory.
     */
    @Test
    void getParent() {
        Directory parent = new Directory(null, "ParentDirectory", LocalDateTime.now());
        File file = new File(parent, "TestFile.txt", 100, LocalDateTime.now());
        assertEquals(parent, file.getParent());
    }

    /**
     * Test for the getSize method.
     * Verifies that the getSize method returns the correct size of the file.
     */
    @Test
    void getSize() {
        File file = new File(null, "TestFile.txt", 150, LocalDateTime.now());
        assertEquals(150, file.getSize());
    }

    /**
     * Test for the getName method.
     * Verifies that the getName method returns the correct name of the file.
     */
    @Test
    void getName() {
        File file = new File(null, "TestFile.txt", 200, LocalDateTime.now());
        assertEquals("TestFile.txt", file.getName());
    }

    /**
     * Test for the getCreationTime method.
     * Verifies that the getCreationTime method returns the correct creation time of the file.
     */
    @Test
    void getCreationTime() {
        LocalDateTime creationTime = LocalDateTime.of(2023, 1, 1, 12, 0);
        File file = new File(null, "TestFile.txt", 200, creationTime);
        assertEquals(creationTime, file.getCreationTime());
    }

    /**
     * Test for the isDirectory method.
     * Verifies that the isDirectory method returns false for a File object.
     */
    @Test
    void isDirectory() {
        File file = new File(null, "TestFile.txt", 200, LocalDateTime.now());
        assertFalse(file.isDirectory());
    }
}
