package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class DirectoryTest
 * Contains tests for the Directory class.
 */
class DirectoryTest {

    /**
     * Method addChild
     * Tests the addChild method of the Directory class.
     */
    @Test
    void addChild() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "mainFolder");

        // Create a child file
        File childFile = new File(parentDir, "subFile.txt", 50, LocalDateTime.now());

        // Add the child file to the parent directory
        parentDir.addChild(childFile);

        FSElementImplementation file = new FSElementImplementation(childFile);

        // Check if the parent directory has the proxy for the child file
        assertTrue(parentDir.getChildren().contains(file));
    }

    /**
     * Method getChildren
     * Tests the getChildren method of the Directory class.
     */
    @Test
    void getChildren() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "mainFolder");

        // Create child files
        File childFile1 = new File(parentDir, "documentA.txt", 50, LocalDateTime.now());
        File childFile2 = new File(parentDir, "documentB.txt", 70, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.addChild(childFile1);
        parentDir.addChild(childFile2);

        // Create expected FSElementImplementation proxies
        FSElementImplementation proxy1 = new FSElementImplementation(childFile1);
        FSElementImplementation proxy2 = new FSElementImplementation(childFile2);

        // Create a list of expected proxies
        LinkedList<FSElementImplementation> expectedChildren = new LinkedList<>();
        expectedChildren.add(proxy1);
        expectedChildren.add(proxy2);

        // Get the actual list of children from the parent directory
        LinkedList<FSElementImplementation> actualChildren = parentDir.getChildren();

        // Compare the actual and expected lists
        assertEquals(expectedChildren, actualChildren);
    }

    /**
     * Method getName
     * Tests the getName method of the Directory class.
     */
    @Test
    void getName() {
        Directory directory = new Directory(null, "testFolder");
        assertEquals("testFolder", directory.getName());
    }

    /**
     * Method getSize
     * Tests the getSize method of the Directory class.
     */
    @Test
    void getSize() {
        Directory directory = new Directory(null, "testFolder");
        assertEquals(0, directory.getSize()); // Adjust the expected size based on your implementation logic
    }

    /**
     * Method getCreationTime
     * Tests the getCreationTime method of the Directory class.
     */
    @Test
    void getCreationTime() {
        Directory directory = new Directory(null, "testFolder");
        assertNotNull(directory.getCreationTime());
    }

    /**
     * Method isDirectory
     * Tests the isDirectory method of the Directory class.
     */
    @Test
    void isDirectory() {
        Directory directory = new Directory(null, "testFolder");
        assertTrue(directory.isDirectory());
    }

    /**
     * Method getParent
     * Tests the getParent method of the Directory class.
     */
    @Test
    void getParent() {
        Directory parent = new Directory(null, "parentFolder");
        Directory child = new Directory(parent, "childFolder");

        assertEquals(parent, child.getParent());
    }

    /**
     * Method accept
     * Tests the accept method of the Directory class.
     */
    @Test
    void accept() {
        // Create a custom implementation of FSVisitor for testing
        FSVisitorTestImpl visitor = new FSVisitorTestImpl();

        // Create a Directory instance
        Directory directory = new Directory(null, "testFolder");

        // Call accept on the directory with the custom visitor
        directory.accept(visitor);

        // Verify that the visit method of the custom visitor was called with the directory
        assertTrue(visitor.isVisitCalled());
    }

    /**
     * Class FSVisitorTestImpl
     * Custom implementation of FSVisitor for testing purposes.
     */
    class FSVisitorTestImpl implements FSVisitor {
        private boolean visitCalled = false;

        @Override
        public void visit(Directory dir) {
            visitCalled = true;
        }

        @Override
        public void visit(File file) {
            // Do nothing for files
        }

        @Override
        public void visit(Link link) {
            // Do nothing for links
        }

        // Getter method to check if visit was called
        public boolean isVisitCalled() {
            return visitCalled;
        }
    }
}
