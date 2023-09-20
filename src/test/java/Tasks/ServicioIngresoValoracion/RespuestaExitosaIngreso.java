package Tasks.ServicioIngresoValoracion;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.BasedeDatos.BaseDatosConexion.consultar;
import static utils.Queries.CONSULTAR_CLIENTE;
import static utils.Queries.CONSULTAR_VALORACION;

public class RespuestaExitosaIngreso implements Task {
    public static Response response;
    private ValidatableResponse json;

    private DataTable dataTable;

   public RespuestaExitosaIngreso(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static RespuestaExitosaIngreso valoracion(DataTable dataTable) {

        return Tasks.instrumented(RespuestaExitosaIngreso.class, dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        json= IngresoValoracion.response.then().statusCode(HttpStatus.SC_CREATED).log().all();
        try {
            String consulta1 = String.format(CONSULTAR_CLIENTE.getQuery(),dataTable.cell(0,1));
           var resultado =consultar("", consulta1);
          var consulta2=String.format(CONSULTAR_VALORACION.getQuery(),resultado.get(0));
         consultar("",consulta2);

        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage(), e);;
        }

    }
}
