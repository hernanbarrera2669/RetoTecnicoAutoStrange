package com.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/ActualizarUsuario.feature",
    glue = "com.challenge.stepdefinitions.definitions",
    tags = "@UpdateUserSuccessfully",
    plugin = {"pretty"}
)
public class UpdateUserRunner {

}
