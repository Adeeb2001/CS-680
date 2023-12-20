package edu.umb.cs680.hw17;

import java.time.LocalDateTime;

public interface FSElement {
    String getName();
    int getSize();
    LocalDateTime getCreationTime();
    boolean isDirectory();
}
