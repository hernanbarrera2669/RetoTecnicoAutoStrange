
package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.challenge.interactions.api.Put;

import io.restassured.http.ContentType;

public class UpdateUser implements Task {

    private final String id;
    private final String data;


    public UpdateUser(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public static Performable withData(String id, String data) {
        return instrumented(UpdateUser.class, id, data);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/posts/" + this.id).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)
        .body(this.data)));

    }


}
