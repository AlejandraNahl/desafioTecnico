package com.prueba.rest.config;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prueba.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
    
    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("http://localhost:8080/form")
                .version("1.0")
                .description("Aplicacion Web para registro de tareas")
                .license("Apache License Version 2.0")
                .build();

    }
}
