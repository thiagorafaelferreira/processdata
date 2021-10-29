package com.neginet.processdata;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StoreNames {
    Map<String, Long> fullNames;
    Map<String, Long> lastNames;
    Map<String, Long> firstNames;
}
