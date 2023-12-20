package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @Test
    void getFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();

        assertSame(fs1, fs2, "Expected the same instance of FileSystem");
    }


    @Test
    void getRootDirs() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory rootDir = new Directory("repo", LocalDateTime.now());
        fs.appendRootDir(rootDir);

        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertNotNull(rootDirs);
        assertEquals(1, rootDirs.size());
        assertTrue(rootDirs.contains(rootDir));
    }
    @Test
    void appendRootDir() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        Directory rootDir = new Directory("repo",LocalDateTime.now());
        fileSystem.appendRootDir(rootDir);

        LinkedList<Directory> rootDirs = fileSystem.getRootDirs();
        assertNotNull(rootDirs);
        assertEquals(1, rootDirs.size());
        assertTrue(rootDirs.contains(rootDir));
    }
}