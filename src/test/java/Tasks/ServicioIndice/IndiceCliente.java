package Tasks.ServicioIndice;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class IndiceCliente implements Task {


    public static Response response;
    private DataTable dataTable;

    public IndiceCliente(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static IndiceCliente noExiste(DataTable dataTable) {

        return Tasks.instrumented(IndiceCliente.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response= Base.request.header("x-dni-cliente",dataTable.cell(0,1))
                .when()
                .get("api/generalindex");
    }
}
