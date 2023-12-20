package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    @Test
    void visit() {
    }

    @Test
    void testVisit() {
    }

    @Test
    void testVisit1() {
    }

    @Test
    void getFoundFiles() {
        // Create a FileSearchVisitor for searching a file named "file2.txt"
        String fileNameToSearch = "file2.txt";
        FileSearchVisitor searchVisitor = new FileSearchVisitor(fileNameToSearch);

        // Create a sample file system structure
        Directory root = new Directory(null, "root", LocalDateTime.now());
        Directory src = new Directory(root, "src", LocalDateTime.now());
        File file1 = new File(src, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(src, fileNameToSearch, 150, LocalDateTime.now()); // Fix here
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.appendChild(src);
        src.appendChild(file1);
        src.appendChild(file2); // Fix here
        root.appendChild(link1);

        // Accept the FileSearchVisitor
        root.accept(searchVisitor);

        // Check the list of found files
        assertEquals(1, searchVisitor.getFoundFiles().size());
        assertTrue(searchVisitor.getFoundFiles().contains("root/src/file2.txt")); // Fix here
    }
}