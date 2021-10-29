package com.neginet.processdata;

import static com.neginet.processdata.LoadFile.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessdataApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProcessdataApplication.class, args);
		StoreNames storeNames = new StoreNames(new HashMap<>(), new HashMap<>(), new HashMap<>());
		BufferedReader bufferedReader = readFileText("src/main/resources/coding-test-data.txt");
		ProcessFileAndStore.process(bufferedReader, storeNames, 25);
		PresentingResults.cardinality(storeNames);
		PresentingResults.commonLastNames(storeNames);
		PresentingResults.commonFirstNames(storeNames);
		PresentingResults.fullNames(storeNames);
		PresentingResults.fullNamesModified(storeNames);
	}
}
