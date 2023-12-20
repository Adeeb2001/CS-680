package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

/**
 * The `Link` class represents a symbolic link in the file system.
 * It implements the `FSElement` interface and contains information about
 * the link such as its name, size, creation time, and the target element it points to.
 */
public class Link extends FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElementProxy target;

    /**
     * Constructor to create a link with the specified name, size, creation time, and target element.
     *
     * @param name          The name of the link.
     * @param size          The size of the link.
     * @param creationTime  The creation time of the link.
     * @param target        The target element to which the link points.
     */
    public Link(String name, int size, LocalDateTime creationTime, FSElement target) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.target = new FSElementProxy(target);
    }

    /**
     * Gets the name of the link.
     *
     * @return The name of the link.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the size of the link.
     *
     * @return The size of the link.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Gets the creation time of the link.
     *
     * @return The creation time of the link.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Checks if the link points to a directory.
     *
     * @return True if the link points to a directory, false otherwise.
     */
    @Override
    public boolean isDirectory() {
        return target.isDirectory();
    }



    /**
     * Checks if the element is a link.
     *
     * @return True, indicating it's a link.
     */
    public boolean isLink() {
        return true;
    }

    /**
     * Gets the target element to which the link points.
     *
     * @return The target element as a proxy.
     */
    public FSElementProxy getTarget() {
        return target;
    }

    @Override
    public int getTotalSize() {
        return getSize();
    }
}
