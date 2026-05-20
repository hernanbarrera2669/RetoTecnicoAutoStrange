package com.challenge.stepdefinitions.base;

import com.challenge.config.ActorManager;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.steps.ScenarioSteps;


public abstract class BaseSteps extends ScenarioSteps {


private Actor actor;

protected Actor theActor() {
        if (actor == null) {
            actor = ActorManager.theActor();
        }
        return actor;
    }

}
