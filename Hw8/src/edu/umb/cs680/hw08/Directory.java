package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private String name;
    private LinkedList<FSElement> children;  // Use FSElement instead of FSElementProxy
    private LocalDateTime creationTime;

    public Directory(String name, LocalDateTime creationTime) {
        this.name = name;
        this.children = new LinkedList<>();
        this.creationTime = creationTime;  // Use the provided creationTime
    }

    public void appendChild(FSElement realFSElement) {
        children.add(realFSElement);  // No need for FSElementProxy
    }

    public LinkedList<FSElement> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FSElement child : children) {
            size += child.getSize();
        }
        return size;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }


    @Override
    public int getTotalSize() {
        int totalSize = getSize(); // Start with the size of the directory itself

        // Add the sizes of all child elements (recursively for directories)
        for (FSElement child : children) {
            totalSize += child.getTotalSize();
        }

        return totalSize;
    }
}
