package com.challenge.utils;

import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.thucydides.model.util.EnvironmentVariables;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EnvironmentConfig {

    private static final EnvironmentVariables variables =
            ConfiguredEnvironment.getEnvironmentVariables();


    public static String getBaseUrl() {
return variables.getProperty("base.url");
}
}