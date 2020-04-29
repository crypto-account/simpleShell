package com.lukasz.data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class CurrentPath {
    private Path path;
//    private List<String> subdirectories = new LinkedList<>();

    public CurrentPath() {
        path = Paths.get(System.getProperty("user.dir"));
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

//    public List<String> getSubdirectories() {
//        return subdirectories;
//    }
}

