package com.lukasz.functionalities;

public class CdCommand implements ICommand {
    PathManager pathManager;

    public CdCommand(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    @Override
    public String executeCommand(String string) {
        String returnDirectory = null;

        if (string.equals("cd..")) {
            returnDirectory = pathManager.getParentDirectory();
        } else {
            returnDirectory = pathManager.getExistingSubdirectory(parseCommand(string));
        }
        return returnDirectory;
    }

    private String parseCommand(String string) {
        return string.substring(3);
    }

}
