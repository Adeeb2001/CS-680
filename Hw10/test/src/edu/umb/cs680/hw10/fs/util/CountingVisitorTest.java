package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    @Test
    void visit() {
        // Create a CountingVisitor
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure
        Directory root = new Directory(null, "root",LocalDateTime.now());
        Directory src = new Directory(root, "src",LocalDateTime.now());
        File file1 = new File(src, "file1.txt", 100, LocalDateTime.now());
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);
        File file2 = new File(root, "file2.txt", 150, LocalDateTime.now());

        // Add elements to the file system
        root.appendChild(src);
        src.appendChild(file1);
        root.appendChild(link1);
        root.appendChild(file2);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the counts
        assertEquals(2, countingVisitor.getDirNum());
        assertEquals(2, countingVisitor.getFileNum());
        assertEquals(1, countingVisitor.getLinkNum());
    }


    @Test
    void getDirNum() {
        // Create a CountingVisitor
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample directory structure
        Directory root = new Directory(null, "root",LocalDateTime.now());
        Directory dir1 = new Directory(root, "dir1",LocalDateTime.now());
        Directory dir2 = new Directory(root, "dir2",LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(dir1, "file2.txt", 150, LocalDateTime.now());
        Link link1 = new Link(dir2, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the directory structure
        root.appendChild(dir1);
        root.appendChild(dir2);
        root.appendChild(file1);
        dir1.appendChild(file2);
        dir2.appendChild(link1);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of directories
        assertEquals(3, countingVisitor.getDirNum());
    }

    @Test
    void getFileNum() {
        // Create a CountingVisitor
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure
        Directory root = new Directory(null, "root",LocalDateTime.now());
        Directory src = new Directory(root, "src",LocalDateTime.now());
        File file1 = new File(src, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(root, "file2.txt", 150, LocalDateTime.now());

        // Add elements to the file system
        root.appendChild(src);
        src.appendChild(file1);
        root.appendChild(file2);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of files
        assertEquals(2, countingVisitor.getFileNum());
    }

    @Test
    void getLinkNum() {
        // Create a CountingVisitor
        CountingVisitor countingVisitor = new CountingVisitor();

        // Create a sample file system structure
        Directory root = new Directory(null, "root",LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.appendChild(file1);
        root.appendChild(link1);

        // Accept the CountingVisitor
        root.accept(countingVisitor);

        // Check the count of links
        assertEquals(1, countingVisitor.getLinkNum());
    }

    @Test
    void countImmediateChildren() {
    }
}