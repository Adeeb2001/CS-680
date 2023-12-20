/*
 * The LinkTest class contains JUnit tests for the Link class, covering various methods and scenarios.
 */

package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    // Test case for getName method in the Link class
    @Test
    void getName() {
        // Create a link with a name
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that getName returns the correct name
        assertEquals("testLink", link.getName());
    }

    // Test case for getSize method in the Link class
    @Test
    void getSize() {
        // Create a link with a size
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that getSize returns the correct size
        assertEquals(0, link.getSize());
    }

    // Test case for getCreationTime method in the Link class
    @Test
    void getCreationTime() {
        // Create a link
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.of(2022, 1, 1, 12, 0), targetFile);

        // Ensure that getCreationTime returns the correct creation time
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), link.getCreationTime());
    }

    // Test case for isDirectory method in the Link class
    @Test
    void isDirectory() {
        // Create a link
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that isDirectory returns false for links
        assertFalse(link.isDirectory());
    }

    // Test case for accept method in the Link class
    @Test
    void accept() {
        // Create a link
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that accept does not throw an exception
        assertDoesNotThrow(() -> link.accept(new TestVisitor()));
    }

    // Test case for isLink method in the Link class
    @Test
    void isLink() {
        // Create a link
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that isLink returns true for links
        assertTrue(link.isLink());
    }

    // Test case for getTarget method in the Link class
    @Test
    void getTarget() {
        // Create a link with a target file
        Directory parent = new Directory(null, "testDir", LocalDateTime.now());
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Ensure that getTarget returns the correct target file
        // Ensure that getTarget returns the correct target file
        assertEquals(targetFile, link.getTarget());

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
