select count(1)  from reserva where fecha_inicio>= :fechaInicio 
and hora_inicio>=:horaInicio
and fecha_fin<=:fechaFin
and hora_fin<=:horaFin
