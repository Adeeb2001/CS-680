package edu.umb.cs680.hw13.fs;

/**
 * Interface FSVisitor
 * Represents a visitor interface for the file system elements.
 */
public interface FSVisitor {

    /**
     * Method visit
     * Visits a Link element.
     *
     * @param link The Link element to be visited.
     */
    void visit(Link link);

    /**
     * Method visit
     * Visits a Directory element.
     *
     * @param directory The Directory element to be visited.
     */
    void visit(Directory directory);

    /**
     * Method visit
     * Visits a File element.
     *
     * @param file The File element to be visited.
     */
    void visit(File file);
}
