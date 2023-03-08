package com.calculadora.controller;

import com.calculadora.services.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calcular")
    public ResponseEntity<Double> calcula(@RequestParam(name = "firstNumber") BigDecimal firstNumber,
                                          @RequestParam(name = "secondNumber") BigDecimal secondNumber,
                                          @RequestParam(name = "operation") String operation) {
        double result = this.service.calculo(firstNumber, secondNumber, operation);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
