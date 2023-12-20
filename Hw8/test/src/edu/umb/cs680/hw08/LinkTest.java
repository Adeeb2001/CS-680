package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    // Test Method: getName()
    // This test method checks the correctness of the getName() method in the Link class.
    // It creates a target File with the name "target.txt" and size 100, creates a Link with the name "link.txt", size 50, a creation time,
    // and a target file, and then asserts that calling getName() on the Link should return the expected link name "link.txt".
    @Test
    void getName() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        Link B = new Link("B.txt", 50, LocalDateTime.now(), A);
        assertEquals("B.txt", B.getName());
    }

    // Test Method: getSize()
    // This test method checks the correctness of the getSize() method in the Link class.
    // It creates a target File with the name "target.txt" and size 100, creates a Link with the name "link.txt", size 50, a creation time,
    // and a target file, and then asserts that calling getSize() on the Link should return the expected size 50.
    @Test
    void getSize() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        Link B = new Link("B.txt", 50, LocalDateTime.now(), A);
        assertEquals(50, B.getSize());
    }

    // Test Method: getCreationTime()
    // This test method checks the correctness of the getCreationTime() method in the Link class.
    // It creates a target File with the name "target.txt" and size 100, creates a Link with the name "link.txt", size 50, a creation time,
    // and a target file, and then asserts that calling getCreationTime() on the Link should return a non-null value.
    @Test
    void getCreationTime() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        Link B = new Link("B.txt", 50, LocalDateTime.now(), A);
        assertNotNull(B.getCreationTime());
    }

    // Test Method: isDirectory()
    // This test method checks the correctness of the isDirectory() method in the Link class.
    // It creates a target File with the name "target.txt" and size 100, creates a Link with the name "link.txt", size 50, a creation time,
    // and a target file, and then asserts that calling isDirectory() on the Link should return false.
    @Test
    void isDirectory() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        Link B = new Link("link.txt", 50, LocalDateTime.now(), A);
        assertFalse(B.isDirectory());
    }

    // Test Method: isLink()
    // This test method checks the correctness of the isLink() method in the Link class.
    // It creates a target File with the name "target.txt" and size 100, creates a Link with the name "link.txt", size 50, a creation time,
    // and a target file, and then asserts that calling isLink() on the Link should return true.
    @Test
    void isLink() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        Link B = new Link("link.txt", 50, LocalDateTime.now(), A);
        assertTrue(B.isLink());
    }

}