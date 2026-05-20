package com.challenge.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/EliminarUsuario.feature", 
    glue = "com.challenge.stepdefinitions", 
    tags = "@DeleteDataUserSuccessfully",
    plugin = { "pretty"}
)
public class DeleteUserRunner {

}
