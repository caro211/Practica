package Tasks.ServicioConsultarValoracion;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestFallidaConsultaValoracion implements Task {

    private ValidatableResponse json;

    public static RespuestFallidaConsultaValoracion deUsuario() {
        return Tasks.instrumented(RespuestFallidaConsultaValoracion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        json= ConsultaValoracionFallida.response.then().statusCode(HttpStatus.SC_NOT_FOUND).log().all();
    }
}
