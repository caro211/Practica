package Tasks.ServicioConsultarValoracion;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class ConsultaValoracionFallida implements Task {

    public static Response response;
    private DataTable dataTable;

    public ConsultaValoracionFallida(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static ConsultaValoracionFallida deUsuario(DataTable dataTable) {

        return Tasks.instrumented(ConsultaValoracionFallida.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response= Base.request.header("x-dni-cliente",dataTable.cell(0,1))
                .when()
                .param("codigoValoracion",dataTable.cell(1,1))
                .get("api/assessment");
    }
}
