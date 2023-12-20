package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * The `testFixtureInitializer` class serves as a test fixture initializer for the file system simulation.
 * It creates a simulated file system with drives C, D, and E, along with home directories and files,
 * and performs operations to demonstrate the functionality of the file system classes.
 */
public class testFixtureInitializer {

    public static void main(String[] args) {
        // Get the FileSystem singleton instance
        FileSystem fileSystem = FileSystem.getFileSystem();

        // Create the root directory for the repository (repo)
        Directory repo = new Directory("repo", LocalDateTime.now());

        // Create home directories within the repo
        Directory repoSrc = new Directory( "src", LocalDateTime.now());
        Directory repoTest = new Directory( "test", LocalDateTime.now());
        Directory testSrc = new Directory( "src", LocalDateTime.now());

        // Create files within the home directories
        File readme_md = new File("readme.md", 100, LocalDateTime.now());
        File A_java = new File( "A.java", 120, LocalDateTime.now());
        File B_java = new File( "B.java", 180, LocalDateTime.now());
        File A_javaTest = new File( "ATest.java", 90, LocalDateTime.now());
        File B_javaTest = new File( "BTest.java", 200, LocalDateTime.now());
        Link rm_md = new Link("rm.md", 200, LocalDateTime.now(), readme_md);

        // Append the files to the home directories
        repoSrc.appendChild(A_java);
        repoSrc.appendChild(B_java);
        testSrc.appendChild(A_javaTest);
        testSrc.appendChild(B_javaTest);
        testSrc.appendChild(rm_md);
        repoTest.appendChild(testSrc);

        // Append the files and directories to the repo
        repo.appendChild(readme_md);
        repo.appendChild(repoTest);
        repo.appendChild(repoSrc);

        // Append the repo directory to the FileSystem
        fileSystem.appendRootDir(repo);

        // Get the total size of the repo directory
        int repoTotalSize = repo.getTotalSize();
        System.out.println("Total size of the repo: " + repoTotalSize + " bytes");

        // Iterate through all elements in the repo directory and print their information
        iterateDriveContents(repo);
    }

    /**
     * Iterates through the contents of a directory and prints information about each file system element.
     *
     * @param drive The directory to iterate through.
     */
    private static void iterateDriveContents(Directory drive) {
        System.out.println("Drive Contents for " + drive.getName() + ":");
        printElementInfo(drive, 0); // Print info for the drive itself
        iterateContents(drive, 1); // Iterate through its contents
        System.out.println("---------------");
    }

    /**
     * Recursively iterates through the contents of a directory and prints information about each file system element.
     *
     * @param directory The directory to iterate through.
     * @param depth     The depth of the recursion (used for indentation in printing).
     */
    private static void iterateContents(Directory directory, int depth) {
        for (FSElement element : directory.getChildren()) {
            printElementInfo(element, depth);
            if (element.isDirectory()) {
                iterateContents((Directory) element, depth + 1);
            }
        }
    }

    /**
     * Prints information about a file system element, including its name, creation time, and size.
     *
     * @param element The file system element to print information about.
     * @param depth   The depth of the recursion (used for indentation in printing).
     */
    private static void printElementInfo(FSElement element, int depth) {
        String indent = " ".repeat(depth * 2);
        System.out.println(indent + "Name: " + element.getName());
        System.out.println(indent + "Creation Time: " + element.getCreationTime());
        System.out.println(indent + "Size: " + element.getSize() + " bytes");

        if (element instanceof Link) {
            Link link = (Link) element;
            System.out.println(indent + "Target Linked File: " + link.getTarget().getRealFSElement().getName());
        }

        System.out.println(indent + "---------------");
    }
}
