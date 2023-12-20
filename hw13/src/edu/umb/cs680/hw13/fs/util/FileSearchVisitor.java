package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

import java.util.LinkedList;

/**
 * Class FileSearchVisitor
 * A concrete implementation of the FSVisitor interface that searches for a specific file by name during a visit operation
 * and maintains a list of paths to the found files.
 */
public class FileSearchVisitor implements FSVisitor {

    // Name of the file being searched
    private String fileName;

    // List to store paths of found files
    private LinkedList<String> foundFiles = new LinkedList<>();

    // List to maintain the current path during traversal
    private LinkedList<String> currentPath = new LinkedList<>();

    /**
     * Constructor for FileSearchVisitor
     *
     * @param fileName The name of the file to search for.
     */
    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

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
     * Visits a directory, updates the current path, and recursively visits its children.
     * If the file is found, stops searching.
     *
     * @param directory The Directory being visited.
     */
    @Override
    public void visit(Directory directory) {
        // Add the directory name to the current path
        currentPath.add(directory.getName());

        // Iterate over children and recursively visit them
        for (var child : directory.getChildren()) {
            child.accept(this);

            // If file is found, stop searching
            if (!foundFiles.isEmpty()) {
                return;
            }
        }

        // Remove the last element to go back up one level after visiting children
        currentPath.removeLast();
    }

    /**
     * Method visit(File file)
     * Checks if the visited file has the specified name. If found, updates the list of found files.
     *
     * @param file The File being visited.
     */
    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            // Clear previous results and add the path to the found file
            foundFiles.clear();
            foundFiles.add(String.join("/", currentPath) + "/" + file.getName());
        }
    }

    /**
     * Getter for the list of found files.
     *
     * @return The list containing paths of found files.
     */
    public LinkedList<String> getFoundFiles() {
        return foundFiles;
    }
}
