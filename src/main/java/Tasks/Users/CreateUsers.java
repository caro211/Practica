package Tasks.Users;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class CreateUsers implements Task {


    public static Response response;

    public static CreateUsers valid() {

        return Tasks.instrumented(CreateUsers.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        response= Base.request
                .post("user")
                .prettyPeek();
        actor.remember("response", response);

    }
}
