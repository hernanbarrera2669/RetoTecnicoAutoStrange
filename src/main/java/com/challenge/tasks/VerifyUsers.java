package com.challenge.tasks;

import com.challenge.interactions.api.Get;
import com.challenge.utils.constants.Resources;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;



public class VerifyUsers implements Task {

    private String id;

    public VerifyUsers(String id) {
        this.id = id;
    }

    public static Performable verifyUserWithId(String id) {
        return instrumented(VerifyUsers.class, id);
    }

     public static Performable verifyAllUsers() {
        return instrumented(VerifyUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.to(Resources.PERFORM_ACTION_USER.getValue().replace("{id}", this.id)).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType("application/json")));

        com.challenge.models.response.GenericUserResponse response = net.serenitybdd.rest.SerenityRest.lastResponse().as(com.challenge.models.response.GenericUserResponse.class);
        actor.remember("verifyUserResponse", response);
    }

}
