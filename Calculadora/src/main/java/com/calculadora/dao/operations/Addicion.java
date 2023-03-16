package com.calculadora.dao.operations;

import java.math.BigDecimal;

public class Addicion implements Operacion{
    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }
}
