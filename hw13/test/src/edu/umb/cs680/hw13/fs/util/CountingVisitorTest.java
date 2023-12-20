package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class CountingVisitorTest
 * Contains tests for the CountingVisitor class.
 */
class CountingVisitorTest {

    /**
     * Method visit
     * Tests the visit method of the CountingVisitor.
     */
    @Test
    void visit() {
        // Create a CountingVisitor with modified names and sizes
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure with modified names
        Directory root = new Directory(null, "main");
        Directory src = new Directory(root, "source");
        File file1 = new File(src, "documentA.txt", 200, LocalDateTime.now());
        Link link1 = new Link(root, "shortcut1", 0, LocalDateTime.now(), file1);
        File file2 = new File(root, "documentB.txt", 250, LocalDateTime.now());

        // Add elements to the file system
        root.addChild(src);
        src.addChild(file1);
        root.addChild(link1);
        root.addChild(file2);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the counts
        assertEquals(2, countingVisitor.getDirNum());
        assertEquals(2, countingVisitor.getFileNum());
        assertEquals(1, countingVisitor.getLinkNum());
    }

    /**
     * Method getDirNum
     * Tests the getDirNum method of the CountingVisitor.
     */
    @Test
    void getDirNum() {
        // Create a CountingVisitor with modified names
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample directory structure with modified names
        Directory root = new Directory(null, "root");
        Directory dir1 = new Directory(root, "folderX");
        Directory dir2 = new Directory(root, "folderY");
        File file1 = new File(root, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(dir1, "documentB.txt", 250, LocalDateTime.now());
        Link link1 = new Link(dir2, "shortcut1", 0, LocalDateTime.now(), file1);

        // Add elements to the directory structure
        root.addChild(dir1);
        root.addChild(dir2);
        root.addChild(file1);
        dir1.addChild(file2);
        dir2.addChild(link1);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of directories
        assertEquals(3, countingVisitor.getDirNum());
    }

    /**
     * Method getFileNum
     * Tests the getFileNum method of the CountingVisitor.
     */
    @Test
    void getFileNum() {
        // Create a CountingVisitor with modified names and sizes
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure with modified names
        Directory root = new Directory(null, "root");
        Directory src = new Directory(root, "src");
        File file1 = new File(src, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(root, "documentB.txt", 250, LocalDateTime.now());

        // Add elements to the file system
        root.addChild(src);
        src.addChild(file1);
        root.addChild(file2);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of files
        assertEquals(2, countingVisitor.getFileNum());
    }

    /**
     * Method getLinkNum
     * Tests the getLinkNum method of the CountingVisitor.
     */
    @Test
    void getLinkNum() {
        // Create a CountingVisitor with modified names and sizes
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure with modified names
        Directory root = new Directory(null, "root");
        File file1 = new File(root, "documentA.txt", 200, LocalDateTime.now());
        Link link1 = new Link(root, "shortcut1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.addChild(file1);
        root.addChild(link1);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of links
        assertEquals(1, countingVisitor.getLinkNum());
    }

    // The test for countImmediateChildren is missing in the provided code.
}
