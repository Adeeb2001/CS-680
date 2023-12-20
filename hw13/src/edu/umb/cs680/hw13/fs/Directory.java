package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.AlphabeticalComparator;
import edu.umb.cs680.hw13.fs.util.Comparator;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Class Directory
 * Represents a directory in the file system, implementing the FSElement interface.
 */
public class Directory implements FSElement {
    private Directory parent;
    private String name;
    private LinkedList<FSElementImplementation> children;
    private LocalDateTime creationTime;

    /**
     * Constructor for Directory
     *
     * @param parent The parent directory.
     * @param name   The name of the directory.
     */
    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        this.children = new LinkedList<>();
        this.creationTime = LocalDateTime.now();
    }

    /**
     * Method addChild
     * Adds a child to the directory.
     *
     * @param realFSElement The real FSElement to be added as a child.
     */
    public void addChild(FSElement realFSElement) {
        FSElementImplementation proxy = new FSElementImplementation(realFSElement);
        children.add(proxy);
    }

    /**
     * Method getChildren
     * Returns the list of children in the directory.
     *
     * @return The list of children in the directory.
     */
    public LinkedList<FSElementImplementation> getChildren() {
        return children;
    }

    /**
     * Override method getName
     * Returns the name of the directory.
     *
     * @return The name of the directory.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override method getSize
     * Returns the total size of the directory and its children.
     *
     * @return The total size of the directory and its children.
     */
    @Override
    public int getSize() {
        int size = 0;
        for (FSElementImplementation child : children) {
            size += child.getSize();
        }
        return size;
    }

    /**
     * Override method getCreationTime
     * Returns the creation time of the directory.
     *
     * @return The creation time of the directory.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Override method isDirectory
     * Indicates that the element is a directory.
     *
     * @return true indicating that the element is a directory.
     */
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * Override method accept
     * Accepts a visitor and visits the directory and its children.
     *
     * @param visitor The FSVisitor to be accepted.
     */
    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);

        for (FSElement child : children) {
            child.accept(visitor);
        }
    }

    /**
     * Method getParent
     * Returns the parent directory.
     *
     * @return The parent directory.
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * Method appendChild
     * Appends a child to the directory and sorts the children alphabetically.
     *
     * @param child The FSElement to be appended as a child.
     */
    public void appendChild(FSElement child) {
        children.add(new FSElementImplementation(child));
        sortChildren(new AlphabeticalComparator());
    }

    /**
     * Method sortChildren
     * Sorts the children of the directory using the provided comparator.
     *
     * @param comparator The comparator to be used for sorting.
     */
    public void sortChildren(Comparator<FSElement> comparator) {
        Collections.sort(children, (o1, o2) -> comparator.compare(o1.getRealFSElement(), o2.getRealFSElement()));
    }
}
