/*
 * This class, CountingVisitor, implements the FSVisitor interface and is designed to visit FileSystem elements
 * such as Directory, File, and Link, counting their occurrences during the traversal process.
 */

package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.*;

public class CountingVisitor implements FSVisitor {

    // Counters to keep track of the number of directories, files, and links encountered during traversal.
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    /*
     * Overrides the visit method for a Directory element, incrementing the directory counter.
     *
     * @param dir - The Directory element being visited.
     */
    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    /*
     * Overrides the visit method for a File element, incrementing the file counter.
     *
     * @param file - The File element being visited.
     */
    @Override
    public void visit(File file) {
        fileNum++;
    }

    /*
     * Overrides the visit method for a Link element, incrementing the link counter.
     *
     * @param link - The Link element being visited.
     */
    @Override
    public void visit(Link link) {
        linkNum++;
    }

    /*
     * Getter method to retrieve the count of directories encountered during traversal.
     *
     * @return The number of directories encountered.
     */
    public int getDirNum() {
        return dirNum;
    }

    /*
     * Getter method to retrieve the count of files encountered during traversal.
     *
     * @return The number of files encountered.
     */
    public int getFileNum() {
        return fileNum;
    }

    /*
     * Getter method to retrieve the count of links encountered during traversal.
     *
     * @return The number of links encountered.
     */
    public int getLinkNum() {
        return linkNum;
    }

    // Additional method (commented out) that was originally part of the class.
    /*
     * This method counts the immediate children of a given directory.
     * It iterates through the children and increments the count for each child that is an instance of Directory.
     * Note: This method is commented out, possibly indicating that it's not currently in use.
     *
     * @param dir - The Directory for which immediate children are counted.
     * @return The count of immediate children that are directories.
     */
    /*
    public int countImmediateChildren(Directory dir) {
        int immediateDirNum = 0;
        for (FSElement child : dir.getChildren()) {
            if (child instanceof Directory) {
                immediateDirNum++;
            }
        }
        return immediateDirNum;
    }
    */
}
