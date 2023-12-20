package edu.umb.cs680.hw09.fs;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @Test
    void getFileSystem() {
        // Ensure that getFileSystem returns a non-null instance
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs);

        // Ensure that subsequent calls to getFileSystem return the same instance
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs, fs2);
    }

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

    @Test
    void appendRootDir() {
        // Create a file system
        FileSystem fs = FileSystem.getFileSystem();

        // Initially, there should be no root directories
        assertTrue(fs.getRootDirs().isEmpty());

        // Add a root directory
        Directory rootDir = new Directory(null, "primaryRoot", LocalDateTime.now());
        fs.appendRootDir(rootDir);

        // Ensure that the root directory was added successfully
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir, rootDirs.get(0));

        // Add another root directory with a different name
        Directory rootDir2 = new Directory(null, "secondaryRoot", LocalDateTime.now());
        fs.appendRootDir(rootDir2);

        // Ensure that the previous root directory was replaced
        rootDirs = fs.getRootDirs();
        assertEquals(1, rootDirs.size());
        assertSame(rootDir2, rootDirs.get(0));
    }
}
