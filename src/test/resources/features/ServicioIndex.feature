# language: es

Característica: Consumo  API de Servicio Index Valoracion
  Como usuario del servicio
  Quiero ver las recomendaciones

  @IndexValoracion
  Escenario:  Mensajes exitoso del servicio index valoracion
    Cuando el usuario envía una petición al servicio de index valoracion
    |dni|C1069757224|
    Entonces el usuario deberá ver respuesta exitosa del indice

  @IndiceConclienteNocreado
  Escenario:  Mensajes fallido al enviar cliente inexistente al  servicio indice valoracion
    Cuando el usuario envía una petición con cliente que no existe al servicio indice valoracion
      |dni|P10697573|
    Entonces el usuario deberá ver respuesta errada del indice