/*
 * The FileSearchVisitor class implements the FSVisitor interface and is designed to traverse a FileSystem,
 * searching for a specific file by name and collecting the paths of any matching files in a linked list.
 */

package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    // Name of the file to search for.
    private String fileName;

    // Linked list to store paths of found files during traversal.
    private LinkedList<String> foundFiles = new LinkedList<>();

    // Linked list to maintain the current path during traversal.
    private LinkedList<String> currentPath = new LinkedList<>();

    /*
     * Constructor for FileSearchVisitor that takes the name of the file to search for as a parameter.
     *
     * @param fileName - The name of the file to search for.
     */
    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

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
     * Overrides the visit method for a Directory element, adding the directory name to the current path,
     * then recursively visiting its children. If a file is found, the search is stopped.
     * After visiting children, the current path is adjusted to go back up one level.
     *
     * @param directory - The Directory element being visited.
     */
    @Override
    public void visit(Directory directory) {
        currentPath.add(directory.getName());

        for (var child : directory.getChildren()) {
            child.accept(this);

            // If file is found, stop searching
            if (!foundFiles.isEmpty()) {
                return;
            }
        }

        // Go back up one level after visiting children
        currentPath.removeLast();
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFiles.clear();  // Clear previous results
            // Use the parent directory's path and append the file name
            foundFiles.add(getDirectoryPath(file.getParent()) + "/" + file.getName());
        }
    }

    // Helper method to get the path of a directory
    private String getDirectoryPath(Directory directory) {
        if (directory.getParent() == null) {
            return directory.getName();
        } else {
            return getDirectoryPath(directory.getParent()) + "/" + directory.getName();
        }
    }
    /*
     * Getter method to retrieve the linked list of paths for found files during traversal.
     *
     * @return The linked list of paths for found files.
     */
    public LinkedList<String> getFoundFiles() {
        return foundFiles;
    }
}
