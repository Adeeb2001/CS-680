package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;

/**
 * Interface FSElement
 * Represents a file system element with basic attributes and behavior.
 */
public interface FSElement {

    /**
     * Method getName
     * Gets the name of the file system element.
     *
     * @return The name of the file system element.
     */
    String getName();

    /**
     * Method getSize
     * Gets the size of the file system element.
     *
     * @return The size of the file system element.
     */
    int getSize();

    /**
     * Method getCreationTime
     * Gets the creation time of the file system element.
     *
     * @return The creation time of the file system element.
     */
    LocalDateTime getCreationTime();

    /**
     * Method isDirectory
     * Indicates whether the file system element is a directory or not.
     *
     * @return true if the element is a directory, false otherwise.
     */
    boolean isDirectory();

    /**
     * Method accept
     * Accepts a visitor for the file system element.
     *
     * @param visitor The FSVisitor to be accepted.
     */
    void accept(FSVisitor visitor);
}
