package Tasks.ServicioHabitos;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class Serviciohabitosentonces implements Task {

    public  static ValidatableResponse json;

    public static Serviciohabitosentonces ingreso() {
        return Tasks.instrumented(Serviciohabitosentonces.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        json= ServicioHabitosCuando.response.then().statusCode(HttpStatus.SC_OK).log().all();
    }
}
