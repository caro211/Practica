package stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static utils.Constantes.BASE_SERVICIOS;

public class Base {

    public  static RequestSpecification request;

   @Before
    public void seCreaElRequestDeLaPeticionDelServicio() {
        request=given()
                .baseUri("https://corebienestar.labsura.com/")
                .contentType(ContentType.JSON)
                .auth()
                .preemptive()
                .basic(System.getenv("Username"),System.getenv("Password"))
                .log()
                .all();

    }



    @Before
    public void sePreparaElActor(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("carolina").whoCan(CallAnApi.at(BASE_SERVICIOS));

    }


}
