package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The FileSystemTest class contains JUnit tests for the FileSystem class.
 * It covers various methods of the FileSystem class to ensure their correctness.
 */
class FileSystemTest {

    /**
     * Test for the getFileSystem method.
     * Verifies that the returned instance is not null and subsequent calls return the same instance.
     */
    @Test
    void getFileSystem() {
        // Test that the returned instance is not null
        FileSystem fileSystem = FileSystem.getFileSystem();
        assertNotNull(fileSystem);

        // Test that subsequent calls return the same instance
        FileSystem anotherFileSystem = FileSystem.getFileSystem();
        assertEquals(fileSystem, anotherFileSystem);
    }

    /**
     * Test for the getRootDirs method.
     * Verifies that the getRootDirs method returns a non-null list of root directories.
     */
    @Test
    void getRootDirs() {
        // Test getting root directories
        FileSystem fileSystem = FileSystem.getFileSystem();
        LinkedList<Directory> rootDirs = fileSystem.getRootDirs();
        assertNotNull(rootDirs);
        assertEquals(1, rootDirs.size());
    }

    /**
     * Test for the appendRootDir method.
     * Verifies that the appendRootDir method adds a root directory correctly.
     */
    @Test
    void appendRootDir() {
        // Test appending a root directory
        FileSystem fileSystem = FileSystem.getFileSystem();
        Directory rootDir = new Directory(null, "RootDirectory", LocalDateTime.now());
        fileSystem.appendRootDir(rootDir);

        // Check that the root directory is in the list
        LinkedList<Directory> rootDirs = fileSystem.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertTrue(rootDirs.contains(rootDir));
    }
}
