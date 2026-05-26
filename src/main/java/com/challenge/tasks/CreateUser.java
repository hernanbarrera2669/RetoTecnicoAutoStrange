package com.challenge.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.challenge.interactions.api.Post;
import com.challenge.models.request.GenericUserRequest;
import com.challenge.utils.constants.Resources;
import com.challenge.utils.data.CreateRandomData;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class CreateUser implements Task {

    private Object data;

    public CreateUser(Object data) {
        this.data = data;
    }

    public static Performable withData(Object data) {
        return instrumented(CreateUser.class, data);
    }

    public static Performable withRandomData() {
        String title = CreateRandomData.generateName();
        String body = CreateRandomData.generateSentence();
        int userId = CreateRandomData.generateNumber(1, 5);
        theActorInTheSpotlight().remember("title",title);
        theActorInTheSpotlight().remember("body",body);
        theActorInTheSpotlight().remember("userId",userId);

        GenericUserRequest userRequest = GenericUserRequest.builder()
                .title(title)
                .body(body)
                .userId(userId)
                .build();
        return CreateUser.withData(userRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(Resources.CREATE_USER.getValue()).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)
        .body(this.data)));

        com.challenge.models.response.GenericUserResponse response = net.serenitybdd.rest.SerenityRest.lastResponse().as(com.challenge.models.response.GenericUserResponse.class);
        actor.remember("verifyUserResponse", response);

    }
}