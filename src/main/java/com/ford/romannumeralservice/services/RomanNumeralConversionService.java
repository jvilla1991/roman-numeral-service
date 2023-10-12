package com.ford.romannumeralservice.services;

import com.ford.romannumeralservice.Repositories.MockRomanNumeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConversionService {

    private final MockRomanNumeralRepository mockRomanNumeralRepository;

    @Autowired
    public RomanNumeralConversionService(MockRomanNumeralRepository mockRomanNumeralRepository) {
        this.mockRomanNumeralRepository = mockRomanNumeralRepository;
    }
    public Integer processRomanNumeralToInteger(String romanNumeral) {
        return 0;
    }
}
