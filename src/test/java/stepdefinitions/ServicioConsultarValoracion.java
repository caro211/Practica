package stepdefinitions;

import Tasks.ServicioConsultarValoracion.ConsultaValoracionAlimentacion;
import Tasks.ServicioConsultarValoracion.ConsultaValoracionFallida;
import Tasks.ServicioConsultarValoracion.ConsultaValoracionSaludMental;
import Tasks.ServicioConsultarValoracion.RespuestFallidaConsultaValoracion;
import Tasks.ServicioConsultarValoracion.RespuestaExitosaConsultaValoracion;
import Tasks.ServicioConsultarValoracion.ValidarConsultaValoracion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ServicioConsultarValoracion {

    @Cuando("el usuario envía una petición al servicio de consulta valoracion")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeConsultaValoracion(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(ValidarConsultaValoracion.deUsuario(dataTable));

    }

    @Cuando("el usuario envía una petición al servicio de consulta valoracion Alimentacion")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeConsultaValoracionAlimentacion(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(ConsultaValoracionAlimentacion.deUsuario(dataTable));
    }

    @Cuando("el usuario envía una petición al servicio de consulta valoracion Salud mental")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeConsultaValoracionSaludMental(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(ConsultaValoracionSaludMental.deUsuario(dataTable));
    }

    @Entonces("el usuario deberá ver respuesta exitosa de consulta valoracion")
    public void elUsuarioDeberáVerRespuestaExitosaDeConsultaValoracion() {
      theActorInTheSpotlight().attemptsTo(RespuestaExitosaConsultaValoracion.deUsuario());

    }

    @Cuando("el usuario envía una petición fallida al servicio de consulta valoracion")
    public void elUsuarioEnvíaUnaPeticiónFallidaAlServicioDeConsultaValoracion(DataTable dataTable) {
       theActorInTheSpotlight().attemptsTo(ConsultaValoracionFallida.deUsuario(dataTable));
    }


    @Entonces("el usuario deberá ver respuesta fallida de consulta valoracion")
    public void elUsuarioDeberáVerRespuestaFallidaDeConsultaValoracion() {
        theActorInTheSpotlight().attemptsTo(RespuestFallidaConsultaValoracion.deUsuario());
    }
}
