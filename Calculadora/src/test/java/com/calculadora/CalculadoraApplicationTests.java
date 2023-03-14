package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.services.CalculadoraService;
import com.calculadora.utils.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigDecimal;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest

public class CalculadoraApplicationTests {


    @Autowired
    CalculadoraController calculadoraController;

  /*  @Test
    public void contextLoads() {
        Assertions.assertThat(calculadoraController).isNot(null);
    }*/


}
