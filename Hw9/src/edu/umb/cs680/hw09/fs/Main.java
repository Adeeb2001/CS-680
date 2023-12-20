package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // Create the file system
        FileSystem fileSystem = FileSystem.getFileSystem();

        // Create root directory
        Directory root = new Directory(null, "repo", LocalDateTime.now());

        // Create readme.md file
        File readme = new File(root, "readme.md", 100, LocalDateTime.now());
        root.appendChild(readme);

        // Create src directory
        Directory rootSrc = new Directory(root, "src", LocalDateTime.now());
        // Create A.java and B.java files in src directory
        File aJava = new File(rootSrc, "A.java", 200, LocalDateTime.now());
        File bJava = new File(rootSrc, "B.java", 150, LocalDateTime.now());
        // Add A.java and B.java to src directory
        rootSrc.appendChild(aJava);
        rootSrc.appendChild(bJava);
        root.appendChild(rootSrc);

        // Create test directory
        Directory test = new Directory(root, "test", LocalDateTime.now());

        // Create test/src directory inside test
        Directory testSrc = new Directory(test, "src", LocalDateTime.now());
        // Create ATest.java and BTest.java files in test/src directory
        File aTestJava = new File(testSrc, "ATest.java", 120, LocalDateTime.now());
        File bTestJava = new File(testSrc, "BTest.java", 180, LocalDateTime.now());
        Link link = new Link(test, "rm.md", 80, LocalDateTime.now(), readme);
        // Add ATest.java and BTest.java links to test/src directory
        testSrc.appendChild(aTestJava);
        testSrc.appendChild(bTestJava);
        testSrc.appendChild(link);

        // Add test/src directory to test directory
        test.appendChild(testSrc);
        root.appendChild(test);

        // Add root directory to the file system
        fileSystem.appendRootDir(root);

        LinkedList<Directory> rootDirs = fileSystem.getRootDirs();
        for (Directory r : rootDirs) {
            FSElementImplementation rootImpl = new FSElementImplementation(r);
            printElement(rootImpl, "");
        }

        CountingVisitor countingVisitor = new CountingVisitor();
        root.accept(countingVisitor);
        int dirNum = countingVisitor.getDirNum() - 1;
        int fileNum = countingVisitor.getFileNum();
        int linkNum = countingVisitor.getLinkNum();

        System.out.println("Number of Directories: " + dirNum);
        System.out.println("Number of Files: " + fileNum);
        System.out.println("Number of Links: " + linkNum);

        String fileNameToSearch = "ATest.java";
        FileSearchVisitor searchVisitor = new FileSearchVisitor(fileNameToSearch);
        root.accept(searchVisitor);

        LinkedList<String> foundFiles = searchVisitor.getFoundFiles();

        if (!foundFiles.isEmpty()) {
            System.out.println("Found file with name '" + fileNameToSearch + "':");
            System.out.println(foundFiles.getFirst()); // Print the first found file path
        } else {
            System.out.println("No file found with name '" + fileNameToSearch + "'.");
        }

        // Create a FileCrawlingVisitor
        FileCrawlingVisitor crawlingVisitor = new FileCrawlingVisitor();

        // Traverse the file system with the crawlingVisitor
        root.accept(crawlingVisitor);

        // Get the list of collected files
        LinkedList<File> allFiles = crawlingVisitor.getFiles();

        // Print the names of all collected files
        System.out.println("All Files in the File System:");
        for (File file : allFiles) {
            System.out.println(file.getName());
        }
    }

    private static void printElement(FSElementImplementation element, String indentation) {
        System.out.println(indentation + "Name: " + element.getName());
        System.out.println(indentation + "Size: " + element.getSize());
        System.out.println(indentation + "Is Directory: " + element.isDirectory());
        System.out.println(indentation + "Is Linked: " + element.isLinked());

        // If it's a link, print information about the target file
        if (element.isLinked()) {
            Link fileLink = (Link) element.getRealFSElement();
            FSElement target = fileLink.getTarget();
            System.out.println(indentation + "Target File Name: " + target.getName());
            System.out.println(indentation + "Target File Size: " + target.getSize());
            System.out.println(indentation + "Target File Is Directory: " + target.isDirectory());
        }

        // If it's a directory, recursively print its children
        if (element.isDirectory()) {
            Directory directory = (Directory) element.getRealFSElement();
            for (FSElement child : directory.getChildren()) {
                printElement(new FSElementImplementation(child), indentation + "  ");
            }
        }
    }
}
