package com.challenge.stepdefinitions.definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import com.challenge.tasks.RegistroUsuario;

import com.challenge.config.ActorManager;

public class CrearUsuarioStepDefinitions {

    @When("^the user tries to create an user$")
    public void theUserTriesToRegisterAnUser() {
        ActorManager.theActor().attemptsTo(RegistroUsuario.withRandomData());
    }

    @Then("^the user response is (\\d+)$")
    public void theUserResponseIs(int expectedStatusCode) {
        ActorManager.theActor().should(
            seeThatResponse("Verify the response status code is " + expectedStatusCode,
                response -> response.statusCode(expectedStatusCode)
            )
        );
    }
}