package Tasks.ServicioIndice;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class IndiceGeneral implements Task {

    public static Response response;
    private DataTable dataTable;

    public IndiceGeneral(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static IndiceGeneral delUsuario(DataTable dataTable) {

        return Tasks.instrumented(IndiceGeneral.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response=Base.request.header("x-dni-cliente",dataTable.cell(0,1))
                .when()
                .get("api/generalindex");
    }
}
