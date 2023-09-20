package Tasks.ServicioIngresoValoracion;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IngresoValoracion implements Task {

    public static Response response;

    public static IngresoValoracion actividadFisica() {

        return Tasks.instrumented(IngresoValoracion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        byte[] archivo= new byte[0];
        try {
            archivo = Files.readAllBytes(Paths.get("src/test/java/utils/Payloads/ActividadFisica.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body= new String(archivo);
        response= Base.request
                .when()
                .body(body)
                .post("api/assessment")
                .prettyPeek();
    }
}
