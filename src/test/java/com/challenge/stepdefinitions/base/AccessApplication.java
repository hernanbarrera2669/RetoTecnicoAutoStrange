package com.challenge.stepdefinitions.base;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;

import org.junit.jupiter.api.BeforeEach;
import com.challenge.utils.config.EnvironmentConfig;

class AccessApplication {

    protected Actor tyber; 

    @BeforeEach
     void setUp() {
        tyber = Actor.named("Hernancho").whoCan(CallAnApi.at(EnvironmentConfig.getBaseUrl()));
    }

}
