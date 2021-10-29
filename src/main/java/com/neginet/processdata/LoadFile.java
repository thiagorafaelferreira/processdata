package com.neginet.processdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadFile {

    private LoadFile() {};

    public static BufferedReader readFileText(String source) {
        Path path = Paths.get(source);
        try {
            return Files.newBufferedReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
