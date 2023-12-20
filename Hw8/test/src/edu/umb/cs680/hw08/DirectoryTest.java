package edu.umb.cs680.hw08;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    /**
     * Test case for adding a child to a directory.
     * 1. Create a parent directory.
     * 2. Create a directory named "TestDirectory".
     * 3. Create a file named "file.txt" with a size of 100.
     * 4. Add the child file to the directory.
     * 5. Verify that the child file is present in the directory's children.
     */
    @Test
    void addChild() {
        // Create parent and directory
        Directory parent = new Directory("Parent", LocalDateTime.now());
        Directory directory = new Directory("TestDirectory", LocalDateTime.now());
        File file = new File("file.txt", 100, LocalDateTime.now());

        // Add child file to the directory
        parent.appendChild(directory);
        directory.appendChild(file);

        // Verify that the child file is in the directory's children
        assertTrue(directory.getChildren().contains(file));
    }

    /**
     * Test case for getting the children of a directory.
     * 1. Create a parent directory.
     * 2. Create a directory named "TestDirectory".
     * 3. Create two files, "file1.txt" with a size of 100 and "file2.txt" with a size of 150.
     * 4. Add the files to the directory.
     * 5. Verify the size and content of the directory's children.
     */
    @Test
    void getChildren() {
        // Create parent and directory
        Directory parent = new Directory("Parent",LocalDateTime.now());
        Directory directory = new Directory("TestDirectory",LocalDateTime.now());
        File file1 = new File("file1.txt", 100,LocalDateTime.now());
        File file2 = new File("file2.txt", 150,LocalDateTime.now());

        // Add files to the directory
        parent.appendChild(directory);
        directory.appendChild(file1);
        directory.appendChild(file2);

        // Verify the size and content of the directory's children
        assertEquals(2, directory.getChildren().size());
        assertTrue(directory.getChildren().contains(file1));
        assertTrue(directory.getChildren().contains(file2));
    }

    /**
     * Test case for getting the name of a directory.
     * 1. Create a directory named "TestDirectory".
     * 2. Verify the name of the directory.
     */
    @Test
    void getName() {
        // Create directory
        Directory directory = new Directory("TestDirectory",LocalDateTime.now());

        // Verify the name of the directory
        assertEquals("TestDirectory", directory.getName());
    }

    /**
     * Test case for getting the size of a directory.
     * 1. Create a directory named "TestDirectory".
     * 2. Create two files, "file1.txt" with a size of 100 and "file2.txt" with a size of 150.
     * 3. Add the files to the directory.
     * 4. Verify the total size of the directory.
     */
    @Test
    void getSize() {
        // Create directory and files
        Directory directory = new Directory("TestDirectory",LocalDateTime.now());
        File file1 = new File("file1.txt", 100,LocalDateTime.now());
        File file2 = new File("file2.txt", 150,LocalDateTime.now());

        // Add files to the directory
        directory.appendChild(file1);
        directory.appendChild(file2);

        // Verify the total size of the directory
        assertEquals(250, directory.getSize());
    }

    /**
     * Test case for getting the creation time of a directory.
     * 1. Create a directory named "TestDirectory".
     * 2. Verify that the creation time is not null.
     */
    @Test
    void getCreationTime() {
        // Create directory
        Directory directory = new Directory("TestDirectory",LocalDateTime.now());

        // Verify that the creation time is not null
        assertNotNull(directory.getCreationTime());
    }

    /**
     * Test case for checking if an object represents a directory.
     * 1. Create a directory named "TestDirectory".
     * 2. Verify that the object represents a directory.
     */
    @Test
    void isDirectory() {
        // Create directory
        Directory directory = new Directory("TestDirectory",LocalDateTime.now());

        // Verify that the object represents a directory
        assertTrue(directory.isDirectory());
    }
}
