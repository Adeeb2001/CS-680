package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

/**
 * The File class represents a file in a file system.
 * It implements the FSElement interface and contains methods to
 * manipulate and retrieve information about files.
 */
public class File extends FSElement {
    private int size; // Size of the file

    /**
     * Constructs a File object with a specified parent, name, size, and creation time.
     *
     * @param parent       The parent directory.
     * @param name         The name of the file.
     * @param size         The size of the file.
     * @param creationTime The creation time of the file.
     */
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.size = size;
    }

    /**
     * Retrieves the size of the file.
     *
     * @return The size of the file.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the element is a directory.
     *
     * @return False, as this represents a file.
     */
    @Override
    public boolean isDirectory() {
        return false;
    }
}
