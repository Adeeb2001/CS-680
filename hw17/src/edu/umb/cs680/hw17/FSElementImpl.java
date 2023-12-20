package edu.umb.cs680.hw17;

import java.time.LocalDateTime;
import java.util.Objects;

public class FSElementImpl implements FSElement {
    private FSElement realFSElement;

    public FSElementImpl(FSElement realFSElement) {
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
        FSElementImpl that = (FSElementImpl) obj;
        return Objects.equals(realFSElement.getName(), that.realFSElement.getName()) &&
                realFSElement.getSize() == that.realFSElement.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(realFSElement.getName(), realFSElement.getSize());
    }
}
