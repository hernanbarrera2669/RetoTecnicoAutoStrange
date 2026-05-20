package com.challenge.stepdefinitions.definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.challenge.tasks.RegistroUsuario;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CrearUsuarioStepDefinitions {


    @When("^the user tries to create a user$")
    public void theUserTriesToRegisterAUser() {
        String data = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        theActorInTheSpotlight().attemptsTo(RegistroUsuario.withData(data));
    }

    @Then("^the user response is (\\d+)$")
    public void theUserResponseIs(int expectedStatusCode) {
        theActorInTheSpotlight().should(
            seeThatResponse("Verify the response status code is " + expectedStatusCode,
                response -> response.statusCode(expectedStatusCode)
            )
        );
    }
}