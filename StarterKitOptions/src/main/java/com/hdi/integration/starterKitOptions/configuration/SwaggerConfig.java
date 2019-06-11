package com.hdi.integration.starterKitOptions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()    
          .apis(RequestHandlerSelectors.basePackage("com.hdi.integration.starterKitOptions"))
          .paths(PathSelectors.any())                          
          .build().apiInfo(this.getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Insurance Policy Domain Services")
                .description("Insurance Policy Domain Services")
//                .version("1.0.0")
//                .license("")
//                .licenseUrl("http://unlicense.org")
//                .termsOfServiceUrl("")
//                .contact(new Contact("","", ""))
                .build();
    }

}
