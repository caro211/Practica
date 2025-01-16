package Tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrepareUserCreation implements Task {

    public static PrepareUserCreation request() {

        return Tasks.instrumented(PrepareUserCreation.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        byte[] archivo = new byte[0];
        try {
            archivo = Files.readAllBytes(Paths.get("src/main/java/utils/Payloads/CreateUser.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = new String(archivo);
        Base.request = Base.request.body(body);

    }
}
