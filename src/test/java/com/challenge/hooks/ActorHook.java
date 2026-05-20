package com.challenge.hooks;

import com.challenge.config.ActorManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ActorHook {
      @Before(order = 0)
    public void setUpActor() {
        ActorManager.initialize();
    }
    @After(order = 0)
    public void cleanUpActor() {
        ActorManager.tearDown();

}
}
