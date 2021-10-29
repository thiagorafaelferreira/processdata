package com.neginet.processdata;

import static com.neginet.processdata.LineValidation.getFirstAndLastName;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ProcessFileAndStore {

    private ProcessFileAndStore() {};

    public static void process(BufferedReader bufferedReader, StoreNames storeNames, Integer numberValidLines) throws IOException {
        String line = null;
        Integer countLines = 0;

        while ((line = bufferedReader.readLine()) != null) {
            String lineMatch = getFirstAndLastName(line);
            if (StringUtils.isNotEmpty(lineMatch)) {
                addFullName(storeNames.getFullNames(), lineMatch);
                addLastName(storeNames.getLastNames(), lineMatch);
                addFirstName(storeNames.getFirstNames(), lineMatch);

                // if defined a number of valid lines to process greater then zero,
                // code will be processed until arrive that number
                if(numberValidLines > 0) {
                    if(countLines < (numberValidLines - 1)) {
                        countLines++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static void addName(Map<String, Long> names, String name) {
        names.put(name, names.containsKey(name) ? names.get(name) + 1l : 1l);
    }

    private static void addFullName(Map<String, Long> names, String name) {
        addName(names, name);
    }

    private static void addFirstName(Map<String, Long> names, String name) {
        String firstName = name.replace(" ", "").split(",")[1];
        addName(names, firstName);
    }

    private static void addLastName(Map<String, Long> names, String name) {
        String lastName = name.replace(" ", "").split(",")[0];
        addName(names, lastName);
    }
}
