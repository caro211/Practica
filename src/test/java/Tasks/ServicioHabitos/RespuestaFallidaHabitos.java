package Tasks.ServicioHabitos;

import Tasks.ServicioIngresoValoracion.IngresoValoracionAlimentacion;
import Tasks.ServicioIngresoValoracion.RespuestaExitosaIngresoSaludMental;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaFallidaHabitos implements Task {

    private ValidatableResponse json;

    public static RespuestaFallidaHabitos valoracion() {


        return Tasks.instrumented(RespuestaFallidaHabitos.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= ListarHabitosFallido.response.then().statusCode(HttpStatus.SC_NOT_FOUND).log().all();
    }
}
