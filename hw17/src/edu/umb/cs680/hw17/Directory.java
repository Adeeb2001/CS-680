package edu.umb.cs680.hw17;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Comparator;


public class Directory implements FSElement {
    private Directory parent;
    private String name;
    private LinkedList<FSElementImpl> children;
    private LocalDateTime creationTime;

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        this.children = new LinkedList<>();
        this.creationTime = LocalDateTime.now();
    }

    public void addChild(FSElement realFSElement) {
        FSElementImpl proxy = new FSElementImpl(realFSElement);
        children.add(proxy);
    }

    public LinkedList<FSElementImpl> getChildren() {
        return new LinkedList<>(children);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(FSElementImpl::getSize).sum();
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public Directory getParent() {
        return parent;
    }

    public void sortChildrenAlphabetically() {
        children.sort(Comparator.comparing(o -> o.getRealFSElement().getName().toLowerCase(Locale.ROOT)));
    }

    public void sortChildrenReverseAlphabetically() {
        children.sort(Comparator.comparing(o -> o.getRealFSElement().getName().toLowerCase(Locale.ROOT), Collections.reverseOrder()));
    }

    public void sortChildrenBySize() {
        children.sort(Comparator.comparing(o -> o.getRealFSElement().getSize()));
    }
}
