package com.challenge.tasks;

import com.challenge.interactions.api.Get;

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
        actor.attemptsTo(Get.to("/posts/" + this.id).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType("application/json")));
    }

}
