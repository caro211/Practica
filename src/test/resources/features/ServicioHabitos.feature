# language: es

Característica: Consumo  API de Listar habitos
  Como usuario del servicio
  Quiero ver la lista de habitos

  @VerificarListaDeHabitos
  Escenario:  Mensajes exitoso del servicio al listar habitos
    Cuando el usuario envía una petición al servicio de habitos para listarlos
    Entonces el usuario deberá ver respuesta exitosa del registro


  @HabitosNoEncontrados
  Escenario:  Mensajes fallido del servicio al listar habitos
    Cuando el usuario envía una petición equivocada al servicio de habitos para listarlos
    Entonces el usuario deberá ver respuesta errada