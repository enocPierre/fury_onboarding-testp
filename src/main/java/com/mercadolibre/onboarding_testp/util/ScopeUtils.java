package com.mercadolibre.onboarding_testp.util;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for scope information.
 */
public interface ScopeUtils {
  String SCOPE_SUFFIX = "SCOPE_SUFFIX";
  String SCOPE = "SCOPE";
  String SCOPE_SUFFIX_LOCAL = "local";
  String SCOPE_VALUE = System.getenv(SCOPE);

  /**
   * Sets SCOPE_SUFFIX env variable.
   */
  static void calculateScopeSuffix() {
    String suffix =
        Optional.ofNullable(SCOPE_VALUE)
            .filter(StringUtils::isNoneBlank)
            .map(
                scope -> {
                  String[] tokens = scope.split("-");
                  return tokens[tokens.length - 1];
                })
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "[Assertion Fail] SCOPE must be set to startup the application."));
    System.setProperty(SCOPE_SUFFIX, suffix);
  }

  /** 
   * @return true if SCOPE is local, false otherwise.
   */
  static boolean isLocalScope() {
    return SCOPE_SUFFIX_LOCAL.equals(SCOPE_VALUE);
  }
}
