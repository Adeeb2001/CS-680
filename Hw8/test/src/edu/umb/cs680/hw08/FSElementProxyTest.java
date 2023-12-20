package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// Class: FSElementProxyTest
// This class is a JUnit test class for the FSElementProxy class, which likely acts as a
// proxy for various file system elements.
class FSElementProxyTest {

    // Test Method: getName()
    // This test method checks the correctness of the getName() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a File) with the name "file.txt" and size 100, creates a proxy for it, and then
    // asserts that calling getName() on the proxy should return the expected file name "file.txt".
    @Test
    void getName() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        FSElementProxy proxy = new FSElementProxy(A);
        assertEquals("A.txt", proxy.getName());
    }

    // Test Method: getSize()
    // This test method checks the correctness of the getSize() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a File) with the name "file.txt" and size 100, creates a proxy for it, and then
    // asserts that calling getSize() on the proxy should return the expected size 100.
    @Test
    void getSize() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        FSElementProxy proxy = new FSElementProxy(A);
        assertEquals(100, proxy.getSize());
    }

    // Test Method: getCreationTime()
    // This test method checks the correctness of the getCreationTime() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a File) with the name "file.txt" and size 100, creates a proxy for it, and then
    // asserts that calling getCreationTime() on the proxy should return null. This assumes that the creation time is not set in FSElementProxy.
    @Test
    void getCreationTime() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        FSElementProxy proxy = new FSElementProxy(A);
        assertNotNull(proxy.getCreationTime());
    }

    // Test Method: isDirectory()
    // This test method checks the correctness of the isDirectory() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a File) with the name "file.txt" and size 100, creates a proxy for it, and then
    // asserts that calling isDirectory() on the proxy should return false.
    @Test
    void isDirectory() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        FSElementProxy proxy = new FSElementProxy(A);
        assertFalse(proxy.isDirectory());
    }

    // Test Method: isLinked()
    // This test method checks the correctness of the isLinked() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a Link) with the name "link.txt" and size 50, a target file, and a creation time,
    // creates a proxy for it, and then asserts that calling isLinked() on the proxy should return true.
    @Test
    void isLinked() {
        FSElement B = new Link("B.txt", 50, LocalDateTime.now(), new File("target.txt", 100,LocalDateTime.now()));
        FSElementProxy proxy = new FSElementProxy(B);
        assertTrue(proxy.isLinked());
    }

    // Test Method: getRealFSElement()
    // This test method checks the correctness of the getRealFSElement() method in the FSElementProxy class.
    // It creates a real FSElement (assumed to be a File) with the name "file.txt" and size 100, creates a proxy for it, and then
    // asserts that calling getRealFSElement() on the proxy should return the original real FSElement.
    @Test
    void getRealFSElement() {
        FSElement A = new File("A.txt", 100,LocalDateTime.now());
        FSElementProxy proxy = new FSElementProxy(A);
        assertSame(A, proxy.getRealFSElement());
    }

}