package Tasks.ServicioIngresoValoracion;

import Tasks.ServicioHabitos.ListarHabitosFallido;
import Tasks.ServicioHabitos.RespuestaFallidaHabitos;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuesaFallidaEstadoValoracion implements Task {


    private ValidatableResponse json;

    public static RespuesaFallidaEstadoValoracion valoracion() {


        return Tasks.instrumented(RespuesaFallidaEstadoValoracion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= FallidoEstadoValoracion.response.then().statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
    }
}
