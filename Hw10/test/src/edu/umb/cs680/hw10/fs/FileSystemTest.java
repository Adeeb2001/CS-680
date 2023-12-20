package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The FileSystemTest class contains JUnit tests for the FileSystem class.
 * It tests various functionalities such as creating a file system instance,
 * retrieving root directories, and appending root directories.
 */
class FileSystemTest {

    /**
     * Tests the getFileSystem method of the FileSystem class.
     * It ensures that the method returns a non-null instance of FileSystem,
     * and subsequent calls return the same instance.
     */
    @Test
    void getFileSystem() {
        // Ensure that getFileSystem returns a non-null instance
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs);

        // Ensure that subsequent calls to getFileSystem return the same instance
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs, fs2);
    }

    /**
     * Tests the getRootDirs method of the FileSystem class.
     * It adds a root directory to the file system and ensures that
     * getRootDirs returns a list containing the added root directory.
     */
    @Test
    void getRootDirs() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Add a root directory
        Directory rootDir = new Directory(null, "mainRoot", LocalDateTime.now());
        fs.appendRootDir(rootDir);

        // Ensure that getRootDirs returns a list containing the added root directory
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir, rootDirs.get(0));
    }

    /**
     * Tests the appendRootDir method of the FileSystem class.
     * It adds root directories to the file system and ensures that
     * the method appends and replaces root directories as expected.
     */
    @Test
    void appendRootDir() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Initially, there should be no root directories
        /*        assertTrue(fs.getRootDirs().isEmpty());*/

        // Add a root directory
        Directory rootDir = new Directory(null, "mainRoot",LocalDateTime.now());
        fs.appendRootDir(rootDir);

        // Ensure that the root directory was added successfully
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir, rootDirs.get(0));

        // Add another root directory
        Directory rootDir2 = new Directory(null, "extraRoot",LocalDateTime.now());
        fs.appendRootDir(rootDir2);

        // Ensure that the previous root directory was replaced
        rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir2, rootDirs.get(0));
    }
}
