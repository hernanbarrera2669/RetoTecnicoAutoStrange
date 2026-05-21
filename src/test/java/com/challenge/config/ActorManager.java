package com.challenge.config;

import com.challenge.utils.config.EnvironmentConfig;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ActorManager {

    private static Actor actor;

    public static void initialize() {
        net.serenitybdd.screenplay.actors.OnStage.setTheStage(new net.serenitybdd.screenplay.actors.OnlineCast());
        actor = net.serenitybdd.screenplay.actors.OnStage.theActorCalled("Hernancho").whoCan(CallAnApi.at(EnvironmentConfig.getBaseUrl()));
    }

    public static Actor getActor() {
        return actor;
    }

    public static void tearDown() {
        actor = null;
    }

   public static Actor theActor() {
        if (actor == null) {
            throw new IllegalStateException(
                    "The actor has not been initialized. Verify that the Hook runs before the scenario.");
        }
        return actor;
   }
}
