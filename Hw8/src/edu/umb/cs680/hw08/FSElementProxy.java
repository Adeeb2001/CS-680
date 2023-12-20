package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.Objects;

public class FSElementProxy extends FSElement {
    private FSElement realFSElement;

    public FSElementProxy(FSElement realFSElement) {
        this.realFSElement = realFSElement;
    }

    @Override
    public String getName() {
        return realFSElement.getName();
    }

    @Override
    public int getSize() {
        return realFSElement.getSize();
    }

    @Override
    public LocalDateTime getCreationTime() {
        return realFSElement.getCreationTime();
    }

    @Override
    public boolean isDirectory() {
        return realFSElement.isDirectory();
    }

    @Override
    public int getTotalSize() {
        return getSize();
    }


    public boolean isLinked() {
        return realFSElement instanceof Link;
    }

    public FSElement getRealFSElement() {
        return realFSElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FSElementProxy that = (FSElementProxy) obj;
        return Objects.equals(realFSElement.getName(), that.realFSElement.getName()) &&
                realFSElement.getSize() == that.realFSElement.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(realFSElement.getName(), realFSElement.getSize());
    }
}
