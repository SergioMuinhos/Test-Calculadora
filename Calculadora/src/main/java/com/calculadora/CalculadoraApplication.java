package com.calculadora;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Calculadora API", version = "1.0", description = "Calculadora Information"))
public class CalculadoraApplication {


	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApplication.class, args);
	}

}
