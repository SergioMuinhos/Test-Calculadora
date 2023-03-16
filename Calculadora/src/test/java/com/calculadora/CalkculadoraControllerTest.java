package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.services.CalculadoraService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculadoraController.class)
public class  CalkculadoraControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculadoraService calculadoraService;

    @Test
    public void testCalcula() throws Exception {
        // Configuración de prueba
        BigDecimal firstNumber = BigDecimal.valueOf(2);
        BigDecimal secondNumber = BigDecimal.valueOf(3);
        String operation = "SUMA";

        BigDecimal expectedResult = BigDecimal.valueOf(5);
        when(calculadoraService.calculo(firstNumber, secondNumber, operation)).thenReturn(expectedResult);

        // Ejecución de la petición GET
        MvcResult mvcResult = mockMvc.perform(get("/calcular")
                        .param("firstNumber", firstNumber.toString())
                        .param("secondNumber", secondNumber.toString())
                        .param("operation", operation))
                .andExpect(status().isOk())
                .andReturn();

        // Verificación de la respuesta
        String responseBody = mvcResult.getResponse().getContentAsString();
        BigDecimal actualResult = new ObjectMapper().readValue(responseBody, BigDecimal.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
