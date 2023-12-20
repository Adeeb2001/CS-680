
package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

/**
 * The `Link` class represents a symbolic link in the file system. It implements the `FSElement` interface
 * and has additional methods related to linking.
 */
public class Link implements FSElement {

    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElementImpl target;

    /**
     * Constructs a `Link` with the given parameters.
     *
     * @param parent       The parent directory of the link.
     * @param name         The name of the link.
     * @param size         The size of the link.
     * @param creationTime The creation time of the link.
     * @param target       The target file system element that the link points to.
     */
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.target = new FSElementImpl(target);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean isDirectory() {
        return target.isDirectory();
    }

    /**
     * Checks if the `Link` represents a symbolic link.
     *
     * @return True if it's a symbolic link, false otherwise.
     */
    public boolean isLink() {
        return true;
    }

    /**
     * Gets the target file system element that the link points to.
     *
     * @return The target file system element.
     */
    public FSElementImpl getTarget() {
        return target;
    }
}
