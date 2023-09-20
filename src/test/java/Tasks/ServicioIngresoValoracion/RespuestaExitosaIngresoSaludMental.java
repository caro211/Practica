package Tasks.ServicioIngresoValoracion;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaExitosaIngresoSaludMental implements Task {
    private ValidatableResponse json;

    public static RespuestaExitosaIngresoSaludMental valoracion() {


        return Tasks.instrumented(RespuestaExitosaIngresoSaludMental.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= IngresoValoracionSMental.response.then().statusCode(HttpStatus.SC_CREATED).log().all();
    }
}
