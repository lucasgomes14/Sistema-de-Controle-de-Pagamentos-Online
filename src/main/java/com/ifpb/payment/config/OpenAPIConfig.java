package com.ifpb.payment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API pagamento")
                        .version("1.0")
                        .description("API tem a responsabilidade de gerenciar pagamentos.\n\n" +
                                "Endpoints:\n" +
                                "- `pay`: faz pagamento a partir do valor, método, nome do cliente e email do cliente;\n" ));
    }
}