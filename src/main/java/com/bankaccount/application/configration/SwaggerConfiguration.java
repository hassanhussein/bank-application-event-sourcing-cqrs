package com.bankaccount.application.configration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors
            .basePackage("com.bankaccount.application"))
        .paths(regex("/rest/.*"))
        .build()
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {

    return new ApiInfo(
        "Bank Booking Application using ES and CQRS built by Spring Boot and Axon frameworks",
        "This is the problem statement trying to answer different transactions made on account using ES and CQRS techniques",
        "0.0.1-SNAPSHOT",
        "Terms of Service",
        new Contact("Hussein Hassan Matoto",
            "https://github.com/hassanhussein/",
            "hhassan.developer@gmail.com"),
        "",
        "",
        Collections.emptyList());
  }

}
