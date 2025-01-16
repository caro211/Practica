package Tasks.Pets;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CreatePets implements Task {


    public static Response response;
    private final String filePath;

    public CreatePets(String filePath) {
        this.filePath = filePath;
    }

    public static CreatePets withPayloadFrom(String filePath) {
        return Tasks.instrumented(CreatePets.class, filePath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        byte[] archivo = new byte[0];
        try {
            archivo = Files.readAllBytes(Paths.get("src/main/java/utils/Payloads/CreatePet.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Base.request = Base.request.body(archivo);
        response= Base.request
                .post("pet")
                .prettyPeek();
        actor.remember("response", response);



    }
}
