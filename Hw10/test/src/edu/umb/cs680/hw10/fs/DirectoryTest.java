/*
 * The DirectoryTest class contains JUnit tests for the Directory class, covering various methods and scenarios.
 */

package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    // Test case for addChild method in the Directory class
    @Test
    void appendChild() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent", LocalDateTime.now());

        // Create a child file
        File childFile = new File(parentDir, "child.txt", 50, LocalDateTime.now());

        // Add the child file to the parent directory
        parentDir.appendChild(childFile);

        // Check if the parent directory has the child file in its list of children
        assertTrue(parentDir.getChildren().contains(childFile));
    }

    // Test case for getChildren method in the Directory class
    @Test
    void getChildren() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent", LocalDateTime.now());

        // Create child files
        File childFile1 = new File(parentDir, "child1.txt", 50, LocalDateTime.now());
        File childFile2 = new File(parentDir, "child2.txt", 70, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.appendChild(childFile1);
        parentDir.appendChild(childFile2);

        // Create expected FSElementImplementation proxies
        FSElementImplementation proxy1 = new FSElementImplementation(childFile1);
        FSElementImplementation proxy2 = new FSElementImplementation(childFile2);

        // Create a list of expected proxies
        LinkedList<FSElementImplementation> expectedChildren = new LinkedList<>();
        expectedChildren.add(proxy1);
        expectedChildren.add(proxy2);

        // Get the actual list of children from the parent directory
        LinkedList<FSElement> actualChildren = parentDir.getChildren();

        // Convert the actual list to a list of FSElementImplementation proxies
        LinkedList<FSElementImplementation> actualProxies = new LinkedList<>();
        for (FSElement child : actualChildren) {
            actualProxies.add(new FSElementImplementation(child));
        }

        // Compare the actual and expected lists
        assertEquals(expectedChildren, actualProxies);
    }


    // Test case for getName method in the Directory class
    @Test
    void getName() {
        Directory directory = new Directory(null, "testDir",LocalDateTime.now());
        assertEquals("testDir", directory.getName());
    }

    // Test case for getSize method in the Directory class
    @Test
    void getSize() {
        Directory directory = new Directory(null, "testDir",LocalDateTime.now());
        assertEquals(0, directory.getSize()); // Adjust the expected size based on your implementation logic
    }

    // Test case for getCreationTime method in the Directory class
    @Test
    void getCreationTime() {
        Directory directory = new Directory(null, "testDir",LocalDateTime.now());
        assertNotNull(directory.getCreationTime());
    }

    // Test case for isDirectory method in the Directory class
    @Test
    void isDirectory() {
        Directory directory = new Directory(null, "testDir",LocalDateTime.now());
        assertTrue(directory.isDirectory());
    }

    // Test case for getParent method in the Directory class
    @Test
    void getParent() {
        Directory parent = new Directory(null, "parentDir",LocalDateTime.now());
        Directory child = new Directory(parent, "childDir",LocalDateTime.now());

        assertEquals(parent, child.getParent());
    }

    // Test case for accept method in the Directory class
    @Test
    void accept() {
        // Create a custom implementation of FSVisitor for testing
        FSVisitorTestImpl visitor = new FSVisitorTestImpl();

        // Create a Directory instance
        Directory directory = new Directory(null, "testDir",LocalDateTime.now());

        // Call accept on the directory with the custom visitor
        directory.accept(visitor);

        // Verify that the visit method of the custom visitor was called with the directory
        assertTrue(visitor.isVisitCalled());
    }

    // Custom implementation of FSVisitor for testing
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
