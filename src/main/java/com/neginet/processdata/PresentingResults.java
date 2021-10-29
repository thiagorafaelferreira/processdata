package com.neginet.processdata;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentingResults {

    private PresentingResults() {};

    public static void cardinality(StoreNames storeNames) {
        System.out.println();
        System.out.println("1. The names cardinality for full, last, and first names:");
        System.out.println("Full names: " + storeNames.getFullNames().size());
        System.out.println("Last Names: " + storeNames.getLastNames().size());
        System.out.println("First names: " + storeNames.getFirstNames().size());
        System.out.println();
    }

    public static Map<String, Long> commonLastNames(StoreNames storeNames) {
        System.out.println();
        System.out.println("2. The most common last names are:");
        Map<String, Long> result = storeNames.getLastNames().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        return result;
    }

    public static Map<String, Long> commonFirstNames(StoreNames storeNames) {
        System.out.println();
        System.out.println("3. The most common first names are:");
        Map<String, Long> result = storeNames.getFirstNames().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        return result;
    }

    public static void fullNames(StoreNames storeNames) {
        System.out.println();
        System.out.println("List of full names:");
        storeNames.getFullNames()
                .entrySet()
                .stream()
                .forEach(set -> System.out.println(set.getKey()));


        System.out.println();
    }

    public static Map<String, String> fullNamesModified(StoreNames storeNames) {
        System.out.println();
        System.out.println("4. List of Modified Names:");

        Map<String, String> fullNamesModified = new LinkedHashMap<>();

        storeNames.getFullNames().entrySet().stream().forEach( fullName -> {
            System.out.println(fullName.getKey());
            String[] fullNameSplited = fullName.getKey().replace(" ", "").split(",");
            if(!fullNamesModified.containsKey(fullNameSplited[0]) && !fullNamesModified.containsValue(fullNameSplited[1])) {
                fullNamesModified.put(fullNameSplited[0], fullNameSplited[1]);
            }
        });

        System.out.println();
        fullNamesModified.entrySet().stream().forEach(fullNameModified -> System.out.println(fullNameModified.getKey() + ", " + fullNameModified.getValue()));

        System.out.println();

        return fullNamesModified;
    }
}
