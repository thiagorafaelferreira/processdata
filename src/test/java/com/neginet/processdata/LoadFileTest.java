package com.neginet.processdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class LoadFileTest {

    private static final String source = "src/test/resources/coding-test-data.txt";

    @Test
    public void readTextFileShowFirstLineTest() throws IOException {
        BufferedReader reader = LoadFile.readFileText(source);

        String line = reader.readLine();
        assertEquals("Graham, Mckenna -- ut", line);
    }

    @Test
    public void readTextFileShowMoreLinesTest() throws IOException {
        BufferedReader reader = LoadFile.readFileText(source);
        List<String> fullNames = new ArrayList<>();
        Integer count = 0;
        String line;
        while(( line = reader.readLine()) != null) {
            String lineMatch = LineValidation.getFirstAndLastName(line);

            if(StringUtils.isNotEmpty(lineMatch))
                fullNames.add(lineMatch);

            count++;

            if(count == 10) break;
        }

        assertEquals("Graham, Mckenna ", fullNames.get(0));
        assertEquals("Marvin, Garfield ", fullNames.get(1));
        assertEquals("McLaughlin, Mariah ", fullNames.get(2));
    }
}
