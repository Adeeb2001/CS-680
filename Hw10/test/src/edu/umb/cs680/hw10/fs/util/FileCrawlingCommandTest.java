package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.FileSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The FileCrawlingCommandTest class contains JUnit tests for the FileCrawlingCommand class.
 */
class FileCrawlingCommandTest {

    /**
     * Test the execute method of FileCrawlingCommand by creating a sample file system structure,
     * executing the command, and checking the list of collected files.
     */
    @Test
    void testExecute() {
        // Create the file system
        FileSystem fileSystem = FileSystem.getFileSystem();

        // Create root directory
        Directory root = new Directory(null, "root", LocalDateTime.now());

        // Create files and directories
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(root, "file2.txt", 150, LocalDateTime.now());
        Directory subDir = new Directory(root, "subDir", LocalDateTime.now());
        File file3 = new File(subDir, "file3.txt", 200, LocalDateTime.now());

        // Add elements to the file system
        root.appendChild(file1);
        root.appendChild(file2);
        root.appendChild(subDir);
        subDir.appendChild(file3);

        // Add root directory to the file system
        fileSystem.appendRootDir(root);

        // Create FileCrawlingVisitor
        FileCrawlingVisitor crawlingVisitor = new FileCrawlingVisitor();

        // Create FileCrawlingCommand instance
        FileCrawlingCommand crawlingCommand = new FileCrawlingCommand(crawlingVisitor, root);

        // Execute the command
        crawlingCommand.execute();

        // Check the results
        LinkedList<File> expectedFiles = new LinkedList<>();
        expectedFiles.add(file1);
        expectedFiles.add(file2);
        expectedFiles.add(file3);

        LinkedList<File> actualFiles = crawlingVisitor.getFiles();
        assertEquals(expectedFiles, actualFiles);
    }
}
