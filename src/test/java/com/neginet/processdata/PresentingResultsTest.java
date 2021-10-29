package com.neginet.processdata;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PresentingResultsTest {
    @Test
    public void commonFirstNamesOrderedTest() {
        StoreNames storeName = new StoreNames(new HashMap<>(), new HashMap<>(), new HashMap<>());
        storeName.getFirstNames().put("Megan", 3l);
        storeName.getFirstNames().put("Jhon", 1l);
        storeName.getFirstNames().put("Mary", 8l);
        storeName.getFirstNames().put("Joshua", 5l);
        storeName.getFirstNames().put("Jonathan", 1l);
        Map<String, Long> firstNameOrderded = PresentingResults.commonFirstNames(storeName);
        String firtObject = "";
        for(Map.Entry<String, Long> name: firstNameOrderded.entrySet()) {
            firtObject = name.getKey();
            break;
        }
        Assertions.assertEquals("Mary", firtObject);
    }

    @Test
    public void commonLastNamesOrderedTest() {
        StoreNames storeName = new StoreNames(new HashMap<>(), new HashMap<>(), new HashMap<>());
        storeName.getLastNames().put("Megan", 3l);
        storeName.getLastNames().put("Jhon", 1l);
        storeName.getLastNames().put("Mary", 8l);
        storeName.getLastNames().put("Joshua", 5l);
        storeName.getLastNames().put("Jonathan", 1l);
        Map<String, Long> lastNameOrderded = PresentingResults.commonLastNames(storeName);
        String firtObject = "";
        for(Map.Entry<String, Long> name: lastNameOrderded.entrySet()) {
            firtObject = name.getKey();
            break;
        }
        Assertions.assertEquals("Mary", firtObject);
    }

    @Test
    public void commonFullNamesOrderedTest() {
        StoreNames storeName = new StoreNames(new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>());
        storeName.getFullNames().put("Smith, Joan", 1l);
        storeName.getFullNames().put("Smith, John", 1l);
        storeName.getFullNames().put("Smith, Sam", 1l);
        storeName.getFullNames().put("Thomas, Joan", 1l);
        storeName.getFullNames().put("Upton, Joan", 1l);
        storeName.getFullNames().put("Upton, Tom", 1l);
        storeName.getFullNames().put("Vasquez, Cesar", 1l);
        Map<String, String> lastNameOrderded = PresentingResults.fullNamesModified(storeName);
        String keyFromFirstObject = "";
        String valueFromFirstObject = "";
        for(Map.Entry<String, String> name: lastNameOrderded.entrySet()) {
            keyFromFirstObject = name.getKey();
            valueFromFirstObject = name.getValue();
            break;
        }
        Assertions.assertEquals("Smith", keyFromFirstObject);
        Assertions.assertEquals("Joan", valueFromFirstObject);
    }
}
