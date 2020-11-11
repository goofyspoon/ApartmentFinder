package myProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket myDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("myProject"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Apartment-Server")
                .description("Hi, welcome to the backend of the Coms309 Apartment app, here is the API document!")
                .termsOfServiceUrl("https://coms-309-cy-04.cs.iastate.edu:8080/terms")
                .contact(new Contact("Adrian Vanderveer","https://git.linux.iastate.edu/cs309/fall2020/cy_04","adrianv@iastate.edu"))
                .version("0.0.1")
                .build();
    }

}
