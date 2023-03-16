package com.calculadora.dao.operations;

import java.math.BigDecimal;

public class Substract implements Operacion {
    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.subtract(secondNumber);
    }
}