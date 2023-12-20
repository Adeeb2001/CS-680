package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

/**
 * The `FSElement` abstract class represents a file system element such as a file or directory.
 * It defines basic methods to retrieve information about the element, such as its name, size,
 * creation time, and whether it is a directory.
 */
public abstract class FSElement {
    private Directory parent; // Parent directory
    private String name; // Name of the file system element
    private int size; // Size of the file system element
    private LocalDateTime creationTime; // Creation time of the file system element

    /**
     * Default constructor for FSElement.
     */
    protected FSElement() {
        // Default constructor, can be empty or initialize default values
    }

    /**
     * Constructs an FSElement with a specified parent, name, size, and creation time.
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
     * Gets the name of the file system element.
     *
     * @return The name of the file system element.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the size of the file system element.
     *
     * @return The size of the file system element.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the creation time of the file system element.
     *
     * @return The creation time of the file system element.
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Checks if the file system element is a directory.
     *
     * @return `true` if the file system element is a directory, otherwise `false`.
     */
    public abstract boolean isDirectory();

    /**
     * Gets the total size of the file system element, considering its children.
     *
     * @return The total size of the file system element.
     */
    public abstract int getTotalSize();
}
