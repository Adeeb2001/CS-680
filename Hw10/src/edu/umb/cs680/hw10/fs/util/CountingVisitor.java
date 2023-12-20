package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

/**
 * The CountingVisitor class implements the FSVisitor interface and is responsible for counting
 * the number of directories, files, and links within a file system structure.
 */
public class CountingVisitor implements FSVisitor {

    // Counters for the number of directories, files, and links visited.
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    /**
     * Overrides the visit method for directories from the FSVisitor interface.
     * Increments the directory count when a directory is visited.
     *
     * @param dir The Directory being visited.
     */
    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    /**
     * Overrides the visit method for files from the FSVisitor interface.
     * Increments the file count when a file is visited.
     *
     * @param file The File being visited.
     */
    @Override
    public void visit(File file) {
        fileNum++;
    }

    /**
     * Overrides the visit method for links from the FSVisitor interface.
     * Increments the link count when a link is visited.
     *
     * @param link The Link being visited.
     */
    @Override
    public void visit(Link link) {
        linkNum++;
    }

    /**
     * Getter method to retrieve the count of directories visited.
     *
     * @return The count of directories visited.
     */
    public int getDirNum() {
        return dirNum;
    }

    /**
     * Getter method to retrieve the count of files visited.
     *
     * @return The count of files visited.
     */
    public int getFileNum() {
        return fileNum;
    }

    /**
     * Getter method to retrieve the count of links visited.
     *
     * @return The count of links visited.
     */
    public int getLinkNum() {
        return linkNum;
    }

    // The following method was commented out and is not in use in the current version of the class.

    /*
     * public int countImmediateChildren(Directory dir) {
     *   int immediateDirNum = 0;
     *   for (FSElement child : dir.getChildren()) {
     *       if (child instanceof Directory) {
     *           immediateDirNum++;
     *       }
     *   }
     *   return immediateDirNum;
     * }
     */
}
