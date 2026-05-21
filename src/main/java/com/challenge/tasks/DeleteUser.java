package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.challenge.utils.constants.Resources;

import io.restassured.http.ContentType;

public class DeleteUser implements Task {

    private final String id;


    public DeleteUser(String id) {
        this.id = id;
    }

    public static Performable withId(String id) {
        return instrumented(DeleteUser.class, id);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(Resources.PERFORM_ACTION_USER.getValue().replace("{id}", this.id)).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)));
    }
}
