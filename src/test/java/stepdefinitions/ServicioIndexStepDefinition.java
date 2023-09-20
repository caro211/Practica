package stepdefinitions;

import Tasks.ServicioIndice.IndiceCliente;
import Tasks.ServicioIndice.IndiceGeneral;
import Tasks.ServicioIndice.RespuestaExitosa;
import Tasks.ServicioIndice.RespuestaFallida;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ServicioIndexStepDefinition {


    @Cuando("el usuario envía una petición al servicio de index valoracion")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIndexValoracion(DataTable dataTable) {

        theActorInTheSpotlight().attemptsTo(IndiceGeneral.delUsuario(dataTable));

    }

    @Entonces("el usuario deberá ver respuesta exitosa del indice")
    public void elUsuarioDeberáVerRespuestaExitosaDelIndice() {
      theActorInTheSpotlight().attemptsTo(RespuestaExitosa.deIndice());

    }

    @Cuando("el usuario envía una petición con cliente que no existe al servicio indice valoracion")
    public void elUsuarioEnvíaUnaPeticiónConClienteQueNoExisteAlServicioIndiceValoracion(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(IndiceCliente.noExiste(dataTable));
    }


    @Entonces("el usuario deberá ver respuesta errada del indice")
    public void elUsuarioDeberáVerRespuestaErradaDelIndice() {
        theActorInTheSpotlight().attemptsTo(RespuestaFallida.deIndice());
    }
}
