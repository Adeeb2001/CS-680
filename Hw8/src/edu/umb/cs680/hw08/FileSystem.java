package edu.umb.cs680.hw08;

import java.util.LinkedList;

/**
 * The `FileSystem` class represents the file system and manages the root directories.
 * It follows the Singleton design pattern to ensure a single instance of the file system.
 */
public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    /**
     * Gets the instance of the file system. If an instance does not exist, it creates one.
     *
     * @return The file system instance.
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
     * Appends a root directory to the file system. It clears existing root directories
     * and adds the specified root directory.
     *
     * @param root The root directory to be added.
     */
    public void appendRootDir(Directory root) {
        clearRootDirs(); // Clear existing root directories
        rootDirs.add(root);
    }

    /**
     * Clears the list of root directories.
     */
    private void clearRootDirs() {
        rootDirs.clear();
    }
}
