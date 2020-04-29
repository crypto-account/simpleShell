package com.lukasz;

import com.lukasz.data.CurrentPath;
import com.lukasz.functionalities.StatisticCommand;
import com.lukasz.functionalities.*;

import java.util.Map;
import java.util.Scanner;

public class App {
    private static final String dir = "dir";
    private static final String getParentDir = "cd..";
    private static final String statistics = "statistics";
    private static final String prompt = "prompt";
    private static final String cd = "cd";
    private static final String exit = "exit";
    private static final String prompt$cwd = "prompt $cwd";
    private static final String sign = "$>";
    private static final String bye = "bye";
    private static final String userSaid = "User said";

    PathManager pathManager = new PathManager();
    Scanner scanner = new Scanner(System.in);
    DirCommand dirCommand = new DirCommand();
    ICommand cdCommand = new CdCommand(pathManager);
    CurrentPath currentPath = new CurrentPath();
    PromptCommand promptCommand = new PromptCommand(pathManager);
    StatisticCommand statisticCommand = new StatisticCommand();


    public void startShell() {
        while (true) {
            System.out.print(sign);
            String userInput = scanner.nextLine();

            if (userInput.equals(dir)) {
                dirCommand.displayCurrentPath(currentPath);
                dirCommand.displayDirectoryContent(currentPath);
            } else if (userInput.equals(getParentDir)) {
                try {
                    System.out.println(cdCommand.executeCommand(userInput));
                } catch (InvalidParentDirectory invalidParentDirectory) {
                    invalidParentDirectory.printStackTrace();
                }
                statisticCommand.addCommand(cd);
            } else if ((userInput.length() > 3) && (userInput.equals(cd + " " + userInput.substring(3)))) {
                cdCommand.executeCommand(userInput);
                statisticCommand.addCommand(cd);
            } else if (userInput.equals(prompt$cwd)) {
                try {
                    promptCommand.displayCurrentWorkingDirectory(currentPath);
                } catch (InvalidParentDirectory invalidParentDirectory) {
                    invalidParentDirectory.printStackTrace();
                }
                statisticCommand.addCommand(prompt);
            } else if ((userInput.length() > 7) && (userInput.equals(prompt + " " + userInput.substring(7)))) {
                promptCommand.displayWord(userInput.substring(7));
                statisticCommand.addCommand(prompt);
            } else if ((userInput.equals(statistics))) {
                statisticCommand.addCommand(statistics);
                Map statistics = statisticCommand.getStatistics(statisticCommand.getCommandsList());
                statisticCommand.printStatistics(statistics);
            } else if ((userInput.equals(exit))) {
                System.out.println(bye);
                break;
            } else {
                System.out.println(userSaid + " " + userInput);
            }
        }
    }
}
//9. Spróbuj ciąg if else() z klasy app zamienić na coś innego, tak aby użyć tam wzorca Strategia
//       (np Hashmapę z kluczem jako komenda oraz wartością jako interfejs wspólny dla wszystkich komend).


