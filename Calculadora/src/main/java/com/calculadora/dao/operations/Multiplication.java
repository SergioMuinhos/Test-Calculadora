package com.calculadora.dao.operations;

import java.math.BigDecimal;

public class Multiplication implements Operacion {
    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.multiply(secondNumber);
    }
}
