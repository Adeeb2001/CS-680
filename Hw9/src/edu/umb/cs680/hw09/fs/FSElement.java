package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

/**
 * The FSElement abstract class defines the common behavior for file system elements such as Directory, File, and Link.
 */
public abstract class FSElement {

    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    /**
     * Constructor for creating an FSElement with a specified parent, name, size, and creation time.
     *
     * @param parent       The parent directory.
     * @param name         The name of the file system element.
     * @param size         The size of the file system element.
     * @param creationTime The creation time of the file system element.
     */
    protected FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    /**
     * Method to retrieve the name of the file system element.
     *
     * @return The name of the file system element.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to retrieve the size of the file system element.
     *
     * @return The size of the file system element.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to retrieve the creation time of the file system element.
     *
     * @return The creation time of the file system element.
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Method to check if the file system element is a directory.
     *
     * @return True if the file system element is a directory; otherwise, false.
     */
    public abstract boolean isDirectory();

    /**
     * Method to accept a visitor and initiate the visitor's visit operation on the file system element.
     *
     * @param visitor - The FSVisitor to be accepted.
     */
    public abstract void accept(FSVisitor visitor);

    /**
     * Method to get the total size of the file system element, considering its children.
     *
     * @return The total size of the file system element.
     */
    public abstract int getTotalSize();

    /**
     * Method to retrieve the parent directory of the file system element.
     *
     * @return The parent directory.
     */
    public Directory getParent() {
        return parent;
    }
}
