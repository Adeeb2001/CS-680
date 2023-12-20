package edu.umb.cs680.hw13.fs;

import java.util.LinkedList;

/**
 * Class FileSystem
 * Represents a file system with root directories, implementing the singleton pattern.
 */
public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    /**
     * Private constructor for FileSystem
     * Initializes the list of root directories.
     */
    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    /**
     * Method getFileSystem
     * Returns the singleton instance of the FileSystem class.
     * If the instance does not exist, it creates a new one.
     *
     * @return The singleton instance of the FileSystem class.
     */
    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    /**
     * Method getRootDirs
     * Returns the list of root directories in the file system.
     *
     * @return The list of root directories in the file system.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    /**
     * Method appendRootDir
     * Appends a root directory to the file system.
     * Clears existing root directories before adding the new one.
     *
     * @param root The root directory to be added.
     */
    public void appendRootDir(Directory root) {
        clearRootDirs(); // Clear existing root directories
        rootDirs.add(root);
    }

    /**
     * Private method clearRootDirs
     * Clears the list of root directories.
     */
    private void clearRootDirs() {
        rootDirs.clear();
    }
}
