package com.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    glue = { "com.challenge.stepdefinitions", "com.challenge.hooks" },
    features = { "src/test/resources/features" },
    tags = "@VerifyDataUser",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VerifyUserRunnner {

}
