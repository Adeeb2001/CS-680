package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class FileSystemTest
 * Contains tests for the FileSystem class.
 */
class FileSystemTest {

    /**
     * Method getFileSystem
     * Tests the getFileSystem method of the FileSystem class.
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
     * Method getRootDirs
     * Tests the getRootDirs method of the FileSystem class.
     */
    @Test
    void getRootDirs() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Add a root directory
        Directory rootDir = new Directory(null, "root");
        fs.appendRootDir(rootDir);

        // Ensure that getRootDirs returns a list containing the added root directory
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir, rootDirs.get(0));
    }

    /**
     * Method appendRootDir
     * Tests the appendRootDir method of the FileSystem class.
     */
    @Test
    void appendRootDir() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Initially, there should be no root directories
        assertTrue(fs.getRootDirs().isEmpty());

        // Add a root directory
        Directory rootDir = new Directory(null, "root");
        fs.appendRootDir(rootDir);

        // Ensure that the root directory was added successfully
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir, rootDirs.get(0));

        // Add another root directory
        Directory rootDir2 = new Directory(null, "root2");
        fs.appendRootDir(rootDir2);

        // Ensure that the previous root directory was replaced
        rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir2, rootDirs.get(0));
    }
}
