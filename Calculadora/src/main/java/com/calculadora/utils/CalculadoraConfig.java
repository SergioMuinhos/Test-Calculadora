package com.calculadora.utils;

import com.calculadora.services.CalculadoraService;
import com.calculadora.services.impl.CalculadoraServiceImpl;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculadoraConfig {
    @Bean
    public TracerImpl tracer() {
        return new TracerImpl();
    }


}
