package com.lukasz;

import com.lukasz.data.CurrentPath;
import com.lukasz.data.StatisticCommand;
import com.lukasz.functionalities.CdCommand;
import com.lukasz.functionalities.DirCommand;
import com.lukasz.functionalities.InvalidParentDirectory;
import com.lukasz.functionalities.PromptCommand;

import java.util.Map;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    DirCommand dirCommand = new DirCommand();
    CdCommand cdCommand = new CdCommand();
    CurrentPath currentPath = new CurrentPath();
    PromptCommand promptCommand = new PromptCommand();
    StatisticCommand statisticCommand = new StatisticCommand();

    public void startShell() {
        while (true) {
            System.out.print("$>");
            String userInput = scanner.nextLine();

            if (userInput.equals("dir")) {
                dirCommand.displayCurrentPath(currentPath);
                dirCommand.displayDirectoryContent(currentPath);
                statisticCommand.countCommand("dir");
            } else if (userInput.equals("cd..")) {
                try {
                    System.out.println(cdCommand.getParentDirectory(currentPath));
                } catch (InvalidParentDirectory invalidParentDirectory) {
                    invalidParentDirectory.printStackTrace();
                }
                statisticCommand.countCommand("cd");
            } else if ((userInput.length() > 3) && (userInput.equals("cd " + userInput.substring(3)))) {
                cdCommand.getExistingSubdirectory(currentPath, userInput.substring(3));
                statisticCommand.countCommand("cd");
            } else if (userInput.equals("prompt $cwd")) {
                try {
                    promptCommand.displayCurrentWorkingDirectory(currentPath, cdCommand);
                } catch (InvalidParentDirectory invalidParentDirectory) {
                    invalidParentDirectory.printStackTrace();
                }
                statisticCommand.countCommand("prompt");
            } else if ((userInput.length() > 7) && (userInput.equals("prompt " + userInput.substring(7)))) {
                promptCommand.displayWord(userInput.substring(7));
                statisticCommand.countCommand("prompt");
            } else if ((userInput.equals("statistics"))) {
                statisticCommand.countCommand("statistics");
                Map statistics = statisticCommand.getStatistics(statisticCommand.getCommandsList());
                statisticCommand.printStatistics(statistics);
            } else if ((userInput.equals("exit"))) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("User said " + userInput);
            }
        }
    }
}


