package com.lukasz.functionalities;

import com.lukasz.data.CurrentPath;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class PromptCommand {
    Scanner scanner = new Scanner(System.in);

    public void displayCurrentWorkingDirectory(CurrentPath currentPath, CdCommand cdCommand) {
        while (true) {
            System.out.print(currentPath.getPath() + ">");
            String userInput = scanner.nextLine();

            if (userInput.equals("cd..")) {
                cdCommand.getParentDirectory(currentPath);
            } else if (userInput.equals("cd " + userInput.substring(3))) {
                cdCommand.getExistingSubdirectory(currentPath, userInput.substring(3));
            } else if (userInput.equals("tree")) {
                displayDirectoryTree(currentPath);
            } else if (userInput.equals("prompt reset")) {
                break;
            }
        }
    }

    public void displayWord(String inputString) {
        System.out.print(inputString + ">");

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("prompt reset")) {
                break;
            } else {
                System.out.print(userInput + ">");
            }
        }
    }

    public void displayDirectoryTree(CurrentPath currentPath) {
        Path path = currentPath.getPath();
        File file = path.toFile();

        for (File listFile : file.listFiles()) {
            StringBuilder stringBuilder = new StringBuilder();

            if (listFile.isDirectory()) {
                String appendBar = "-";
                System.out.println(stringBuilder.append(appendBar) + listFile.getName());
                for (File file1 : listFile.listFiles()) {
                    System.out.println(stringBuilder.append(appendBar) + file1.getName());
                }
            }
        }
    }
}

