package Tasks.ServicioIngresoValoracion;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaExitosaIngresoAlimentacion implements Task {

    private ValidatableResponse json;

    public static RespuestaExitosaIngresoAlimentacion valoracion() {


        return Tasks.instrumented(RespuestaExitosaIngresoAlimentacion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= IngresoValoracionAlimentacion.response.then().statusCode(HttpStatus.SC_CREATED).log().all();
    }
}
