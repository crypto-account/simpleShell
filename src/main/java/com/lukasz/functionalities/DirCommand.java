package com.lukasz.functionalities;

import com.lukasz.data.CurrentPath;

import java.io.File;
import java.nio.file.Path;

public class DirCommand {

    public void displayCurrentPath(CurrentPath currentPath) {
        System.out.println("Content of " + currentPath.getPath());
    }

    public void displayDirectoryContent(CurrentPath currentPath) {
        try {
            Path path = currentPath.getPath();
            File file = path.toFile();
            for (File listFile : file.listFiles()) {
                if (listFile.isDirectory()) {
                    System.out.println("DIR " + listFile.getName());
                } else {
                    System.out.println("FILE " + listFile.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
