package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class FileCrawlingVisitorTest
 * Contains tests for the FileCrawlingVisitor class.
 */
class FileCrawlingVisitorTest {

    /**
     * Method getFiles
     * Tests the getFiles method of the FileCrawlingVisitor.
     */
    @Test
    void getFiles() {
        // Create a FileCrawlingVisitor
        FileCrawlingVisitor fileCrawlingVisitor = new FileCrawlingVisitor();

        // Create a sample file system structure with modified names and sizes
        Directory root = new Directory(null, "main");
        Directory src = new Directory(root, "source");
        File file1 = new File(src, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(root, "documentB.txt", 250, LocalDateTime.now());
        Link link1 = new Link(root, "shortcut1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.addChild(src);
        src.addChild(file1);
        root.addChild(file2);
        root.addChild(link1);

        // Accept the FileCrawlingVisitor
        root.accept(fileCrawlingVisitor);

        // Check the list of files
        assertEquals(2, fileCrawlingVisitor.getFiles().size());
        assertEquals(file1, fileCrawlingVisitor.getFiles().get(0));
        assertEquals(file2, fileCrawlingVisitor.getFiles().get(1));
    }
}
