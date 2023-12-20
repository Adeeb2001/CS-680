package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;

/**
 * Class File
 * Represents a file in the file system, implementing the FSElement interface.
 */
public class File implements FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    /**
     * Constructor for File
     *
     * @param parent       The parent directory of the file.
     * @param name         The name of the file.
     * @param size         The size of the file.
     * @param creationTime The creation time of the file.
     */
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    /**
     * Override method getName
     * Returns the name of the file.
     *
     * @return The name of the file.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override method getSize
     * Returns the size of the file.
     *
     * @return The size of the file.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Override method getCreationTime
     * Returns the creation time of the file.
     *
     * @return The creation time of the file.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Override method isDirectory
     * Indicates that the element is not a directory.
     *
     * @return false indicating that the element is not a directory.
     */
    @Override
    public boolean isDirectory() {
        return false;
    }

    /**
     * Override method accept
     * Accepts a visitor and visits the file.
     *
     * @param visitor The FSVisitor to be accepted.
     */
    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Method getParent
     * Returns the parent directory of the file.
     *
     * @return The parent directory of the file.
     */
    public Directory getParent() {
        return this.parent;
    }
}
