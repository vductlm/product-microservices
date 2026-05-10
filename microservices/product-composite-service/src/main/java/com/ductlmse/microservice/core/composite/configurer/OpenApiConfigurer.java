package com.ductlmse.microservice.core.composite.configurer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfigurer {

    @Value("${api.common.version}")
    String apiVersion;

    @Value("${api.common.title}")
    String apiTitle;

    @Value("${api.common.description}")
    String apiDescription;

    @Value("${api.common.termsOfService}")
    String apiTermsOfService;

    @Value("${api.common.license}")
    String apiLicense;

    @Value("${api.common.licenseUrl}")
    String apiLicenseUrl;

    @Value("${api.common.externalDocDesc}")
    String apiExternalDocDesc;

    @Value("${api.common.externalDocUrl}")
    String apiExternalDocUrl;

    @Value("${api.common.contact.name}")
    String apiContactName;

    @Value("${api.common.contact.url}")
    String apiContactUrl;

    @Value("${api.common.contact.email}")
    String apiContactEmail;


    @Bean
    public OpenAPI getOpenApiConfigurer() {
        return new OpenAPI()
                .info(new Info().title(this.apiTitle)
                        .description(this.apiDescription)
                        .version(this.apiVersion)
                        .contact(new Contact()
                                .name(this.apiContactName)
                                .url(this.apiContactUrl)
                                .email(this.apiContactEmail))
                        .termsOfService(this.apiTermsOfService)
                        .license(new License()
                                .name(this.apiLicense)
                                .url(this.apiLicenseUrl)))
                .externalDocs(new ExternalDocumentation()
                        .description(this.apiExternalDocDesc)
                        .url(this.apiExternalDocUrl));
    }

}
