package com.ford.romannumeralservice.controllers;

import com.ford.romannumeralservice.services.IntegerConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integer")
public class IntegerController {

    @Autowired
    private IntegerConversionService incService;

    @GetMapping("/convert/{number}")
    public ResponseEntity<String> convertRomanNumeralToInteger(@PathVariable Integer number) {
        String output = incService.processIntegerToRomanNumeral(number);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
