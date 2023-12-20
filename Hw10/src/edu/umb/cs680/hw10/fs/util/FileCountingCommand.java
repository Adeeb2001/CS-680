package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSCommand;
import edu.umb.cs680.hw10.fs.FSVisitor;

/**
 * The FileCountingCommand class implements the FSCommand interface and is responsible for
 * executing a command to count the number of directories, files, and links within a specified directory.
 */
public class FileCountingCommand implements FSCommand {

    // The FSVisitor used to count directories, files, and links.
    private final FSVisitor visitor;

    // The Directory on which the counting operation will be performed.
    private final Directory directory;

    /**
     * Constructor for the FileCountingCommand class.
     *
     * @param visitor   The FSVisitor to be used for counting.
     * @param directory The Directory on which the counting operation will be performed.
     */
    public FileCountingCommand(FSVisitor visitor, Directory directory) {
        this.visitor = visitor;
        this.directory = directory;
    }

    /**
     * Executes the command to count the number of directories, files, and links within the specified directory.
     * Prints the results to the console.
     */
    @Override
    public void execute() {
        // Accept the visitor to perform the counting operation on the specified directory.
        directory.accept(visitor);

        // Retrieve the counts from the visitor using getter methods.
        int dirNum = ((CountingVisitor) visitor).getDirNum() - 1; // Subtract 1 to exclude the root directory.
        int fileNum = ((CountingVisitor) visitor).getFileNum();
        int linkNum = ((CountingVisitor) visitor).getLinkNum();

        // Print the results to the console.
        System.out.println("Number of Directories: " + dirNum);
        System.out.println("Number of Files: " + fileNum);
        System.out.println("Number of Links: " + linkNum);
    }
}
