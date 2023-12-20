package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSCommand;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;

import java.util.LinkedList;

/**
 * The FileCrawlingCommand class implements the FSCommand interface and is responsible for
 * executing a command to crawl through a file system structure and print the names of all collected files.
 */
public class FileCrawlingCommand implements FSCommand {

    // The FSVisitor used to crawl through the file system and collect files.
    private final FSVisitor visitor;

    // The Directory on which the crawling operation will be performed.
    private final Directory directory;

    /**
     * Constructor for the FileCrawlingCommand class.
     *
     * @param visitor   The FSVisitor to be used for crawling.
     * @param directory The Directory on which the crawling operation will be performed.
     */
    public FileCrawlingCommand(FSVisitor visitor, Directory directory) {
        this.visitor = visitor;
        this.directory = directory;
    }

    /**
     * Executes the command to crawl through the specified directory and print the names of all collected files.
     */
    @Override
    public void execute() {
        // Accept the visitor to perform the crawling operation on the specified directory.
        directory.accept(visitor);

        // Get the list of collected files from the crawling visitor.
        LinkedList<File> allFiles = ((FileCrawlingVisitor) visitor).getFiles();

        // Print the names of all collected files to the console.
        System.out.println("All Files in the File System:");
        for (File file : allFiles) {
            System.out.println(file.getName());
        }
    }
}
