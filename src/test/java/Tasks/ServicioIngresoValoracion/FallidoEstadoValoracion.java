package Tasks.ServicioIngresoValoracion;

import Tasks.ServicioHabitos.ListarHabitosFallido;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

public class FallidoEstadoValoracion implements Task {

    public static Response response;


    public static FallidoEstadoValoracion cuandoIngreso() {

        return Tasks.instrumented(FallidoEstadoValoracion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response= Base.request.when()
                .body("{\n" +
                        "\"codigoHabito\": \"\",\n" +
                        "\"codigoValoracion\": \"VAL-INICIAL\",\n" +
                        "\"fechaRegistro\": \"2023-08-12T10:15:30\",\n" +
                        "\"estado\": \"ESTADOREG_F\",\n" +
                        "\"cliente\": {\n" +
                        "\"dniCliente\": \"T1038790\",\n" +
                        "\"primerNombre\": \"Pedro\",\n" +
                        "\"segundoNombre\": \"Leon\",\n" +
                        "\"primerApellido\": \"Jaramillo\",\n" +
                        "\"segundoApellido\": \"Pineda\",\n" +
                        "\"fechaNacimiento\": \"1988-08-11T22:22:17\",\n" +
                        "\"genero\": \"M\",\n" +
                        "\"email\": \"PRUEBA@GMAIL.COM\",\n" +
                        "\"telefonoFijo\": \"\",\n" +
                        "\"telefonoMovil\": \"3132967070\"\n" +
                        "},\n" +
                        "\"valoracion\": [\n" +
                        "{\n" +
                        "\"codigoPregunta\": \"PRG_INI_TALLA\",\n" +
                        "\"formatoRespuesta\": \"FRMTOR_CNUM\",\n" +
                        "\"valorRespuesta\": 174,\n" +
                        "\"valorRespuestaExtra\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"codigoPregunta\": \"PRG_INI_PESO\",\n" +
                        "\"formatoRespuesta\": \"FRMTOR_CNUM\",\n" +
                        "\"valorRespuesta\": 86,\n" +
                        "\"valorRespuestaExtra\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"codigoPregunta\": \"PRG_INI_ENFERMEDAD\",\n" +
                        "\"formatoRespuesta\": \"FRMTOR_CSELM\",\n" +
                        "\"valorRespuesta\": \"RPST_ENF_NINGUNA\",\n" +
                        "\"valorRespuestaExtra\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"codigoPregunta\": \"PRG_INI_ENFERMEDAD\",\n" +
                        "\"formatoRespuesta\": \"FRMTOR_CSELM\",\n" +
                        "\"valorRespuesta\": \"RPST_ENF_OTRA_TXTEXTRA\",\n" +
                        "\"valorRespuestaExtra\": \"Renitis\"\n" +
                        "}\n" +
                        "]\n" +
                        "}")
                .post("api/assessment")
                .prettyPeek();;
    }
}
