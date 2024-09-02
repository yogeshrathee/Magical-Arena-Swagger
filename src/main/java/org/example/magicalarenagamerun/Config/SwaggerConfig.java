package org.example.magicalarenagamerun.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Magical-Arena Game")
                        .version("v0")
                        .description("Developed by \"Yogesh\". <a href=\"https://yogeshrathee.github.io/combined-portflio/\" target=\"_blank\">\uD83C\uDF1F✨ Let's connect! \uD83E\uDD1D✨\uD83D\uDCEC</a>"));
    }
}