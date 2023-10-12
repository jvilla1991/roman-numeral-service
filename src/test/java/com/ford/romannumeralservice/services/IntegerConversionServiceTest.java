package com.ford.romannumeralservice.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerConversionServiceTest {

    @Test
    void processIntegerToRomanNumeralTest() {
        IntegerConversionService icService = new IntegerConversionService();
        //int input = 1234;
        String output = icService.processIntegerToRomanNumeral(0);
        assertEquals("", output);
    }
}