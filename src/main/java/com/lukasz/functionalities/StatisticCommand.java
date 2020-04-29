package com.lukasz.functionalities;

import java.util.*;

public class StatisticCommand {
    List<String> commandsList = new LinkedList<>();

    public List<String> getCommandsList() {
        return commandsList;
    }

    public void addCommand(String command) {
        commandsList.add(command);
    }

    public Map getStatistics(List<String> commandsList) {
        Map<String, Integer> magazineStringOccurrenceMap = new HashMap<>();

        for (String command : commandsList) {
            if (magazineStringOccurrenceMap.containsKey(command)) {
                magazineStringOccurrenceMap.put(command, magazineStringOccurrenceMap.get(command) + 1);
            } else {
                magazineStringOccurrenceMap.put(command, 1);
            }
        }
        return magazineStringOccurrenceMap;
    }

    public void printStatistics(Map<String,Integer> commandsStatistics){
        commandsStatistics.forEach((key, value) -> System.out.println(key + ":" + value));

    }
}
