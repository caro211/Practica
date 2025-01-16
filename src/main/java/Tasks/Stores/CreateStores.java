package Tasks.Stores;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateStores implements Task {

    public static Response response;

    public static CreateStores valid() {

        return Tasks.instrumented(CreateStores.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        byte[] archivo = new byte[0];
        try {
            archivo = Files.readAllBytes(Paths.get("src/main/java/utils/Payloads/CreateStore.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Base.request = Base.request.body(archivo);
        response= Base.request
                .post("store/order")
                .prettyPeek();
        actor.remember("response", response);
    }
}
