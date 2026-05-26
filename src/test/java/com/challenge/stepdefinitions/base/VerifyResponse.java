package com.challenge.stepdefinitions.base;

import com.challenge.config.ActorManager;
import com.challenge.models.response.GenericUserResponse;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;

import com.challenge.questions.GetUserResponse;

import io.cucumber.java.en.Then;

public class VerifyResponse {

    public static boolean verifyResponse(GenericUserResponse response) {
        return response.getId() != null &&
               response.getTitle() != null &&
               response.getBody() != null &&
               response.getUserId() != null;
    }

    @Then("^the user response is (\\d+)$")
    public void theUserResponseIs(int expectedStatusCode) {
        ActorManager.theActor().should(
            seeThatResponse("Verify the response status code is " + expectedStatusCode,
                response -> response.statusCode(expectedStatusCode)
            )
        );
    }

    @Then("^the user data is correct$")
    public void theUserDataIsCorrect() {
        GenericUserResponse response = GetUserResponse.es().answeredBy(ActorManager.theActor());
        String expectedId = ActorManager.theActor().recall("id");
        String expectedTitle = ActorManager.theActor().recall("title");
        String expectedBody = ActorManager.theActor().recall("body");
        String expectedUserId = ActorManager.theActor().recall("userId").toString();
        
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(expectedId);
        assertThat(response.getTitle()).isEqualTo(expectedTitle);
        assertThat(response.getBody()).isEqualTo(expectedBody);
        assertThat(response.getUserId().toString()).isEqualTo(expectedUserId);
    }
}
