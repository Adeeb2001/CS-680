package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.AlphabeticalComparator;
import edu.umb.cs680.hw13.fs.util.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw13.fs.util.SizeComparator;
import edu.umb.cs680.hw13.fs.util.TimestampComparator;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        // Create the file system
        FileSystem fileSystem = FileSystem.getFileSystem();

        // Create root directory
        Directory root = new Directory(null, "root");

        // Add some files and subdirectories to root
        File file1 = new File(root, "b.txt", 100, LocalDateTime.now());
        File file2 = new File(root, "a.txt", 150, LocalDateTime.now());
        Directory dir1 = new Directory(root, "X");
        File file3 = new File(dir1, "d.txt", 120, LocalDateTime.now());
        File file4 = new File(dir1, "c.txt", 80, LocalDateTime.now());
        Directory dir2 = new Directory(root, "Z");
        File file5 = new File(dir2, "f.txt", 200, LocalDateTime.now());

        // Add elements to directories
        root.addChild(file1);
        root.addChild(file2);
        root.addChild(dir1);
        dir1.addChild(file3);
        dir1.addChild(file4);
        root.addChild(dir2);
        dir2.addChild(file5);

        // Add root directory to the file system
        fileSystem.appendRootDir(root);

        System.out.println("Initial Structure:");
        printDirectoryStructure(new FSElementImplementation(root), "");

        // Sort by alphabetical order
        root.sortChildren(new AlphabeticalComparator());
        System.out.println("\nSorted by Alphabetical Order:");
        printDirectoryStructure(new FSElementImplementation(root), "");

        // Sort by reverse alphabetical order
        root.sortChildren(new ReverseAlphabeticalComparator());
        System.out.println("\nSorted by Reverse Alphabetical Order:");
        printDirectoryStructure(new FSElementImplementation(root), "");

        // Sort by size
        root.sortChildren(new SizeComparator());
        System.out.println("\nSorted by Size:");
        printDirectoryStructure(new FSElementImplementation(root), "");

        root.sortChildren(new TimestampComparator());
        System.out.println("\nSorted by Timestamp (Creation Time):");
        printDirectoryStructure(new FSElementImplementation(root), "");
    }

    private static void printDirectoryStructure(FSElementImplementation element, String indentation) {
        System.out.println(indentation + "Directory: " + element.getName());
        if (element.isDirectory()) {
            Directory dir = (Directory) element.getRealFSElement();
            for (FSElementImplementation child : dir.getChildren()) {
                if (child.isDirectory()) {
                    printDirectoryStructure(child, indentation + "  ");
                } else {
                    System.out.println(indentation + "    File: " + child.getName());
                }
            }
        } else {
            System.out.println(indentation + "  File: " + element.getName());
        }
    }
}