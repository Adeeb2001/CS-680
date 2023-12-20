package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

/**
 * Class CountingVisitor
 * A concrete implementation of the FSVisitor interface that counts the number of directories, files, and links
 * encountered during a visit operation.
 */
public class CountingVisitor implements FSVisitor {

    // Counters for directories, files, and links
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    /**
     * Method visit(Directory dir)
     * Increments the directory counter when visiting a Directory.
     *
     * @param dir The Directory being visited.
     */
    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    /**
     * Method visit(File file)
     * Increments the file counter when visiting a File.
     *
     * @param file The File being visited.
     */
    @Override
    public void visit(File file) {
        fileNum++;
    }

    /**
     * Method visit(Link link)
     * Increments the link counter when visiting a Link.
     *
     * @param link The Link being visited.
     */
    @Override
    public void visit(Link link) {
        linkNum++;
    }

    /**
     * Getter for the directory counter.
     *
     * @return The number of directories encountered.
     */
    public int getDirNum() {
        return dirNum;
    }

    /**
     * Getter for the file counter.
     *
     * @return The number of files encountered.
     */
    public int getFileNum() {
        return fileNum;
    }

    /**
     * Getter for the link counter.
     *
     * @return The number of links encountered.
     */
    public int getLinkNum() {
        return linkNum;
    }

    // Uncomment the following method if needed for additional functionality.
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
