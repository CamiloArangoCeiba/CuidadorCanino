package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ceiba.reserva.comando.ComandoReserva;

public class ComandoReservaTestDataBuilder {

	private Long id;
    private String tipoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tipoTarifa;
    double valorTotalReserva;
    private String datosCliente;
    
    public ComandoReservaTestDataBuilder() {
    	tipoReserva = "HORA";
    	fechaInicio = LocalDate.of(2050, 1, 3);
    	fechaFin = LocalDate.of(2050, 1, 3);
    	horaInicio=LocalTime.of(8, 0);
    	horaFin=LocalTime.of(10, 0);
    	tipoTarifa="UNICO";
    	valorTotalReserva=1000;
    	datosCliente="Cliente prueba";
    			
    }

    public ComandoReserva build() {
        return new ComandoReserva(id,tipoReserva, fechaInicio, fechaFin, horaInicio, horaFin, tipoTarifa,valorTotalReserva, datosCliente);
    }      
}
