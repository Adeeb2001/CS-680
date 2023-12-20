package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public boolean isDirectory() {
        return target.isDirectory();
    }

    public boolean isLink() {
        return true;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getTotalSize() {
        return getSize();
    }
}