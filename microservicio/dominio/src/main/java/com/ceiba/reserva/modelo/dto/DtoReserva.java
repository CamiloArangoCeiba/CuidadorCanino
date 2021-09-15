package com.ceiba.reserva.modelo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id;
    private String tipoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tipoTarifa;
    private double valorTotalReserva;
    private String datosCliente;
}
