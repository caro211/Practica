# language: es

Característica: Consumo  API de Servicio consulta valoracion
  Como usuario del servicio
  Quiero ver las valoraciones

  @ConsultaValoracionExitoso
  Escenario:  Mensajes exitoso del servicio de consulta valoracion
    Cuando el usuario envía una petición al servicio de consulta valoracion
    |dni|C1069757224|
    |codvaloracion|VAL-ACT_FISIC|
    Entonces el usuario deberá ver respuesta exitosa de consulta valoracion

  @ConsultaValoracionAlimentacionExitoso
  Escenario:  Mensajes exitoso del servicio de consulta valoracion Alimentacion
    Cuando el usuario envía una petición al servicio de consulta valoracion Alimentacion
      |dni|C1069757224|
      |codvaloracion|VAL-ALIMENTA|
    Entonces el usuario deberá ver respuesta exitosa de consulta valoracion

  @ConsultaValoracionSaludMentalExitoso
  Escenario:  Mensajes exitoso del servicio de consulta valoracion Salud Mental
    Cuando el usuario envía una petición al servicio de consulta valoracion Salud mental
      |dni|C1069757224|
      |codvaloracion|VAL-SMENTAL|
    Entonces el usuario deberá ver respuesta exitosa de consulta valoracion

  @ConsultaValoracionFallido
  Escenario:  Mensajes Fallido del servicio de consulta valoracion
    Cuando el usuario envía una petición fallida al servicio de consulta valoracion
      |dni|C1069757224|
      |codvaloracion|VAL-ACT_FISI|
    Entonces el usuario deberá ver respuesta fallida de consulta valoracion