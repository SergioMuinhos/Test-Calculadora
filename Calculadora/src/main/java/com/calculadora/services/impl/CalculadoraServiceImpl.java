package com.calculadora.services.impl;

import com.calculadora.dao.operations.*;
import com.calculadora.services.CalculadoraService;
import com.calculadora.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    private Map<String, Operacion> operaciones = new HashMap<>();

    public CalculadoraServiceImpl() {
        operaciones.put(Constants.ADD, new Addicion());
        operaciones.put(Constants.SUBSTRACT, new Substract());
        operaciones.put(Constants.MULTIP, new Multiplication());
        operaciones.put(Constants.DIVIDE, new Division());
    }

    @Override
    public BigDecimal calculo(BigDecimal firstNumber, BigDecimal secondNumber, String operation) {

        log.info("Calculando operacion de {} para : {} y {} ", operation, firstNumber, secondNumber);
        Operacion operacion = operaciones.get(operation);
        if (operacion == null) {
            log.error(Constants.BAD_OPERATION + operation);
            throw new IllegalArgumentException(Constants.BAD_OPERATION + operation);
        }
        BigDecimal resultado = operacion.execute(firstNumber, secondNumber);
        log.info("{} {} {} = {}", firstNumber, operation, secondNumber, resultado);
        return resultado;
    }
}
