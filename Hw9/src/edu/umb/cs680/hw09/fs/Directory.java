package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        children.add(child);
    }




    public LinkedList<FSElement> getChildren() {
        return children;
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
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child : children) {
            child.accept(visitor);
        }
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
