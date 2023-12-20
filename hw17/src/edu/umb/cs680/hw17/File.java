package edu.umb.cs680.hw17;

import java.time.LocalDateTime;

public class File implements FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
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
        return false;
    }

    public Directory getParent() {
        return parent;
    }
}
