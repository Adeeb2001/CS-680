/*
 * The FileSystem class represents a file system and follows the Singleton design pattern.
 */

package edu.umb.cs680.hw09.fs;

import java.util.LinkedList;

public class FileSystem {

    // Singleton instance of the FileSystem.
    private static FileSystem instance = null;

    // List to store the root directories of the file system.
    private LinkedList<Directory> rootDirs;

    /*
     * Private constructor to prevent instantiation of FileSystem from outside the class.
     * Initializes the list of root directories.
     */
    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    /*
     * Method to get the Singleton instance of FileSystem. If an instance does not exist, it creates one.
     *
     * @return The Singleton instance of FileSystem.
     */
    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    /*
     * Getter method to retrieve the list of root directories in the file system.
     *
     * @return The list of root directories.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    /*
     * Method to append a root directory to the list of root directories.
     * Clears existing root directories before adding the new one.
     *
     * @param root - The root directory to be added.
     */
    public void appendRootDir(Directory root) {
        clearRootDirs(); // Clear existing root directories
        rootDirs.add(root);
    }

    /*
     * Private method to clear the list of root directories.
     */
    private void clearRootDirs() {
        rootDirs.clear();
    }
}
