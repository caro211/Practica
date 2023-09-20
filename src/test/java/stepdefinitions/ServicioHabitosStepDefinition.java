package stepdefinitions;

import Tasks.ServicioHabitos.ListarHabitosFallido;
import Tasks.ServicioHabitos.RespuestaFallidaHabitos;
import Tasks.ServicioHabitos.ServicioHabitosCuando;
import Tasks.ServicioHabitos.Serviciohabitosentonces;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constantes.BASE_SERVICIOS;


public class ServicioHabitosStepDefinition{

    @Cuando("el usuario envía una petición al servicio de habitos para listarlos")
    public void elUsuarioEnvíaUnaPeticiónAlServicioDeHabitosParaListarlos() {
        theActorInTheSpotlight().attemptsTo(ServicioHabitosCuando.ingreso());
    }

    @Entonces("el usuario deberá ver respuesta exitosa del registro")
    public void elUsuarioDeberáVerRespuestaExitosaDelRegistro() {
        theActorInTheSpotlight().attemptsTo(Serviciohabitosentonces.ingreso());
    }

    @Cuando("el usuario envía una petición equivocada al servicio de habitos para listarlos")
    public void elUsuarioEnvíaUnaPeticiónEquivocadaAlServicioDeHabitosParaListarlos() {
        theActorInTheSpotlight().attemptsTo(ListarHabitosFallido.cuandoIngreso());
    }


    @Entonces("el usuario deberá ver respuesta errada")
    public void elUsuarioDeberáVerRespuestaErrada() {
        theActorInTheSpotlight().attemptsTo(RespuestaFallidaHabitos.valoracion());

    }

}
