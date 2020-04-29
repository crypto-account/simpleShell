package com.lukasz.functionalities;

import com.lukasz.data.CurrentPath;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
    private CurrentPath currentPath;

    public PathManager() {
        this.currentPath = new CurrentPath();
    }

    public Path getCurrentPath() {
        return currentPath.getPath();
    }

    public void setCurrentPath(CurrentPath currentPath) {
        this.currentPath = currentPath;
    }

    public String getExistingSubdirectory(String subdirectory) throws InvalidParentDirectory {
        File file = currentPath.getPath().toFile();
        String name = file.getPath();
        String test = name + "\\" + subdirectory;
        Path path = Paths.get(test);
        if (Files.notExists(path)) {                                                            //TODO make a separate method like below
            throw new InvalidDirectory(String.format("directory %s doesn't exist!", test));
        }
        currentPath.setPath(path);
        return path.toString();
    }


    public String getParentDirectory() throws InvalidParentDirectory {
        String parentPath = "";
        File file = currentPath.getPath().toFile();
        validateIfParentExist(file);
        Path path = Paths.get(file.getParent());
        currentPath.setPath(path);
        parentPath = path.toString();
        return parentPath;
    }

    private void validateIfParentExist(File file) throws InvalidParentDirectory {
        if (file.getParent() == null) {
            throw new InvalidParentDirectory("Parent directory doesn't exist!");
        }
    }


}
