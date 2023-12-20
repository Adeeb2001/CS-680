package edu.umb.cs680.hw07;

import java.util.LinkedList;

/**
 * The FileSystem class represents a file system and follows the Singleton pattern.
 * It contains methods to access and manipulate the root directories of the file system.
 */
public class FileSystem {
    private static FileSystem instance = null; // Singleton instance
    private LinkedList<Directory> rootDirs; // List of root directories

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the list of root directories.
     */
    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    /**
     * Retrieves the instance of the FileSystem.
     * If the instance does not exist, a new instance is created.
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
     * Retrieves the list of root directories.
     *
     * @return The list of root directories.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    /**
     * Appends a root directory to the list of root directories.
     *
     * @param root The root directory to be added.
     */
    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }
}
