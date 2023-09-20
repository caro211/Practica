package Tasks.ServicioConsultarValoracion;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;


public class RespuestaExitosaConsultaValoracion implements Task {

    private ValidatableResponse json;

    public static RespuestaExitosaConsultaValoracion deUsuario() {


        return Tasks.instrumented(RespuestaExitosaConsultaValoracion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= ValidarConsultaValoracion.response.then().statusCode(HttpStatus.SC_OK).log().all();

    }
}
