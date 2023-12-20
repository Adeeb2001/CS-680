package edu.umb.cs680.hw07;

/**
 * The DirectoryTest class contains JUnit tests for the Directory class.
 * It covers various methods of the Directory class to ensure their correctness.
 */
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    /**
     * Test for the getName method.
     * Verifies that the getName method returns the correct name of the directory.
     */
    @Test
    void getName() {
        Directory directory = new Directory(null, "TestDirectory", LocalDateTime.now());
        assertEquals("TestDirectory", directory.getName());
    }

    /**
     * Test for the getSize method.
     * (To be implemented as needed.)
     */
    @Test
    void getSize() {
        // Test implementation pending
    }

    /**
     * Test for the getCreationTime method.
     * Verifies that the getCreationTime method returns null in this case.
     */
    @Test
    void getCreationTime() {
        Directory directory = new Directory(null, "TestDirectory", LocalDateTime.now());
        assertNotNull(directory.getCreationTime());
    }

    /**
     * Test for the getParent method.
     * Verifies that the getParent method returns the correct parent directory.
     */
    @Test
    void getParent() {
        Directory parent = new Directory(null, "ParentDirectory", LocalDateTime.now());
        Directory child = new Directory(parent, "ChildDirectory", LocalDateTime.now());
        assertEquals(parent, child.getParent());
    }

    /**
     * Test for the isDirectory method.
     * Verifies that the isDirectory method returns true for a directory.
     */
    @Test
    void isDirectory() {
        Directory directory = new Directory(null, "TestDirectory", LocalDateTime.now());
        assertTrue(directory.isDirectory());
    }

    /**
     * Test for the getChildren method.
     * Verifies that the getChildren method returns the correct list of child directories.
     */
    @Test
    void getChildren() {
        Directory parent = new Directory(null, "ParentDirectory", LocalDateTime.now());
        Directory child1 = new Directory(parent, "ChildDirectory1", LocalDateTime.now());
        Directory child2 = new Directory(parent, "ChildDirectory2", LocalDateTime.now());

        parent.appendChild(child1);
        parent.appendChild(child2);

        assertEquals(2, parent.getChildren().size());
        assertTrue(parent.getChildren().contains(child1));
        assertTrue(parent.getChildren().contains(child2));
    }

    /**
     * Test for the appendChild method.
     * Verifies that the appendChild method adds a child directory correctly.
     */
    @Test
    void appendChild() {
        Directory parent = new Directory(null, "ParentDirectory", LocalDateTime.now());
        Directory child = new Directory(parent, "ChildDirectory", LocalDateTime.now());

        parent.appendChild(child);

        assertEquals(1, parent.getChildren().size());
        assertTrue(parent.getChildren().contains(child));
        assertEquals(parent, child.getParent());
    }

}
