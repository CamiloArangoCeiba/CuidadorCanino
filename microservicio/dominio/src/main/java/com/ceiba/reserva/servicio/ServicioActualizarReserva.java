package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

private static final String EXISTEN_RESERVAS_PARA_LA_FECHA = "Ya existen reservas en las fechas ingresadas";
	
	private final RepositorioReserva repositorioReserva;
	
    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }
    
    public void ejecutar(Reserva reserva) {
    	validarReservasExistentes(reserva);
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarReservasExistentes(Reserva reserva) {
        boolean existe = this.repositorioReserva.existenReservas(reserva.getId(),reserva.getFechaFin(),reserva.getFechaFin(), reserva.getHoraInicio(),reserva.getHoraFin());
        if(existe) {
            throw new ExcepcionDuplicidad(EXISTEN_RESERVAS_PARA_LA_FECHA);
        }
    }
}
