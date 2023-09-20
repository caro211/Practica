package Tasks.ServicioIndice;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

public class RespuestaFallida implements Task {

    private ValidatableResponse json;

    public static RespuestaFallida deIndice() {


        return Tasks.instrumented(RespuestaFallida.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= IndiceCliente.response.then().statusCode(HttpStatus.SC_NOT_FOUND).log().all();
    }
}
