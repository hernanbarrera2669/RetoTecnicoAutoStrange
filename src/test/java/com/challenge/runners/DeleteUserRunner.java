package com.challenge.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

    glue = { "com.challenge.stepdefinitions", "com.challenge.hooks" },
    features = { "src/test/resources/features" },
    tags = "@DeleteDataUserSuccessfully",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class DeleteUserRunner {

}
