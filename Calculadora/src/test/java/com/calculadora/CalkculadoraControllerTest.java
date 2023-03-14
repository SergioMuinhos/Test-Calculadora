package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.services.CalculadoraService;
import com.calculadora.services.impl.CalculadoraServiceImpl;
import com.calculadora.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalkculadoraControllerTest {
/*
   @InjectMocks
   private CalculadoraServiceImpl calculadoraService;

    @Test
    public void testAddition() {
        BigDecimal firstNumber = new BigDecimal(5);
        BigDecimal secondNumber = new BigDecimal(10);
        BigDecimal expected = new BigDecimal(15);

        BigDecimal result = calculadoraService.calculo(firstNumber, secondNumber, Constants.ADD);
        assertEquals(expected, result);
    }*/
}
