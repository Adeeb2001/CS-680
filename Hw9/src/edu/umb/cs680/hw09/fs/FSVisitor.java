/*
 * The FSVisitor interface defines the operations that can be performed on different FileSystem elements.
 */

package edu.umb.cs680.hw09.fs;

public interface FSVisitor {

    /*
     * Method to visit a Link element.
     *
     * @param link - The Link element to be visited.
     */
    void visit(Link link);

    /*
     * Method to visit a Directory element.
     *
     * @param directory - The Directory element to be visited.
     */
    void visit(Directory directory);

    /*
     * Method to visit a File element.
     *
     * @param file - The File element to be visited.
     */
    void visit(File file);
}
