package com.example.apidemo.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {

   @Bean
    public OpenAPI customOpenAPI() {
       Info information = new Info()
               .title("Employee Management System API")
               .version("1.0")
               .description("This API exposes endpoints to manage employees.");
       return new OpenAPI().info(information);
   }
}

