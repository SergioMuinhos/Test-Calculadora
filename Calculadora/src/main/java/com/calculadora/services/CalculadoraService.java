package com.calculadora.services;

import java.math.BigDecimal;

public interface CalculadoraService {

    public Double calculo(BigDecimal firstNumber, BigDecimal secondNumber, String operation);
}
