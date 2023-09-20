package Tasks.ServicioIndice;

import Tasks.ServicioIngresoValoracion.FallidoEstadoValoracion;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaExitosa implements Task {

    private ValidatableResponse json;

    public static RespuestaExitosa deIndice() {


        return Tasks.instrumented(RespuestaExitosa.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= IndiceGeneral.response.then().statusCode(HttpStatus.SC_OK).log().all();
    }
}
