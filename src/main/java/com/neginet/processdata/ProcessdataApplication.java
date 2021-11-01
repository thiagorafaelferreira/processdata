package com.neginet.processdata;

import static com.neginet.processdata.LoadFile.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessdataApplication {
	// If set this parameter with value 0 will process the entire file
	// If set this parameter with other value like 25, will process just first 25 lines with names from the file.
	private static Integer NUMBER_LINES_PROCESSED = 0;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProcessdataApplication.class, args);
		StoreNames storeNames = new StoreNames(new HashMap<>(), new HashMap<>(), new HashMap<>());
		BufferedReader bufferedReader = readFileText("src/main/resources/coding-test-data.txt");
		ProcessFileAndStore.process(bufferedReader, storeNames, NUMBER_LINES_PROCESSED);
		PresentingResults.cardinality(storeNames);
		PresentingResults.commonLastNames(storeNames);
		PresentingResults.commonFirstNames(storeNames);
		// PresentingResults.fullNames(storeNames);
		PresentingResults.fullNamesModified(storeNames);
	}
}
