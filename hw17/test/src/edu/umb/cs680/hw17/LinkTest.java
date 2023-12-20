package edu.umb.cs680.hw17;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    @Test
    void getName() {
        // Create a link with a name
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Test if getName returns the correct name
        assertEquals("testLink", link.getName());
    }

    @Test
    void getSize() {
        // Create a link with a size
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Test if getSize returns the correct size
        assertEquals(0, link.getSize());
    }

    @Test
    void getCreationTime() {
        // Create a link
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.of(2022, 1, 1, 12, 0), targetFile);

        // Test if getCreationTime returns the correct creation time
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), link.getCreationTime());
    }

    @Test
    void isDirectory() {
        // Create a link
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Test if isDirectory returns false for links
        assertFalse(link.isDirectory());
    }

    @Test
    void isLink() {
        // Create a link
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Test if isLink returns true for links
        assertTrue(link.isLink());
    }

    @Test
    void getTarget() {
        // Create a link with a target file
        Directory parent = new Directory(null, "testDirectory");
        File targetFile = new File(parent, "targetFile.txt", 100, LocalDateTime.now());
        Link link = new Link(parent, "testLink", 0, LocalDateTime.now(), targetFile);

        // Test if getTarget returns the correct target file
        assertEquals(targetFile, link.getTarget().getRealFSElement());
    }
}
