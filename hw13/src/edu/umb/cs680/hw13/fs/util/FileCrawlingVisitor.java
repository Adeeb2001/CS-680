package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

import java.util.LinkedList;

/**
 * Class FileCrawlingVisitor
 * A concrete implementation of the FSVisitor interface that collects files encountered during a visit operation
 * and stores them in a linked list.
 */
public class FileCrawlingVisitor implements FSVisitor {

    // Linked list to store encountered files
    private LinkedList<File> files = new LinkedList<>();

    /**
     * Method visit(Link link)
     * Does nothing for links during the visit operation.
     *
     * @param link The Link being visited.
     */
    @Override
    public void visit(Link link) {
        // Do nothing for links
    }

    /**
     * Method visit(Directory directory)
     * Does nothing for directories during the visit operation.
     *
     * @param directory The Directory being visited.
     */
    @Override
    public void visit(Directory directory) {
        // Do nothing for directories
    }

    /**
     * Method visit(File file)
     * Adds the encountered file to the linked list during the visit operation.
     *
     * @param file The File being visited.
     */
    @Override
    public void visit(File file) {
        files.add(file);
    }

    /**
     * Getter for the linked list of files.
     *
     * @return The linked list containing encountered files.
     */
    public LinkedList<File> getFiles() {
        return files;
    }
}
