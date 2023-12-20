package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

import java.util.LinkedList;

/**
 * The FileCrawlingVisitor class implements the FSVisitor interface and is responsible for
 * crawling through a file system structure and collecting a list of files.
 */
public class FileCrawlingVisitor implements FSVisitor {

    // A linked list to store the files encountered during crawling.
    private LinkedList<File> files = new LinkedList<>();

    /**
     * Overrides the visit method for links from the FSVisitor interface.
     * Does nothing for links during crawling.
     *
     * @param link The Link being visited.
     */
    @Override
    public void visit(Link link) {
        // Do nothing for links during crawling.
    }

    /**
     * Overrides the visit method for directories from the FSVisitor interface.
     * Does nothing for directories during crawling.
     *
     * @param directory The Directory being visited.
     */
    @Override
    public void visit(Directory directory) {
        // Do nothing for directories during crawling.
    }

    /**
     * Overrides the visit method for files from the FSVisitor interface.
     * Adds the encountered file to the list of files during crawling.
     *
     * @param file The File being visited.
     */
    @Override
    public void visit(File file) {
        files.add(file);
    }

    /**
     * Getter method to retrieve the list of files collected during crawling.
     *
     * @return A linked list of files encountered during crawling.
     */
    public LinkedList<File> getFiles() {
        return files;
    }
}
