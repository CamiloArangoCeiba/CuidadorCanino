package com.ceiba.reserva.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.usuario.puerto.dao.DaoReserva;

@Component
public class ManejadorConsultarReserva {
	
private final DaoReserva daoReserva;
	
	public ManejadorConsultarReserva(DaoReserva daoReserva){
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long id){ return this.daoReserva.consultarPorId(id); }

}
