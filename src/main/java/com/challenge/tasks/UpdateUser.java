
package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.challenge.interactions.api.Put;
import com.challenge.models.request.GenericUserRequest;
import com.challenge.utils.constants.Resources;
import com.challenge.utils.data.CreateRandomData;

import io.restassured.http.ContentType;

public class UpdateUser implements Task {

    private final String id;
    private final Object data;


    public UpdateUser(String id, Object data) {
        this.id = id;
        this.data = data;
    }

    public static Performable withData(String id, Object data) {
        return instrumented(UpdateUser.class, id, data);
    }

    public static Performable withRandomData(String id) {
        String title = CreateRandomData.generateName();
        String body = CreateRandomData.generateSentence();
        int userId = CreateRandomData.generateNumber(1, 5);
        GenericUserRequest userRequest = GenericUserRequest.builder()
                .title(title)
                .body(body)
                .userId(userId)
                .build();
        return UpdateUser.withData(id, userRequest);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(Resources.PERFORM_ACTION_USER.getValue().replace("{id}", this.id)).with(requestSpecification -> requestSpecification
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)
        .body(this.data)));

    }


}
