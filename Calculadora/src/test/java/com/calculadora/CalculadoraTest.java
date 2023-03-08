package com.calculadora;

import com.calculadora.services.CalculadoraService;
import com.calculadora.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraTest {

    @Autowired
    private CalculadoraService service;


    @Test
    public void testMultiplication() {
        BigDecimal firstNumber = BigDecimal.valueOf(10);
        BigDecimal secondNumber = BigDecimal.valueOf(20);
        Double expected = 200.0;

        Double actual = service.calculo(firstNumber, secondNumber, Constants.MULTIP);

        assertEquals(expected, actual, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperation() {
        BigDecimal firstNumber = BigDecimal.valueOf(10);
        BigDecimal secondNumber = BigDecimal.valueOf(20);

        Double actual = service.calculo(firstNumber, secondNumber, "invalid");
        fail("IllegalArgumentException expected but not thrown");
    }

}
