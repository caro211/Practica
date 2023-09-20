package Tasks.ServicioIngresoValoracion;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaExitosaValoracionInicial implements Task {

    private ValidatableResponse json;

    public static RespuestaExitosaValoracionInicial valoracion() {


        return Tasks.instrumented(RespuestaExitosaValoracionInicial.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= IngresoValoracionInicial.response.then().statusCode(HttpStatus.SC_CREATED).log().all();

    }
}
