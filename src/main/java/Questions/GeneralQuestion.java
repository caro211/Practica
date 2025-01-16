package Questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GeneralQuestion implements Question<Boolean> {

    private int expectedStatusCode;

    public GeneralQuestion(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public static GeneralQuestion is(int expectedStatusCode) {
        return new GeneralQuestion(expectedStatusCode);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = (Response) actor.recall("response");
        response.then().statusCode(expectedStatusCode).log().all();
        return true;
    }
}
