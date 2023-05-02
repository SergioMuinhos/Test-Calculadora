package com.calculadora.services;


import java.math.BigDecimal;


public interface CalculadoraService {

    BigDecimal calculo(BigDecimal firstNumber, BigDecimal secondNumber, String operation);
}
