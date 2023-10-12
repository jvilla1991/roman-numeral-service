package com.ford.romannumeralservice.services;

import com.ford.romannumeralservice.Repositories.MockRomanNumeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IntegerConversionService {

    private final MockRomanNumeralRepository mockRomanNumeralRepository;

    @Autowired
    public IntegerConversionService(MockRomanNumeralRepository mockRomanNumeralRepository) {
        this.mockRomanNumeralRepository = mockRomanNumeralRepository;
    }

    public String processIntegerToRomanNumeral(Integer number) {
        StringBuilder sbOutput = new StringBuilder();
        Map<Integer, String> romanNumeralMap = mockRomanNumeralRepository.getData();
        while(number > 0) {
            if (number / 1000 != 0) {
                sbOutput.append(romanNumeralMap.get((number / 1000) * 1000));
                number = number % 1000;
            }
            else if (number / 100 != 0) {
                sbOutput.append((romanNumeralMap.get((number / 100) * 100));
                number = number % 100;
            }
            else if (number / 10 != 0) {
                sbOutput.append((romanNumeralMap.get((number / 10) * 10));
                number = number % 10;
            }
            else {
                sbOutput.append(romanNumeralMap.get(number));
                number -= number;
            }
        }
        return sbOutput.toString();
    }

}
