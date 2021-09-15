package com.ceiba.reserva.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

@Component
public class FabricaReserva {
	
	public Reserva crear(ComandoReserva comandoReserva) {
        return new Reserva(
        		comandoReserva.getId(),
        		comandoReserva.getTipoReserva(),
        		comandoReserva.getFechaInicio(),
        		comandoReserva.getFechaFin(),
        		comandoReserva.getHoraInicio(),
        		comandoReserva.getHoraFin(),
        		comandoReserva.getTipoTarifa(),
        		comandoReserva.getDatosCliente()
        );
    }

}
