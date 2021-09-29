package com.hoangbuix.bicycle.config;

import org.springframework.beans.factory.annotation.Value;
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
public class Swagger2Config {
    private static final String AUTH_END_POINT = "/oauth/token";
    @Value("${swagger.host.url}")
    private String hostUrl;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(hostUrl)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hoangbuix.bicycle.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
//                .securityContexts(Collections.singletonList(securityContext()))
//                .securitySchemes(Collections.singletonList(securityScheme()));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("Spring Boot REST API for Shopping Service")
                .contact(new Contact("Bui Hoang", "", "buihoang9b8@gmail.com"))
                .version("1.0.0")
                .build();
    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(
//                        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
//                .forPaths(PathSelectors.regex("/api/v1/.*"))
//                .build();
//    }
//
//
//    private SecurityScheme securityScheme() {
//        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_END_POINT);
//        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
//                .grantTypes(Arrays.asList(grantType))
//                .scopes(Arrays.asList(scopes()))
//                .build();
//
//        return oauth;
//    }
//
//    private AuthorizationScope[] scopes() {
//        AuthorizationScope[] scopes = {
//                new AuthorizationScope("read", "for read operations")
//        };
//        return scopes;
//    }

}
