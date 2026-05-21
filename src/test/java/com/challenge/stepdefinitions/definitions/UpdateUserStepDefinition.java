package com.challenge.stepdefinitions.definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import com.challenge.tasks.UpdateUser;
import io.cucumber.java.en.When;

public class UpdateUserStepDefinition {

    @When("the user updates customer data with the following id: (.*)$")
    public void the_user_updates_customer_data_with_the_following_id(String id) {
        theActorInTheSpotlight().attemptsTo(UpdateUser.withRandomData(id));
    }


}
