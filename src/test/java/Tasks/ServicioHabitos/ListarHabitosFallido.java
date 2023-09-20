package Tasks.ServicioHabitos;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class ListarHabitosFallido implements Task {

    public static Response response;


    public static ListarHabitosFallido cuandoIngreso() {

        return Tasks.instrumented(ListarHabitosFallido.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response= Base.request
                .when()
                .get("api/habit");
    }
}
