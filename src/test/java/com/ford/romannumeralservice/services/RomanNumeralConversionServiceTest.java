package com.ford.romannumeralservice.services;

import com.ford.romannumeralservice.Repositories.MockRomanNumeralRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConversionServiceTest {

    private RomanNumeralConversionService romanNumeralConversionService;

    @BeforeEach
    public void setUp() {
        romanNumeralConversionService = new RomanNumeralConversionService(new MockRomanNumeralRepository());
    }

    @Test
    void processRomanNumeralToIntegerTest() {
        String testRomanNumeral = "";
        Integer output = romanNumeralConversionService.processRomanNumeralToInteger(testRomanNumeral);
        assert output.getClass() == Integer.class; // Should Always return true
    }

    @Test
    void processRomanNumeralToIntegerOnesTest() {
        String testRomanNumeral = "II";
        Integer output = romanNumeralConversionService.processRomanNumeralToInteger(testRomanNumeral);
        assertEquals(2, output);
    }

    @Test
    void processRomanNumeralToIntegerTensTest() {
        String testRomanNumeral = "XXIII";
        Integer output = romanNumeralConversionService.processRomanNumeralToInteger(testRomanNumeral);
        assertEquals(23, output);
    }

    @Test
    void processRomanNumeralToIntegerHundredsTest() {
        String testRomanNumeral = "CCXXXIV";
        Integer output = romanNumeralConversionService.processRomanNumeralToInteger(testRomanNumeral);
        assertEquals(234, output);
    }
}