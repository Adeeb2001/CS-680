package edu.umb.cs680.hw15;
import java.util.LinkedList;

/**
 * The `FileSystem` class represents a file system and manages root directories.
 * It follows the Singleton pattern to ensure only one instance of the file system exists.
 */
public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the list of root directories.
     */
    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    /**
     * Gets the singleton instance of the FileSystem.
     *
     * @return The FileSystem instance.
     */
    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    /**
     * Gets the list of root directories in the file system.
     *
     * @return The list of root directories.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    /**
     * Appends a root directory to the file system. Clears existing root directories and adds the new one.
     *
     * @param root The root directory to append.
     */
    public void appendRootDir(Directory root) {
        clearRootDirs(); // Clear existing root directories
        rootDirs.add(root);
    }

    /**
     * Clears the list of root directories in the file system.
     */
    private void clearRootDirs() {
        rootDirs.clear();
    }
}
