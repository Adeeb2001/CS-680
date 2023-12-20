package edu.umb.cs680.hw17;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void addChild() {
        Directory parentDir = new Directory(null, "parentDir");
        File childFile = new File(parentDir, "childDocument.doc", 80, LocalDateTime.now());
        parentDir.addChild(childFile);

        FSElementImpl file = new FSElementImpl(childFile);
        assertTrue(parentDir.getChildren().contains(file));
    }

    @Test
    void getChildren() {
        Directory parentDir = new Directory(null, "parentDir");
        File childFile1 = new File(parentDir, "child1Document.doc", 80, LocalDateTime.now());
        File childFile2 = new File(parentDir, "child2Spreadsheet.xls", 120, LocalDateTime.now());
        parentDir.addChild(childFile1);
        parentDir.addChild(childFile2);

        FSElementImpl proxy1 = new FSElementImpl(childFile1);
        FSElementImpl proxy2 = new FSElementImpl(childFile2);

        LinkedList<FSElementImpl> expectedChildren = new LinkedList<>();
        expectedChildren.add(proxy1);
        expectedChildren.add(proxy2);

        LinkedList<FSElementImpl> actualChildren = parentDir.getChildren();

        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void getName() {
        Directory directory = new Directory(null, "testDirectory");
        assertEquals("testDirectory", directory.getName());
    }

    @Test
    void getSize() {
        Directory directory = new Directory(null, "testDirectory");
        assertEquals(0, directory.getSize());
    }

    @Test
    void getCreationTime() {
        Directory directory = new Directory(null, "testDirectory");
        assertNotNull(directory.getCreationTime());
    }

    @Test
    void isDirectory() {
        Directory directory = new Directory(null, "testDirectory");
        assertTrue(directory.isDirectory());
    }

    @Test
    void getParent() {
        Directory parent = new Directory(null, "parentDir");
        Directory child = new Directory(parent, "childDirectory");
        assertEquals(parent, child.getParent());
    }

    @Test
    void sortChildrenAlphabetically() {
        Directory parentDir = new Directory(null, "parentDir");
        File file1 = new File(parentDir, "apple.txt", 60, LocalDateTime.now());
        File file2 = new File(parentDir, "banana.txt", 80, LocalDateTime.now());
        File file3 = new File(parentDir, "cherry.txt", 70, LocalDateTime.now());
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        parentDir.sortChildrenAlphabetically();

        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        assertEquals("apple.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("banana.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("cherry.txt", sortedChildren.get(2).getRealFSElement().getName());
    }

    @Test
    void sortChildrenReverseAlphabetically() {
        Directory parentDir = new Directory(null, "parentDir");
        File file1 = new File(parentDir, "apple.txt", 60, LocalDateTime.now());
        File file2 = new File(parentDir, "banana.txt", 80, LocalDateTime.now());
        File file3 = new File(parentDir, "cherry.txt", 70, LocalDateTime.now());
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        parentDir.sortChildrenReverseAlphabetically();

        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        assertEquals("cherry.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("banana.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("apple.txt", sortedChildren.get(2).getRealFSElement().getName());
    }

    @Test
    void sortChildrenBySize() {
        Directory parentDir = new Directory(null, "parentDir");
        File file1 = new File(parentDir, "small.txt", 40, LocalDateTime.now());
        File file2 = new File(parentDir, "medium.txt", 60, LocalDateTime.now());
        File file3 = new File(parentDir, "large.txt", 80, LocalDateTime.now());
        parentDir.addChild(file1);
        parentDir.addChild(file2);
        parentDir.addChild(file3);

        parentDir.sortChildrenBySize();

        LinkedList<FSElementImpl> sortedChildren = parentDir.getChildren();

        assertEquals("small.txt", sortedChildren.get(0).getRealFSElement().getName());
        assertEquals("medium.txt", sortedChildren.get(1).getRealFSElement().getName());
        assertEquals("large.txt", sortedChildren.get(2).getRealFSElement().getName());
    }
}
