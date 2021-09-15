package com.ceiba.usuario.puerto.dao;

import java.util.List;

import com.ceiba.reserva.modelo.dto.DtoReserva;

public interface DaoReserva {
	
	/**
     * Permite listar las reservas
     * @return las reservas
     */
    List<DtoReserva> listar();

}
