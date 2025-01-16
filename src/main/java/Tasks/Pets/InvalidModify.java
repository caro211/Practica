package Tasks.Pets;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InvalidModify implements Task {

    public static Response response;

    public static InvalidModify user() {

        return Tasks.instrumented(InvalidModify.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        byte[] archivo = new byte[0];
        try {
            archivo = Files.readAllBytes(Paths.get("src/main/java/utils/Payloads/InvalidModifyPet.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = new String(archivo);
        Base.request = Base.request.body(body);
        response= Base.request
                .put("pet")
                .prettyPeek();
        actor.remember("response", response);
    }
}
