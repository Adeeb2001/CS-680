package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void addChild() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parentDir");

        // Create a child file
        File childFile = new File(parentDir, "childFile.txt", 120, LocalDateTime.now());

        // Add the child file to the parent directory
        parentDir.addChild(childFile);

        FSElementImpl file = new FSElementImpl(childFile);
        // Check if the parent directory has the proxy for the child file
        assertTrue(parentDir.getChildren().contains(file));
    }

    @Test
    void getChildren() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent");

        // Create child files
        File childFile1 = new File(parentDir, "child1.txt", 120, LocalDateTime.now());
        File childFile2 = new File(parentDir, "child2.txt", 180, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.addChild(childFile1);
        parentDir.addChild(childFile2);

        // Create expected FSElementImplementation proxies
        FSElementImpl proxy1 = new FSElementImpl(childFile1);
        FSElementImpl proxy2 = new FSElementImpl(childFile2);

        // Create a list of expected proxies
        LinkedList<FSElementImpl> expectedChildren = new LinkedList<>();
        expectedChildren.add(proxy1);
        expectedChildren.add(proxy2);

        // Get the actual list of children from the parent directory
        LinkedList<FSElementImpl> actualChildren = parentDir.getChildren();

        // Compare the actual and expected lists
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void getName() {
        Directory directory = new Directory(null, "testDir");
        assertEquals("testDir", directory.getName());
    }

    @Test
    void getSize() {
        Directory directory = new Directory(null, "testDir");
        assertEquals(0, directory.getSize());
    }

    @Test
    void getCreationTime() {
        Directory directory = new Directory(null, "testDir");
        assertNotNull(directory.getCreationTime());
    }

    @Test
    void isDirectory() {
        Directory directory = new Directory(null, "testDir");
        assertTrue(directory.isDirectory());
    }

    @Test
    void getParent() {
        Directory parent = new Directory(null, "parentDir");
        Directory child = new Directory(parent, "childDir");

        assertEquals(parent, child.getParent());
    }

    @Test
    void sortChildrenAlphabetically() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent");

        // Create child files with different names
        File file1 = new File(parentDir, "fileB.txt", 120, LocalDateTime.now());
        File file2 = new File(parentDir, "fileA.txt", 180, LocalDateTime.now());
        File file3 = new File(parentDir, "fileC.txt", 150, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        // Sort the children alphabetically
        parentDir.sortChildrenAlphabetically();

        // Get the sorted list of children
        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        // Check if the order is correct
        assertEquals("fileA.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("fileB.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("fileC.txt", sortedChildren.get(2).getRealFSElement().getName());
    }

    @Test
    void sortChildrenReverseAlphabetically() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent");

        // Create child files with different names
        File file1 = new File(parentDir, "fileB.txt", 120, LocalDateTime.now());
        File file2 = new File(parentDir, "fileA.txt", 180, LocalDateTime.now());
        File file3 = new File(parentDir, "fileC.txt", 150, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        // Sort the children in reverse alphabetical order
        parentDir.sortChildrenReverseAlphabetically();

        // Get the sorted list of children
        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        // Check if the order is correct
        assertEquals("fileC.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("fileB.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("fileA.txt", sortedChildren.get(2).getRealFSElement().getName());
    }

    @Test
    void sortChildrenBySize() {
        // Create a parent directory
        Directory parentDir = new Directory(null, "parent");

        // Create child files with different sizes
        File file1 = new File(parentDir, "file1.txt", 120, LocalDateTime.now());
        File file2 = new File(parentDir, "file2.txt", 180, LocalDateTime.now());
        File file3 = new File(parentDir, "file3.txt", 150, LocalDateTime.now());

        // Add the child files to the parent directory
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        // Sort the children by size
        parentDir.sortChildrenBySize();

        // Get the sorted list of children
        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        // Check if the order is correct
        assertEquals("file1.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("file3.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("file2.txt", sortedChildren.get(2).getRealFSElement().getName());
    }
}
