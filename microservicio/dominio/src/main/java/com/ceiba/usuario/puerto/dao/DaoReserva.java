package com.ceiba.usuario.puerto.dao;

import java.util.List;

import com.ceiba.reserva.modelo.dto.DtoReserva;

public interface DaoReserva {
	
	/**
     * Permite listar las reservas
     * @return las reservas
     */
    List<DtoReserva> listar();
    
	/**
     * Permite consultar una rserva por id 
     * @param  id de la reserva
     * @return la reserva
     */
    DtoReserva consultarPorId(Long id);

}
