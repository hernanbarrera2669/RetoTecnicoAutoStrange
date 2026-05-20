package com.challenge.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.challenge.interactions.api.Post;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class RegistroUsuario implements Task {

    private String data;

    public RegistroUsuario(String data) {
        this.data = data;
    }

    public static Performable withData(String data) {
        return instrumented(RegistroUsuario.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/posts").with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)
        .body(this.data)));

    }
}