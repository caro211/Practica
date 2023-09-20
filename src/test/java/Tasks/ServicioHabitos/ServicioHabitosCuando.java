package Tasks.ServicioHabitos;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import static io.restassured.RestAssured.given;

public class ServicioHabitosCuando implements Task {

    public static Response response;


    public static ServicioHabitosCuando ingreso() {

        return Tasks.instrumented(ServicioHabitosCuando.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       response= Base.request
                .when()
                .get("api/habits");
    }


}
