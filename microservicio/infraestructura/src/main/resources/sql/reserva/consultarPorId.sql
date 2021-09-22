select id,tipo_reserva,fecha_inicio,fecha_fin,hora_inicio,hora_fin,
tipo_tarifa,valor_total_reserva,datos_cliente
from reserva
where id=:id