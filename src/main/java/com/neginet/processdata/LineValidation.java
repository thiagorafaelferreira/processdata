package com.neginet.processdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidation {

    private LineValidation() {};

    public static String getFirstAndLastName(String line) {
        Matcher matcher = Pattern.compile("^[a-zA-Z]*[,][\\s][a-zA-Z]*[\\s$]").matcher(line);
        return matcher.find() ? matcher.group() : null;
    }
}
