package com.challenge.stepdefinitions.definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import com.challenge.tasks.VerifyUsers;
import io.cucumber.java.en.When;

public class VerifyUserStepDefinition {


    @When("^the (.*) tries to get the customer data with id (.*)$")
    public void userTriesToGetUserData(String actor, String id) {
        theActorInTheSpotlight().attemptsTo(VerifyUsers.verifyUserWithId(id));

        com.challenge.models.response.GenericUserResponse response = theActorInTheSpotlight().recall("verifyUserResponse");
        theActorInTheSpotlight().remember("id", id);
        theActorInTheSpotlight().remember("body", response.getBody());
        theActorInTheSpotlight().remember("userId", response.getUserId());
        theActorInTheSpotlight().remember("title", response.getTitle());
    }

}