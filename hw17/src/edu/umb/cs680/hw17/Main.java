package edu.umb.cs680.hw17;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create a file system
        FileSystem fileSystem = FileSystem.getFileSystem();

        // Create root directory
        Directory rootDir = new Directory(null, "Root");

        // Create subdirectories
        Directory documents = new Directory(rootDir, "Documents");
        Directory pictures = new Directory(rootDir, "Pictures");

        // Create files
        File resume = new File(documents, "Resume.pdf", 200, LocalDateTime.now());
        File photo1 = new File(pictures, "Photo1.jpg", 300, LocalDateTime.now());
        File photo2 = new File(pictures, "Photo2.jpg", 250, LocalDateTime.now());

        // Create a link
        Link resumeLink = new Link(pictures, "ResumeLink", 100, LocalDateTime.now(), resume);

        // Add elements to directories
        rootDir.addChild(documents);
        rootDir.addChild(pictures);
        documents.addChild(resume);
        pictures.addChild(photo1);
        pictures.addChild(photo2);
        pictures.addChild(resumeLink);

        // Print information
        System.out.println("Root directory size: " + rootDir.getSize() + " bytes");
        System.out.println("Documents directory size: " + documents.getSize() + " bytes");
        System.out.println("Pictures directory size: " + pictures.getSize() + " bytes");

        // Sort directories alphabetically and print names
        rootDir.sortChildrenAlphabetically();
        System.out.println("Directories sorted alphabetically:");
        rootDir.getChildren().forEach(d -> System.out.println(d.getName()));

        // Sort directories by size and print names
        rootDir.sortChildrenBySize();
        System.out.println("Directories sorted by size:");
        rootDir.getChildren().forEach(d -> System.out.println(d.getName()));
    }
}
