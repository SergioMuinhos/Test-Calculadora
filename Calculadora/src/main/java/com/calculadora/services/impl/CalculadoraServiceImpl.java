package com.calculadora.services.impl;

import com.calculadora.services.CalculadoraService;
import com.calculadora.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Slf4j
@Service
public class CalculadoraServiceImpl implements CalculadoraService {
    @Override
    public BigDecimal calculo(BigDecimal firstNumber, BigDecimal secondNumber, String operation) {

        log.info("Calculando operacion de {} para : {} y {} ", operation, firstNumber, secondNumber);
        BigDecimal resultado;
        switch (operation) {
            case Constants.ADD -> resultado = firstNumber.add(secondNumber);
            case Constants.SUBSTRACT -> resultado = firstNumber.subtract(secondNumber);
            case Constants.MULTIP -> resultado = firstNumber.multiply(secondNumber);
            case Constants.DIVIDE -> resultado = firstNumber.divide(secondNumber).round(new MathContext(4));
            default -> {
                log.error(Constants.BAD_OPERATION + operation);
                throw new IllegalArgumentException(Constants.BAD_OPERATION + operation);
            }
        }
        log.info("{} {} {} = {}", firstNumber, operation, secondNumber, resultado);
        return resultado;
    }
}
