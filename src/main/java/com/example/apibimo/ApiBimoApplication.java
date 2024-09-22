package com.example.apibimo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info = @Info(title = "API BiMO", version = "1.0", description = "Documentação da API BiMO"))
@SpringBootApplication
public class ApiBimoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBimoApplication.class, args);
    }

}
