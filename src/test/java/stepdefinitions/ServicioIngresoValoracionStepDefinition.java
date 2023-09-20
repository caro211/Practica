package stepdefinitions;

import Tasks.ServicioIngresoValoracion.FallidoEstadoValoracion;
import Tasks.ServicioIngresoValoracion.IngresoValoracion;
import Tasks.ServicioIngresoValoracion.IngresoValoracionAlimentacion;
import Tasks.ServicioIngresoValoracion.IngresoValoracionInicial;
import Tasks.ServicioIngresoValoracion.IngresoValoracionSMental;
import Tasks.ServicioIngresoValoracion.RespuesaFallidaEstadoValoracion;
import Tasks.ServicioIngresoValoracion.RespuestaExitosaIngreso;
import Tasks.ServicioIngresoValoracion.RespuestaExitosaIngresoAlimentacion;
import Tasks.ServicioIngresoValoracion.RespuestaExitosaIngresoSaludMental;
import Tasks.ServicioIngresoValoracion.RespuestaExitosaValoracionInicial;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ServicioIngresoValoracionStepDefinition {




    @Cuando("el usuario envía una petición al servicio de ingreso valoracion con actividad fisica")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIngresoValoracionConActividadFisica() {
        theActorInTheSpotlight().attemptsTo(IngresoValoracion.actividadFisica());

    }
    @Entonces("el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion")
    public void elUsuarioDeberáVerRespuestaExitosaDelRegistroAlIngresarLaValoracion(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(RespuestaExitosaIngreso.valoracion(dataTable));

    }

    @Cuando("el usuario envía una petición al servicio de ingreso valoracion con alimentacion")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIngresoValoracionConAlimentacion() {
        theActorCalled("carolina").attemptsTo(IngresoValoracionAlimentacion.deUsuario());
    }

    @Entonces("el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion alimentacion")
    public void elUsuarioDeberáVerRespuestaExitosaDelRegistroAlIngresarLaValoracionAlimentacion() {
        theActorInTheSpotlight().attemptsTo(RespuestaExitosaIngresoAlimentacion.valoracion());

    }

    @Cuando("el usuario envía una petición al servicio de ingreso valoracion salud mental")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIngresoValoracionSaludMental() {
        theActorInTheSpotlight().attemptsTo(IngresoValoracionSMental.deUsuario());
    }

    @Entonces("el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion salud mental")
    public void elUsuarioDeberáVerRespuestaExitosaDelRegistroAlIngresarLaValoracionSaludMental() {
        theActorInTheSpotlight().attemptsTo(RespuestaExitosaIngresoSaludMental.valoracion());

    }


    @Cuando("el usuario envía una petición al servicio de ingreso valoracion inicial")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIngresoValoracionInicial() {
        theActorInTheSpotlight().attemptsTo(IngresoValoracionInicial.deUsuario());
    }


    @Entonces("el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion inicial")
    public void elUsuarioDeberáVerRespuestaExitosaDelRegistroAlIngresarLaValoracionInicial() {
        theActorInTheSpotlight().attemptsTo(RespuestaExitosaValoracionInicial.valoracion());
    }


    @Cuando("el usuario envía una petición al servicio de ingreso valoracion con estado errado")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeIngresoValoracionConEstadoErrado() {
        theActorInTheSpotlight().attemptsTo(FallidoEstadoValoracion.cuandoIngreso());
    }




    @Entonces("el usuario deberá ver respuesta errada del registro")
    public void elUsuarioDeberáVerRespuestaErradaDelRegistro() {
        theActorInTheSpotlight().attemptsTo(RespuesaFallidaEstadoValoracion.valoracion());
    }
}
