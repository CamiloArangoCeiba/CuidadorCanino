package com.ceiba.reserva.puerto.repositorio;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
	
	/**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param usuario
     * return registros modificados
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existen reservas de acuerdo a las fechas y horas
     * @param fechaInicio, fechaFin, horaInicio, horaFin
     * @return si existen o no
     */
    boolean existenReservas(Long id,LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin);
    

}
