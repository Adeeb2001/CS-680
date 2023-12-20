package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VisitorFileSearchingTest {

    @Test
    void testGetFoundFiles() {
        // Create a VisitorFileSearching for searching a file named "file2.txt"
        String fileNameToSearch = "file2.txt";
        FileSearchVisitor fileSearchVisitor = new FileSearchVisitor(fileNameToSearch);

        // Create a sample file system structure
        Directory rootDir = new Directory(null, "rootDir", LocalDateTime.now());
        Directory srcDir = new Directory(rootDir, "srcDir", LocalDateTime.now());
        File file1 = new File(srcDir, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(srcDir, fileNameToSearch, 150, LocalDateTime.now());
        Link link1 = new Link(rootDir, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        rootDir.appendChild(srcDir);
        srcDir.appendChild(file1);
        srcDir.appendChild(file2);
        rootDir.appendChild(link1);

        // Accept the VisitorFileSearching
        rootDir.accept(fileSearchVisitor);

        // Check the list of found files
        assertEquals(1, fileSearchVisitor.getFoundFiles().size());
        assertTrue(fileSearchVisitor.getFoundFiles().contains("rootDir/srcDir/file2.txt"));
    }
}
