package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.Objects;

public class FSElementImplementation extends FSElement {

    private FSElement realFSElement;

    public FSElementImplementation(FSElement realFSElement) {
        super(realFSElement.getParent(), realFSElement.getName(), realFSElement.getSize(), realFSElement.getCreationTime());
        this.realFSElement = realFSElement;
    }

    @Override
    public boolean isDirectory() {
        return realFSElement.isDirectory();
    }

    @Override
    public void accept(FSVisitor visitor) {
        realFSElement.accept(visitor);
    }

    @Override
    public int getTotalSize() {
        return realFSElement.getTotalSize();
    }

    public FSElement getRealFSElement() {
        return realFSElement;
    }

    public boolean isLinked() {
        return realFSElement instanceof Link;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FSElementImplementation that = (FSElementImplementation) obj;
        return Objects.equals(getName(), that.getRealFSElement().getName()) &&
                getSize() == that.getRealFSElement().getSize();
    }


}
