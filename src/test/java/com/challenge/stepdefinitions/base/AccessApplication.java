package com.challenge.stepdefinitions.base;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import com.challenge.utils.WebSiteTest;

public class AccessApplication {

     @Before
     public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        String urlBase = WebSiteTest.URL_DATA_TEST.getUrl();
        theActorCalled("Hernancho");
        theActorInTheSpotlight().whoCan(CallAnApi.at(urlBase));

     }
   


}
