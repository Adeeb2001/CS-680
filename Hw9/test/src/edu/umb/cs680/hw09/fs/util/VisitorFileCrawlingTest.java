package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VisitorFileCrawlingTest {

    @Test
    void testGetFiles() {
        // Create a VisitorFileCrawling
        FileCrawlingVisitor fileCrawlingVisitor = new FileCrawlingVisitor();

        // Create a sample file system structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        Directory srcDir = new Directory(rootDir, "srcDir", LocalDateTime.now());
        File file1 = new File(srcDir, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(rootDir, "file2.txt", 150, LocalDateTime.now());
        Link link1 = new Link(rootDir, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        rootDir.appendChild(srcDir);
        srcDir.appendChild(file1);
        rootDir.appendChild(file2);
        rootDir.appendChild(link1);

        // Accept the VisitorFileCrawling
        rootDir.accept(fileCrawlingVisitor);

        // Check the list of files
        assertEquals(2, fileCrawlingVisitor.getFiles().size());
        assertEquals(file1, fileCrawlingVisitor.getFiles().get(0));
        assertEquals(file2, fileCrawlingVisitor.getFiles().get(1));
    }
}
