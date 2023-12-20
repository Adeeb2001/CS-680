package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getTotalSize() {
        return getSize(); // The total size of a file is just its own size
    }
}
