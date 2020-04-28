package com.lukasz.functionalities;

import com.lukasz.data.CurrentPath;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand {

    public String getParentDirectory(CurrentPath currentPath) throws InvalidParentDirectory {

        String parentPath = "";
        File file = currentPath.getPath().toFile();
        if (Files.notExists(file.toPath().getParent())) {
            throw new InvalidParentDirectory("Parent directory doesn't exist!");
        }
        Path path = Paths.get(file.getParent());

        currentPath.setPath(path);
        parentPath = path.toString();


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
