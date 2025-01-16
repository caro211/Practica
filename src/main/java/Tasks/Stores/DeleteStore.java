package Tasks.Stores;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class DeleteStore implements Task {


    public static Response response;
    private DataTable dataTable;

    public DeleteStore (DataTable dataTable) {
        this.dataTable = dataTable;
    }
    public static DeleteStore valid(DataTable dataTable) {

        return Tasks.instrumented(DeleteStore.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String dniCliente = dataTable.cell(1, 0);
        String endpoint = String.format("store/order/%s", dniCliente);
        response = Base.request
                .when()
                .delete(endpoint)
                .prettyPeek();
        actor.remember("response", response);

    }
}
