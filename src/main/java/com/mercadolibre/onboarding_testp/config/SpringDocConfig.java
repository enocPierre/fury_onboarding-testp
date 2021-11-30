package com.mercadolibre.onboarding_testp.config;

import static com.mercadolibre.onboarding_testp.util.ScopeUtils.SCOPE_VALUE;
import static com.mercadolibre.onboarding_testp.util.ScopeUtils.isLocalScope;
import static java.lang.String.format;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration class for documentation.
 */
@Configuration
public class SpringDocConfig {

  /**
   * @param appName Application name.
   * @param description Application description.
   * @param version Application version.
   * @return OpenAPI bean used to generate documentation.
   */
  @Bean
  public OpenAPI customOpenAPI(
      @Value("${app.title}") String appName,
      @Value("${app.description}") String description,
      @Value("${app.version}") String version) {
    OpenAPI api =
        new OpenAPI()
            .info(
                new Info()
                    .title(appName)
                    .version(version)
                    .description(description)
                    .contact(
                        new Contact()
                            .name("onboarding-testp")
                            .email("enoc.pierre@mercadolivre.com")));

    api.addServersItem(
        new Server()
            .url(
                isLocalScope()
                    ? "http://localhost:8080"
                    : format("https://%s_%s.furyapps.io", SCOPE_VALUE, appName))
            .description(format("Scope %s", SCOPE_VALUE)));
    return api;
  }
}
