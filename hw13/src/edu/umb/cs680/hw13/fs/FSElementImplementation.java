package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class FSElementImplementation
 * Represents a proxy class implementing the FSElement interface.
 */
public class FSElementImplementation implements FSElement {
    private FSElement realFSElement;

    /**
     * Constructor for FSElementImplementation
     *
     * @param realFSElement The real FSElement to be proxied.
     */
    public FSElementImplementation(FSElement realFSElement) {
        this.realFSElement = realFSElement;
    }

    /**
     * Override method getName
     * Gets the name of the proxied file system element.
     *
     * @return The name of the proxied file system element.
     */
    @Override
    public String getName() {
        return realFSElement.getName();
    }

    /**
     * Override method getSize
     * Gets the size of the proxied file system element.
     *
     * @return The size of the proxied file system element.
     */
    @Override
    public int getSize() {
        return realFSElement.getSize();
    }

    /**
     * Override method getCreationTime
     * Gets the creation time of the proxied file system element.
     *
     * @return The creation time of the proxied file system element.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return realFSElement.getCreationTime();
    }

    /**
     * Override method isDirectory
     * Indicates whether the proxied file system element is a directory or not.
     *
     * @return true if the element is a directory, false otherwise.
     */
    @Override
    public boolean isDirectory() {
        return realFSElement.isDirectory();
    }

    /**
     * Method isLinked
     * Checks if the proxied element is a proxy for a linked element.
     *
     * @return true if the element is a proxy for a linked element, false otherwise.
     */
    public boolean isLinked() {
        return realFSElement instanceof Link;
    }

    /**
     * Method getRealFSElement
     * Gets the real FSElement being proxied.
     *
     * @return The real FSElement being proxied.
     */
    public FSElement getRealFSElement() {
        return realFSElement;
    }

    /**
     * Override method equals
     * Compares this FSElementImplementation with another object for equality.
     *
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FSElementImplementation that = (FSElementImplementation) obj;
        return Objects.equals(realFSElement.getName(), that.realFSElement.getName()) &&
                realFSElement.getSize() == that.realFSElement.getSize();
    }

    /**
     * Override method hashCode
     * Generates a hash code for this FSElementImplementation.
     *
     * @return The hash code for this FSElementImplementation.
     */
    @Override
    public int hashCode() {
        return Objects.hash(realFSElement.getName(), realFSElement.getSize());
    }

    /**
     * Override method accept
     * Accepts a visitor for the proxied file system element.
     *
     * @param visitor The FSVisitor to be accepted.
     */
    @Override
    public void accept(FSVisitor visitor) {
        realFSElement.accept(visitor);
    }
}
