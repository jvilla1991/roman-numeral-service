package com.ford.romannumeralservice.services;

import com.ford.romannumeralservice.Repositories.MockRomanNumeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RomanNumeralConversionService {

    private final MockRomanNumeralRepository mockRomanNumeralRepository;

    @Autowired
    public RomanNumeralConversionService(MockRomanNumeralRepository mockRomanNumeralRepository) {
        this.mockRomanNumeralRepository = mockRomanNumeralRepository;
    }

    public Integer processRomanNumeralToInteger(String romanNumeral) {
        Integer output = 0;
        StringBuilder sbInput = new StringBuilder(romanNumeral);
        Map<Integer, String> romanNumeralMap = mockRomanNumeralRepository.getData();
        // To Reverse the Map for matching string patterns, first converse the map into a list
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(romanNumeralMap.entrySet());

        // Reverse the list
        Collections.reverse(entryList);

        // Create a new LinkedHashMap and add entries in reversed order
        Map<Integer, String> reversedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entryList) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Integer, String> entry : reversedMap.entrySet()) {
            int startIndexOfSubstring = sbInput.indexOf(entry.getValue());
            if (startIndexOfSubstring != -1) {
                output += entry.getKey();
                sbInput.delete(startIndexOfSubstring, entry.getValue().length());
            }
        }
        return output;
    }
}
