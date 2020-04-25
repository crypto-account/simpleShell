package com.lukasz.functionalities;

import com.lukasz.data.CurrentPath;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand {

    public String getParentDirectory(CurrentPath currentPath) {
        String parentPath = "";
        try {
            File file = currentPath.getPath().toFile();
            Path path = Paths.get(file.getParent());
            currentPath.setPath(path);
            parentPath = path.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return parentPath;
    }

    public void getExistingSubdirectory(CurrentPath currentPath, String subdirectory) {
        File file = currentPath.getPath().toFile();
        String name = file.getPath();
        String test = name + "\\" + subdirectory;
        Path path = Paths.get(test);
        currentPath.setPath(path);
    }
}
