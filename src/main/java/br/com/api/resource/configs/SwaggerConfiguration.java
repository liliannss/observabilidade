package br.com.api.resource.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.webmvc.ui.SwaggerConfig;

@OpenAPIDefinition(
        info = @Info(
                title = "Observabilidade",
                description = "POC com ferramentas de Observabilidade",
                contact = @Contact(url = "https://github.com/liliannss", name = "Lilian Sousa")))
public class SwaggerConfiguration extends SwaggerConfig {

}