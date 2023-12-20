/*
 * The FileCrawlingVisitor class implements the FSVisitor interface and is designed to traverse a FileSystem,
 * collecting all encountered File elements in a linked list.
 */

package edu.umb.cs680.hw09.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class FileCrawlingVisitor implements FSVisitor {

    // Linked list to store encountered File elements during traversal.
    private LinkedList<File> files = new LinkedList<>();

    /*
     * Overrides the visit method for a Link element, indicating that nothing should be done for links during traversal.
     *
     * @param link - The Link element being visited.
     */
    @Override
    public void visit(Link link) {
        // Do nothing for links
    }

    /*
     * Overrides the visit method for a Directory element, indicating that nothing should be done for directories during traversal.
     *
     * @param directory - The Directory element being visited.
     */
    @Override
    public void visit(Directory directory) {
        // Do nothing for directories
    }

    /*
     * Overrides the visit method for a File element, adding the encountered File to the linked list.
     *
     * @param file - The File element being visited.
     */
    @Override
    public void visit(File file) {
        files.add(file);
    }

    /*
     * Getter method to retrieve the linked list of File elements collected during traversal.
     *
     * @return The linked list of File elements.
     */
    public LinkedList<File> getFiles() {
        return files;
    }
}
