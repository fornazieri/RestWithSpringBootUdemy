package br.com.vitorfornazieri.restwithspringbootudemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration //para que o component scan entenda que esta á uma classe de configuração e ele inicie ela quando iniciar o spring boot
@EnableSwagger2 //para habilitar o swagger
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.vitorfornazieri.restwithspringbootudemy"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("RESTful API With Spring Boot Udemy",
                "Some description about my API",
                "v1",
                "Terms of Service Url",
                new Contact("Vitor Fornazieri Rodrigues", "www.vitorfornazieri.dev.br", "viitor.f@hotmail.com"),
                "License of API",
                "License of URL",
                Collections.emptyList());
    }

}
