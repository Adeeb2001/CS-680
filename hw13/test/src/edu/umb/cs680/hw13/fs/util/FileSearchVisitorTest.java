package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class FileSearchVisitorTest
 * Contains tests for the FileSearchVisitor class.
 */
class FileSearchVisitorTest {

    /**
     * Method getFoundFiles
     * Tests the getFoundFiles method of the FileSearchVisitor.
     */
    @Test
    void getFoundFiles() {
        // Create a FileSearchVisitor for searching a file named "documentB.txt"
        String fileNameToSearch = "documentB.txt";
        FileSearchVisitor searchVisitor = new FileSearchVisitor(fileNameToSearch);

        // Create a sample file system structure with modified names and sizes
        Directory root = new Directory(null, "main");
        Directory src = new Directory(root, "source");
        File file1 = new File(src, "documentA.txt", 200, LocalDateTime.now());
        File file2 = new File(root, fileNameToSearch, 250, LocalDateTime.now());
        Link link1 = new Link(root, "shortcut1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.addChild(src);
        src.addChild(file1);
        root.addChild(file2);
        root.addChild(link1);

        // Accept the FileSearchVisitor
        root.accept(searchVisitor);

        // Check the list of found files
        assertEquals(1, searchVisitor.getFoundFiles().size());
    }
}
