package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    @Test
    void getFiles() {
        // Create a FileCrawlingVisitor
        FileCrawlingVisitor fileCrawlingVisitor = new FileCrawlingVisitor();

        // Create a sample file system structure
        Directory root = new Directory(null, "root",LocalDateTime.now());
        Directory src = new Directory(root, "src",LocalDateTime.now());
        File file1 = new File(src, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(root, "file2.txt", 150, LocalDateTime.now());
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.appendChild(src);
        src.appendChild(file1);
        root.appendChild(file2);
        root.appendChild(link1);

        // Accept the FileCrawlingVisitor
        root.accept(fileCrawlingVisitor);

        // Check the list of files
        assertEquals(2, fileCrawlingVisitor.getFiles().size());
        assertEquals(file1, fileCrawlingVisitor.getFiles().get(0));
        assertEquals(file2, fileCrawlingVisitor.getFiles().get(1));
    }
}