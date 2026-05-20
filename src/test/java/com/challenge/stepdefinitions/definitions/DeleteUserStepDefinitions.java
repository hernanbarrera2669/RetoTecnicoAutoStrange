package com.challenge.stepdefinitions.definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import io.cucumber.java.en.When;
import com.challenge.tasks.DeleteUser;

public class DeleteUserStepDefinitions {




    @When("^the user deletes customer data with the following id: (.*)$")
    public void the_user_deletes_customer_data_with_the_following_information(String id) {
        theActorInTheSpotlight().attemptsTo(DeleteUser.withId(id));
    }


}
