package edu.umb.cs680.hw17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @Test
    void getFileSystem() {
        // Test if getFileSystem returns a non-null instance
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs);

        // Test if subsequent calls to getFileSystem return the same instance
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs, fs2);
    }

    @Test
    void getRootDirs() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Add a root directory
        Directory rootDir = new Directory(null, "root");
        fs.appendRootDir(rootDir);

        // Test if getRootDirs returns a list containing the added root directory
        assertEquals(1, fs.getRootDirs().size());
        assertSame(rootDir, fs.getRootDirs().get(0));
    }

    @Test
    void appendRootDir() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Initially, there should be no root directories
        assertTrue(fs.getRootDirs().isEmpty());

        // Add a root directory
        Directory rootDir = new Directory(null, "root");
        fs.appendRootDir(rootDir);

        // Test if the root directory was added successfully
        assertEquals(1, fs.getRootDirs().size());
        assertSame(rootDir, fs.getRootDirs().get(0));

        // Add another root directory
        Directory rootDir2 = new Directory(null, "root2");
        fs.appendRootDir(rootDir2);

        // Test if the previous root directory was replaced
        assertEquals(1, fs.getRootDirs().size());
        assertSame(rootDir2, fs.getRootDirs().get(0));
    }
}
