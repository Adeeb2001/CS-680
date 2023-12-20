package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSCommand;
import edu.umb.cs680.hw10.fs.FSVisitor;

import java.util.LinkedList;

/**
 * The FileSearchingCommand class implements the FSCommand interface and is responsible for
 * executing a command to search for a specific file within a specified directory.
 */
public class FileSearchingCommand implements FSCommand {

    // The FSVisitor used to perform the file search.
    private final FSVisitor visitor;

    // The name of the file to search for.
    private final String fileName;

    // The directory in which the search will be performed.
    private final Directory dir;

    // A linked list to store the paths of found files.
    private final LinkedList<String> foundFiles;

    /**
     * Constructor for the FileSearchingCommand class.
     *
     * @param visitor   The FSVisitor to be used for searching.
     * @param fileName  The name of the file to search for.
     * @param dir       The Directory in which the search will be performed.
     */
    public FileSearchingCommand(FSVisitor visitor, String fileName, Directory dir) {
        this.visitor = visitor;
        this.fileName = fileName;
        this.dir = dir;
        this.foundFiles = new LinkedList<>();
    }

    /**
     * Executes the command to search for a specific file within the specified directory.
     * Uses a FileSearchVisitor to perform the search and collects the paths of found files.
     */
    @Override
    public void execute() {
        // Create a FileSearchVisitor with the specified file name.
        FileSearchVisitor searchVisitor = new FileSearchVisitor(fileName);

        // Accept the visitor to perform the search operation on the specified directory.
        dir.accept(searchVisitor);

        // Retrieve the paths of found files from the search visitor and add them to the list.
        foundFiles.addAll(searchVisitor.getFoundFiles());
    }

    /**
     * Checks if any files matching the search criteria were found.
     *
     * @return True if at least one file was found, false otherwise.
     */
    public boolean hasFoundFile() {
        return !foundFiles.isEmpty();
    }

    /**
     * Retrieves the path of the first found file.
     * Throws an exception if no file is found.
     *
     * @return The path of the first found file.
     * @throws IllegalStateException If no file is found.
     */
    public String getFirstFoundFilePath() {
        if (hasFoundFile()) {
            return foundFiles.getFirst();
        } else {
            throw new IllegalStateException("No file found with name '" + fileName + "'.");
        }
    }
}
