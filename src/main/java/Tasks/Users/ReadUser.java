package Tasks.Users;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class ReadUser implements Task {

    public static Response response;
    private DataTable dataTable;

    public ReadUser (DataTable dataTable) {
        this.dataTable = dataTable;
    }
    public static ReadUser valid(DataTable dataTable) {

        return Tasks.instrumented(ReadUser.class,dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String dniCliente = dataTable.cell(1, 0);
        String endpoint = String.format("user/%s", dniCliente);
        response = Base.request
                .when()
                .get(endpoint)
                .prettyPeek();
        actor.remember("response", response);
    }
}
