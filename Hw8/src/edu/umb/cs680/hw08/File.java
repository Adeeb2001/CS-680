package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

/**
 * The `File` class represents a file in a file system. It implements the `FSElement` interface
 * and represents a basic unit of data storage.
 */
public class File extends FSElement {
    private String name;
    private int size;

    private LocalDateTime creationTime;

    /**
     * Constructs a file with the specified name and size.
     *
     * @param name The name of the file.
     * @param size The size of the file in bytes.
     */
    public File(String name, int size,LocalDateTime creationTime) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public int getTotalSize() {
        return getSize(); // The total size of a file is just its own size
    }


}
