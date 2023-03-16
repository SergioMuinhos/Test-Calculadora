package com.calculadora.controller;


import com.calculadora.services.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;

@ControllerAdvice
@RestController
@EnableWebMvc
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @Autowired
    private TracerImpl tracer;


    @GetMapping(value = "/calcular")
    public ResponseEntity<BigDecimal> calcula(@RequestParam(name = "firstNumber") BigDecimal firstNumber,
                                              @RequestParam(name = "secondNumber") BigDecimal secondNumber,
                                              @RequestParam(name = "operation") String operation) {
        BigDecimal result = this.service.calculo(firstNumber, secondNumber, operation);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
