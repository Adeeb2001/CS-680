package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The FileSearchingCommandTest class contains JUnit tests for the FileSearchingCommand class.
 */
class FileSearchingCommandTest {

    /**
     * Test the execute method of FileSearchingCommand by creating a sample file system structure,
     * executing the command to search for a specific file, and checking the results using accessor methods.
     */
    @Test
    void getFoundFiles() {
        // Create a FileSearchVisitor for searching a file named "file2.txt"
        String fileNameToSearch = "file2.txt";
        FileSearchVisitor searchVisitor = new FileSearchVisitor(fileNameToSearch);

        // Create a sample file system structure
        Directory root = new Directory(null, "root", LocalDateTime.now());
        Directory src = new Directory(root, "src", LocalDateTime.now());
        File file1 = new File(src, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(root, fileNameToSearch, 150, LocalDateTime.now());
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);

        // Add elements to the file system
        root.appendChild(src);
        src.appendChild(file1);
        root.appendChild(file2);
        root.appendChild(link1);

        // Accept the FileSearchVisitor
        root.accept(searchVisitor);

        // Check the list of found files
        assertEquals(1, searchVisitor.getFoundFiles().size());

        // Adjust the expected path based on the relative path structure
        String expectedPath = "root/file2.txt";
        assertTrue(searchVisitor.getFoundFiles().contains(expectedPath));
    }
}
