package br.com.forum.infrastructure.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun forumOpenApiConfig(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                    .title("Forum API")
                    .version("v0.0.1")
            )

}