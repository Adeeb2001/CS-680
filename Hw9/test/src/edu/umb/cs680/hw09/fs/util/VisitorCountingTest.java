package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VisitorCountingTest {

    @Test
    void testVisit() {
        // Create a VisitorCounting
        CountingVisitor visitorCounting = new CountingVisitor();

        // Create a sample file system structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        Directory srcDir = new Directory(rootDir, "srcDir", LocalDateTime.now());
        File file1 = new File(srcDir, "file1.txt", 100, LocalDateTime.now());
        Link link1 = new Link(rootDir, "link1", 0, LocalDateTime.now(), file1);
        File file2 = new File(rootDir, "file2.txt", 150, LocalDateTime.now());

        // Add elements to the file system
        rootDir.appendChild(srcDir);
        srcDir.appendChild(file1);
        rootDir.appendChild(link1);
        rootDir.appendChild(file2);

        // Accept the VisitorCounting
        rootDir.accept(visitorCounting);

        // Check the counts
        assertEquals(2, visitorCounting.getDirNum());
        assertEquals(2, visitorCounting.getFileNum());
        assertEquals(1, visitorCounting.getLinkNum());
    }

    @Test
    void testGetDirNum() {
        // Create a VisitorCounting
        CountingVisitor visitorCounting = new CountingVisitor();

        // Create a sample directory structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        Directory dir1 = new Directory(rootDir, "dir1", LocalDateTime.now());
        Directory dir2 = new Directory(rootDir, "dir2", LocalDateTime.now());
        File file1 = new File(rootDir, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(dir1, "file2.txt", 150, LocalDateTime.now());
        Link link1 = new Link(dir2, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the directory structure
        rootDir.appendChild(dir1);
        rootDir.appendChild(dir2);
        rootDir.appendChild(file1);
        dir1.appendChild(file2);
        dir2.appendChild(link1);

        // Accept the VisitorCounting
        rootDir.accept(visitorCounting);

        // Check the count of directories
        assertEquals(3, visitorCounting.getDirNum());
    }

    @Test
    void testGetFileNum() {
        // Create a VisitorCounting
        CountingVisitor visitorCounting = new CountingVisitor();

        // Create a sample file system structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        Directory srcDir = new Directory(rootDir, "srcDir", LocalDateTime.now());
        File file1 = new File(srcDir, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(rootDir, "file2.txt", 150, LocalDateTime.now());

        // Add elements to the file system
        rootDir.appendChild(srcDir);
        srcDir.appendChild(file1);
        rootDir.appendChild(file2);

        // Accept the VisitorCounting
        rootDir.accept(visitorCounting);

        // Check the count of files
        assertEquals(2, visitorCounting.getFileNum());
    }

    @Test
    void testGetLinkNum() {
        // Create a VisitorCounting
        CountingVisitor visitorCounting = new CountingVisitor();

        // Create a sample file system structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        File file1 = new File(rootDir, "file1.txt", 100, LocalDateTime.now());
        Link link1 = new Link(rootDir, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        rootDir.appendChild(file1);
        rootDir.appendChild(link1);

        // Accept the VisitorCounting
        rootDir.accept(visitorCounting);

        // Check the count of links
        assertEquals(1, visitorCounting.getLinkNum());
    }

    @Test
    void testCountImmediateChildren() {
    }
}
