package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.services.CalculadoraService;
import com.calculadora.utils.CalculadoraConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CalculadoraController.class)
@Import(CalculadoraConfig.class)
public class StandAloneControllerTests {

    @MockBean
    private CalculadoraService calculadoraService;

    @InjectMocks
    @Autowired
    private CalculadoraController calculadoraController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void calcula_withValidRequest_returns200Ok() throws Exception {
        BigDecimal firstNumber = BigDecimal.valueOf(5);
        BigDecimal secondNumber = BigDecimal.valueOf(2);
        String operation = "SUMAR";

        when(calculadoraService.calculo(firstNumber, secondNumber, operation))
                .thenReturn(BigDecimal.valueOf(7));

        mockMvc.perform(get("/calcular")
                        .param("firstNumber", "5")
                        .param("secondNumber", "2")
                        .param("operation", operation))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));

        verify(calculadoraService).calculo(firstNumber, secondNumber, operation);
    }

    @Test
    public void calcula_withInvalidRequest_returns400BadRequest() throws Exception {
        BigDecimal firstNumber = BigDecimal.valueOf(5);
        BigDecimal secondNumber = BigDecimal.valueOf(0);
        String operation = "DIVIDIR";

        when(calculadoraService.calculo(firstNumber, secondNumber, operation))
                .thenThrow(new IllegalArgumentException("division by zero"));

        mockMvc.perform(get("/calcular")
                        .param("firstNumber", "5")
                        .param("secondNumber", "0")
                        .param("operation", "DIVIDIR"))
                .andExpect(status().isBadRequest());

        verify(calculadoraService).calculo(firstNumber, secondNumber, operation);
    }

}
