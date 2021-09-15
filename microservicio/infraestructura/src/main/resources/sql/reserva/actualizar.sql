update reserva
set tipo_reserva = :tipoReserva,
	fecha_inicio = :fechaInicio,
	fecha_fin = :fechaFin,
	hora_inicio = :horaInicio,
	hora_fin = :horaFin,
	tipo_tarifa = :tipoTarifa,
	valor_total_reserva = :valorTotalReserva,
	datosCliente = :datosCliente
where id = :id