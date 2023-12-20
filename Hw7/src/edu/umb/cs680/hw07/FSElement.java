package edu.umb.cs680.hw07;
import edu.umb.cs680.hw07.Directory;
import java.time.LocalDateTime;

/**
 * The abstract class FSElement represents a file system element (either a file or a directory).
 * It contains common attributes and methods for both files and directories.
 */
public abstract class FSElement {
    private Directory parent; // Parent directory
    private String name; // Name of the file or directory
    private int size; // Size of the file or directory
    private LocalDateTime creationTime; // Creation time of the file or directory

    /**
     * Constructs an FSElement object with a specified parent, name, size, and creation time.
     *
     * @param parent       The parent directory.
     * @param name         The name of the file or directory.
     * @param size         The size of the file or directory.
     * @param creationTime The creation time of the file or directory.
     */
    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    /**
     * Retrieves the parent directory.
     *
     * @return The parent directory.
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * Retrieves the size of the file or directory.
     *
     * @return The size of the file or directory.
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieves the name of the file or directory.
     *
     * @return The name of the file or directory.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the creation time of the file or directory.
     *
     * @return The creation time of the file or directory.
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Checks if the element is a directory.
     *
     * @return True if the element is a directory, false if it is a file.
     */
    public abstract boolean isDirectory();
}
