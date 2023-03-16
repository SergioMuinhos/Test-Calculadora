package com.calculadora.dao.operations;

import java.math.BigDecimal;

public interface Operacion {
    BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber);
}
