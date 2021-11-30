package com.mercadolibre.onboarding_testp;

import com.mercadolibre.onboarding_testp.config.SpringConfig;
import com.mercadolibre.onboarding_testp.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/** 
 * Main class for the App.
 */
@SpringBootApplication
public class Application {

  /** 
   * @param args command line arguments for the application.
   */
  public static void main(String[] args) {
    ScopeUtils.calculateScopeSuffix();
    new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true).run(args);
  }
}
