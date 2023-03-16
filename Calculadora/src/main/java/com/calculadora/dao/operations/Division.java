package com.calculadora.dao.operations;

import com.calculadora.utils.Constants;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Division implements Operacion {
    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        if (secondNumber.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(Constants.DIVIDE_BY_ZERO);
        }
        return firstNumber.divide(secondNumber, 4, RoundingMode.HALF_UP).round(new MathContext(4));
    }
}