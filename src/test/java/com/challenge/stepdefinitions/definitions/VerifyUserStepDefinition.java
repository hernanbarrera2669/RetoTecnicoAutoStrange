package com.challenge.stepdefinitions.definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.challenge.tasks.VerifyUsers;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class VerifyUserStepDefinition {


    @When("^the (.*) tries to get the customer data with id (.*)$")
    public void userTriesToGetUserData(String actor, String id) {
         theActorInTheSpotlight().attemptsTo(VerifyUsers.verifyUserWithId(id));
    }

    @Then("la respuesta del usuario es (\\d+)$")
    public void userResponseIs(int expectedStatusCode) {
         theActorInTheSpotlight().should(
            seeThatResponse("Verify the response status code is " + expectedStatusCode,
                response -> response.statusCode(expectedStatusCode)
            )
        );
    }

}