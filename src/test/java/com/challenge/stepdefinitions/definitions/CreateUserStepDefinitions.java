package com.challenge.stepdefinitions.definitions;
import io.cucumber.java.en.When;


import com.challenge.tasks.CreateUser;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.challenge.config.ActorManager;

public class CreateUserStepDefinitions {

    @When("^the user tries to create an user$")
    public void theUserTriesToRegisterAnUser() {
        ActorManager.theActor().attemptsTo(CreateUser.withRandomData());
        com.challenge.models.response.GenericUserResponse response = theActorInTheSpotlight().recall("verifyUserResponse");
        theActorInTheSpotlight().remember("id", response.getId());
    }
}