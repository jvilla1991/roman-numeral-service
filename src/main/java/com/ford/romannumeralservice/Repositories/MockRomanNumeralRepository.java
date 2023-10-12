package com.ford.romannumeralservice.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Service
public class MockRomanNumeralRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<Integer, String> getData() {
        final String jsonFilePath = "C:\\Users\\jvill\\IdeaProjects\\roman-numeral-service\\src\\main\\resources\\data.json";
        try {
            File file = new File(jsonFilePath);
            if (!file.exists()) {
                throw new FileNotFoundException("The file does not exist.");
            }
            return objectMapper.readValue(file, new TypeReference<Map<Integer, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
