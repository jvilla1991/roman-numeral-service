package com.ford.romannumeralservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.romannumeralservice.Repositories.MockRomanNumeralRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class IntegerConversionServiceTest {

    @Mock
    private MockRomanNumeralRepository mockRomanNumeralRepository;

    @BeforeEach
    public void setUp() {
        mockRomanNumeralRepository = new MockRomanNumeralRepository();
    }

    @Test
    void processIntegerToRomanNumeralInOnesTest() {
        IntegerConversionService icService = new IntegerConversionService(mockRomanNumeralRepository);
        String output = icService.processIntegerToRomanNumeral(2);
        assertEquals("II", output);
    }

    @Test
    void processIntegerToRomanNumeralWhenInTensTest() {
        IntegerConversionService icService = new IntegerConversionService(mockRomanNumeralRepository);
        String output = icService.processIntegerToRomanNumeral(23);
        assertEquals("XXIII", output);
    }

}