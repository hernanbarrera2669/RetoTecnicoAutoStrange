package com.challenge.utils.config;

import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EnvironmentConfig {

    private static final EnvironmentVariables variables =
        ConfiguredEnvironment.getEnvironmentVariables();


    public static String getBaseUrl() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("base.url");
}
}