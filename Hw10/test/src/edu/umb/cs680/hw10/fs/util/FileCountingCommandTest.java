package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.FileSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The FileCountingCommandTest class contains JUnit tests for the FileCountingCommand class.
 */
class FileCountingCommandTest {

    /**
     * Test the execute method of FileCountingCommand by creating a sample file system structure,
     * executing the command, and checking the counts of directories, files, and links.
     */
    @Test
    void execute() {
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

        // Create FileCountingCommand instance
        CountingVisitor countingVisitor = new CountingVisitor();
        FileCountingCommand countingCommand = new FileCountingCommand(countingVisitor, root);

        // Execute the command
        countingCommand.execute();

        // Check the results using the countingVisitor
        assertEquals(1, countingVisitor.getDirNum() - 1);
        assertEquals(3, countingVisitor.getFileNum());
        assertEquals(0, countingVisitor.getLinkNum());
    }
}
