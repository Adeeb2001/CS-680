package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;

/**
 * Class Link
 * Represents a symbolic link in the file system, implementing the FSElement interface.
 */
public class Link implements FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElementImplementation target;

    /**
     * Constructor for Link
     *
     * @param parent       The parent directory of the link.
     * @param name         The name of the link.
     * @param size         The size of the link.
     * @param creationTime The creation time of the link.
     * @param target       The target FSElement that the link points to.
     */
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.target = new FSElementImplementation(target);
    }

    /**
     * Override method getName
     * Gets the name of the link.
     *
     * @return The name of the link.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override method getSize
     * Gets the size of the link.
     *
     * @return The size of the link.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Override method getCreationTime
     * Gets the creation time of the link.
     *
     * @return The creation time of the link.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Override method isDirectory
     * Indicates whether the link points to a directory or not.
     *
     * @return true if the link points to a directory, false otherwise.
     */
    @Override
    public boolean isDirectory() {
        return target.isDirectory();
    }

    /**
     * Override method accept
     * Accepts a visitor for the link.
     *
     * @param visitor The FSVisitor to be accepted.
     */
    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Method isLink
     * Indicates that this element is a symbolic link.
     *
     * @return true indicating that this element is a symbolic link.
     */
    public boolean isLink() {
        return true;
    }

    /**
     * Method getTarget
     * Gets the target element that the link points to.
     *
     * @return The target element that the link points to.
     */
    public FSElementImplementation getTarget() {
        return target;
    }
}
