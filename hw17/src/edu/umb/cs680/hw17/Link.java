package edu.umb.cs680.hw17;

import java.time.LocalDateTime;

public class Link implements FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElementImpl target;

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

    public boolean isLink() {
        return true;
    }

    public FSElementImpl getTarget() {
        return target;
    }
}
