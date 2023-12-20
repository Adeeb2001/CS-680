package edu.umb.cs680.hw17;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return new LinkedList<>(rootDirs);
    }

    public void appendRootDir(Directory root) {
        clearRootDirs();
        rootDirs.add(root);
    }

    private void clearRootDirs() {
        rootDirs.clear();
    }
}
