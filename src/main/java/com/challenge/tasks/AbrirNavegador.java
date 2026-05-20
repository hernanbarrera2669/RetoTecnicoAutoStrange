package com.challenge.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AbrirNavegador implements Task {

    private final String url;

    public AbrirNavegador(String url) {
        this.url = url;
    }

    public static AbrirNavegador en(String url2) {
        return new AbrirNavegador(url2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo();
    }
}
