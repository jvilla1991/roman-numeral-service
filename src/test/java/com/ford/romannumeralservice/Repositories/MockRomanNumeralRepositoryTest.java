package com.ford.romannumeralservice.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MockRomanNumeralRepositoryTest {

    @Mock
    private ObjectMapper objectMapper = new ObjectMapper();

    private MockRomanNumeralRepository mockRomanNumeralRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockRomanNumeralRepository = new MockRomanNumeralRepository();
    }

    @Test
    void readRomanNumeralFromJsonTest() {
        String output = mockRomanNumeralRepository.readDataFromJson(1);
        assertEquals("I", output);

        output = mockRomanNumeralRepository.readDataFromJson(1000);
        assertEquals("M", output);
    }

}
