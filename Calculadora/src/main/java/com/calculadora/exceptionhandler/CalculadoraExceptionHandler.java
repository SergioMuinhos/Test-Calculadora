package com.calculadora.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CalculadoraExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleResponseStatusException() {
        return new ResponseEntity<>("division by zero", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler() {
        return new ResponseEntity<>("Ha ocurrido un error", HttpStatus.BAD_REQUEST);
    }

}
