# language: es

Característica: Consumo  API de Servicio Ingreso Valoracion
  Como usuario del servicio
  Quiero ver ingresar la valoracion de actividad fisica

  @IngresoValoracionActividadFisica
  Escenario:  Mensajes exitoso del servicio ingreso valoracion actividad fisica
    Cuando el usuario envía una petición al servicio de ingreso valoracion con actividad fisica
    Entonces el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion
      |dni|C1069757224|


  @IngresoValoracionAlimentacion
  Escenario:  Mensajes exitoso del servicio ingreso valoracion alimentacion
    Cuando el usuario envía una petición al servicio de ingreso valoracion con alimentacion
    Entonces el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion alimentacion


  @IngresoValoracionSaludMental
  Escenario:  Mensajes exitoso del servicio ingreso valoracion salud mental
    Cuando el usuario envía una petición al servicio de ingreso valoracion salud mental
    Entonces el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion
      |dni|C1069757224|


  @IngresoValoracionInicial
  Escenario:  Mensajes exitoso del servicio ingreso valoracion inicial
    Cuando el usuario envía una petición al servicio de ingreso valoracion inicial
    Entonces el usuario deberá ver respuesta exitosa del registro al ingresar la valoracion inicial

  @EstadoValoracionIncorrecto
  Escenario:  Mensajes fallido del servicio ingreso valoracion
    Cuando el usuario envía una petición al servicio de ingreso valoracion con estado errado
    Entonces el usuario deberá ver respuesta errada del registro