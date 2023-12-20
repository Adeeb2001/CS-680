package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

/**
 * The `FSElement` interface represents a file system element, such as a file or directory.
 * It defines methods to retrieve information about the element.
 */
public interface FSElement {

    /**
     * Gets the name of the file system element.
     *
     * @return The name of the element.
     */
    String getName();

    /**
     * Gets the size of the file system element.
     *
     * @return The size of the element in bytes.
     */
    int getSize();

    /**
     * Gets the creation time of the file system element.
     *
     * @return The creation time of the element.
     */
    LocalDateTime getCreationTime();

    /**
     * Checks if the file system element is a directory.
     *
     * @return True if the element is a directory, false if it is a file.
     */
    boolean isDirectory();
}
