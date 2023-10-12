package com.ford.romannumeralservice.controllers;

import com.ford.romannumeralservice.services.IntegerConversionService;
import com.ford.romannumeralservice.services.RomanNumeralConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roman-numeral")
public class RomanNumeralController {

    @Autowired
    private RomanNumeralConversionService rncService;

    @GetMapping("/convert/{romanNumeral}")
    public ResponseEntity<Integer> convertRomanNumeralToInteger(String romanNumeral) {
        Integer output = rncService.processRomanNumeralToInteger(romanNumeral);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
