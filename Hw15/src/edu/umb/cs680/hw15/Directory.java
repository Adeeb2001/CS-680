package edu.umb.cs680.hw15;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;

/**
 * The `Directory` class represents a directory in a file system. It implements the FSElement interface,
 * providing methods to manage and interact with the directory's children and sorting functionalities.
 */
public class Directory implements FSElement {
    private Directory parent;
    private String name;
    private LinkedList<FSElementImpl> children;
    private LocalDateTime creationTime;

    /**
     * Constructs a new Directory with a specified parent and name.
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
     * Adds an FSElement to the directory as a child.
     *
     * @param realFSElement The FSElement to be added as a child.
     */
    public void addChild(FSElement realFSElement) {
        FSElementImpl proxy = new FSElementImpl(realFSElement);
        children.add(proxy);
    }

    /**
     * Retrieves the list of children of the directory.
     *
     * @return A LinkedList containing the directory's children.
     */
    public LinkedList<FSElementImpl> getChildren() {
        return children;
    }

    /**
     * Gets the name of the directory.
     *
     * @return The name of the directory.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the total size of the directory, including its children.
     *
     * @return The total size of the directory.
     */
    @Override
    public int getSize() {
        int size = 0;
        for (FSElementImpl child : children) {
            size += child.getSize();
        }
        return size;
    }

    /**
     * Gets the creation time of the directory.
     *
     * @return The creation time of the directory.
     */
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Indicates whether the object represents a directory.
     *
     * @return True, as this is a directory.
     */
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * Gets the parent directory of this directory.
     *
     * @return The parent directory.
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * Sorts the children of the directory alphabetically.
     */
    public void sortChildrenAlphabetically() {
        Collections.sort(children, (o1, o2) -> o1.getRealFSElement().getName()
                .toLowerCase(Locale.ROOT)
                .compareTo(o2.getRealFSElement().getName().toLowerCase(Locale.ROOT)));
    }

    /**
     * Sorts the children of the directory in reverse alphabetical order.
     */
    public void sortChildrenReverseAlphabetically() {
        Collections.sort(children, (o1, o2) -> o2.getRealFSElement().getName()
                .toLowerCase(Locale.ROOT)
                .compareTo(o1.getRealFSElement().getName().toLowerCase(Locale.ROOT)));
    }

    /**
     * Sorts the children of the directory by size in ascending order.
     */
    public void sortChildrenBySize() {
        Collections.sort(children, (o1, o2) -> Integer.compare(o1.getRealFSElement().getSize(), o2.getRealFSElement().getSize()));
    }
}
