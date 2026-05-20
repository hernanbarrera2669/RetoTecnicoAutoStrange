package com.challenge.stepdefinitions.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.challenge.tasks.AbrirNavegador;
import com.challenge.tasks.UpdateUser;

public class UpdateUserStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at("https://jsonplaceholder.typicode.com")));
    }

    @Given("^the (.*) accesses the application to update user data$")
    public void the_user_accesses_the_application_to_update_user_data(String actor) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        OnStage.theActorCalled(actor).attemptsTo(AbrirNavegador.en(url));
    }

    @When("^the user updates customer data with the following information: (.*), (.*), (.*) and (.*)$")
    public void the_user_updates_customer_data_with_the_following_information(String id, String userId, String title, String body) {
        String data = String.format("{\"id\": %s, \"userId\": %s, \"title\": \"%s\", \"body\": \"%s\"}", id, userId, title, body);
        theActorInTheSpotlight().attemptsTo(UpdateUser.withData(id, data));
    }
}
