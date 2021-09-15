package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ReservaTestDataBuilder {
	
    private Long id;
    private String tipoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tipoTarifa;
    private String datosCliente;
    
    public ReservaTestDataBuilder() {
    	tipoReserva = "HORA";
    	fechaInicio = LocalDate.of(2050, 1, 2);
    	fechaFin = LocalDate.of(2050, 1, 2);
    	horaInicio=LocalTime.of(8, 0);
    	horaFin=LocalTime.of(10, 0);
    	tipoTarifa="UNICO";
    	datosCliente="Cliente prueba";
    			
    }

    public Reserva build() {
        return new Reserva(id,tipoReserva, fechaInicio, fechaFin, horaInicio, horaFin, tipoTarifa, datosCliente);
    }      

}
