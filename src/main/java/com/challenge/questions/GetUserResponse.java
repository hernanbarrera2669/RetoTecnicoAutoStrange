package com.challenge.questions;

import com.challenge.models.response.GenericUserResponse;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUserResponse implements Question<GenericUserResponse> {

    public static Question<GenericUserResponse> es() {
        return new GetUserResponse();
    }

    @Override
    public GenericUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(GenericUserResponse.class);
    }
}
