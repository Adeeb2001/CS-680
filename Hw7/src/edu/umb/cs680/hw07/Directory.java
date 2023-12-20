package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children; // List of children (files and subdirectories)

    /**
     * Constructs a Directory object with a specified parent, name, and creation time.
     *
     * @param parent       The parent directory.
     * @param name         The name of the directory.
     * @param creationTime The creation time of the directory.
     */
    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime); // Size initialized to 0 for directories
        this.children = new LinkedList<>();
    }

    /**
     * Retrieves the size of the directory based on the cumulative size of its children.
     *
     * @return The size of the directory.
     */
    @Override
    public int getSize() {
        return countChildren();
    }

    /**
     * Checks if the element is a directory.
     *
     * @return True, as this represents a directory.
     */
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * Retrieves the list of children (files and subdirectories).
     *
     * @return The list of children.
     */
    public LinkedList<FSElement> getChildren() {
        return children;
    }

    /**
     * Appends a child element (file or subdirectory) to the directory.
     *
     * @param child The child element to append.
     */
    public void appendChild(FSElement child) {
        children.add(child);
    }

    /**
     * Counts the cumulative size of all children (files and subdirectories) in the directory.
     *
     * @return The cumulative size of all children.
     */
    public int countChildren() {
        int count = 0;
        for (FSElement child : children) {
            count += child.getSize();
        }
        return count;
    }

    /**
     * Computes and retrieves the total size of the directory, including the
     * cumulative size of all children (files and subdirectories).
     *
     * @return The total size of the directory.
     */
    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement child : children) {
            totalSize += child.getSize();
            if (child.isDirectory()) {
                totalSize += ((Directory) child).getTotalSize();
            }
        }
        return totalSize;
    }

    // Add other methods as needed
}
