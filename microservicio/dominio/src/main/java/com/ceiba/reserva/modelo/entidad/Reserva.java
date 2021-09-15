package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarValido;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarMenorNoIgual;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import lombok.Getter;


@Getter
public class Reserva {
	
    
    enum tipoTarifas
    {
        UNICO, DUO, FAMILIAR;
    }
    
    enum tipoReservas
    {
        FECHA, HORA;
    }

    private static final String SE_DEBE_INGRESAR_EL_TIPO_RESERVA= "Se debe ingresar el tipo de reserva";
    private static final String EL_TIPO_RESERVA_NO_EXISTE= "Se debe ingresar un tipo de reserva válido";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha inicio";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha fin";
    private static final String SE_DEBE_INGRESAR_LA_HORA_INICIO = "Se debe ingresar la hora inicio";
    private static final String SE_DEBE_INGRESAR_LA_HORA_FIN = "Se debe ingresar la hora fin";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_TARIFA= "Se debe ingresar el tipo de tarifa";
    private static final String EL_TIPO_TARIFA_NO_EXISTE= "Se debe ingresar un tipo de tarifa válido";
    private static final String SE_DEBE_INGRESAR_LOS_DATOS_DEL_CLIENTE= "Se debe ingresar los datos del cliente";
    private static final String LA_FECHA_INICIAL_DEBE_SER_MENOR_QUE_FECHA_FINAL= "La fecha inicial debe ser menor que la final";
    private static final String LA_FECHA_INICIAL_DEBE_SER_IGUAL_QUE_FECHA_FINAL= "La fecha inicial debe ser igual que la final";
    private static final String LA_FECHA_INICIAL_DEBE_SER_MAYOR_O_IGUAL_QUE_FECHA_ACTUAL= "La fecha inicial debe ser mayor o igual que la fecha actual";
    private static final String LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_INICIAL= "La hora final debe ser mayor que la inicial";
    private static final String LA_HORA_INICIAL_DEBE_SER_MAYOR_2_HORAS= "La hora inicial debe ser mayor o igual a la hora actual mas 2 horas";
    private static final String LA_HORA_INICIAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA= "La hora inicial debe ser mayor o igual que las 6 a.m";
    private static final String LA_HORA_INICIAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA= "La hora inicial debe ser menor que las 9 p.m";
    private static final String LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA= "La hora final debe ser mayor que las 6 a.m";
    private static final String LA_HORA_FINAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA= "La hora final debe ser menor o igual que las 9 p.m";

    
    private static final LocalTime HORA_MINIMA = LocalTime.of(6, 0);
    private static final LocalTime HORA_MAXIMA = LocalTime.of(21, 0);
    private static final int DIFERENCIA_HORA_MAXIMA = 1;
    private static final int TARIFA_DIA = 18000;
    private static final int TARIFA_HORA = 1000;
    private static final double TARIFA_DUO = 1.8;
    private static final double TARIFA_FAMILIAR = 2.6;
    private static final double TARIFA_FIN_SEMANA = 1.5;
    
    private Long id;
    private String tipoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tipoTarifa;
    private double valorTotalReserva;
    private String datosCliente;
     
    

    
    public Reserva (Long id,String tipoReserva,LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, String tipoTarifa,
    		String datosCliente) {
    	validarObligatorio(tipoReserva, SE_DEBE_INGRESAR_EL_TIPO_RESERVA);
    	validarValido(tipoReserva, tipoReservas.class,EL_TIPO_RESERVA_NO_EXISTE);
    	validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FIN);
    	validarObligatorio(horaInicio, SE_DEBE_INGRESAR_LA_HORA_INICIO);
    	validarObligatorio(horaFin, SE_DEBE_INGRESAR_LA_HORA_FIN);
    	validarObligatorio(tipoTarifa, SE_DEBE_INGRESAR_EL_TIPO_TARIFA);
    	validarValido(tipoTarifa, tipoTarifas.class,EL_TIPO_TARIFA_NO_EXISTE);
    	validarObligatorio(datosCliente, SE_DEBE_INGRESAR_LOS_DATOS_DEL_CLIENTE);
    	validarFechasHoras(tipoReserva,fechaInicio,fechaFin,horaInicio,horaFin);
    	this.id = id;
    	this.tipoReserva = tipoReserva;
    	this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoTarifa = tipoTarifa;
        this.datosCliente = datosCliente;
        this.valorTotalReserva=calcularTotalReserva(tipoReserva,fechaInicio,fechaFin,horaInicio,horaFin,tipoTarifa);
    }
    
    private void validarFechasHoras(String tipoReserva,LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin) {
    	validarMenor(LocalDate.now(), fechaInicio, LA_FECHA_INICIAL_DEBE_SER_MAYOR_O_IGUAL_QUE_FECHA_ACTUAL);
    	validarMenor(HORA_MINIMA, horaInicio, LA_HORA_INICIAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA);
    	validarMenorNoIgual(horaInicio, HORA_MAXIMA, LA_HORA_INICIAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA);
    	validarMenorNoIgual(HORA_MINIMA, horaFin, LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA);
    	validarMenor(horaFin, HORA_MAXIMA, LA_HORA_FINAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA);
    	if(fechaInicio.equals(LocalDate.now())){
    		validarMenor(LocalTime.now().plusHours(DIFERENCIA_HORA_MAXIMA),horaInicio, LA_HORA_INICIAL_DEBE_SER_MAYOR_2_HORAS);
    	};
    	if(tipoReserva.equals(tipoReservas.FECHA.toString())) {
    		validarMenor(fechaInicio, fechaFin, LA_FECHA_INICIAL_DEBE_SER_MENOR_QUE_FECHA_FINAL);	
    	}else if(tipoReserva.equals(tipoReservas.HORA.toString())) {
    		validarMenorNoIgual(horaInicio, horaFin, LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_INICIAL); 
    		validarIgual(fechaInicio,fechaFin, LA_FECHA_INICIAL_DEBE_SER_IGUAL_QUE_FECHA_FINAL);
    	}
    }
    
    private double calcularTotalReserva(String tipoReserva,LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin,String tipoTarifa) {
    	double valorTarifa=calcularValorTarifaPorTipoReserva(tipoReserva,fechaInicio,fechaFin,horaInicio,horaFin);    	
    	if(tipoTarifa.equals(tipoTarifas.DUO.toString())) {
    		valorTarifa= valorTarifa*TARIFA_DUO;
    	}else if(tipoTarifa.equals(tipoTarifas.FAMILIAR.toString())) {
    		valorTarifa= valorTarifa *TARIFA_FAMILIAR;
    	}
    	return valorTarifa;
    	
    }
    
    private double calcularValorTarifaPorTipoReserva(String tipoReserva,LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin) {
    	double valorTarifa=0;
    	if(tipoReserva.equals(tipoReservas.FECHA.toString())){
    		double diasFinDeSemana=calcularDiasFinDeSemana(fechaInicio,fechaFin);
    	    double diferenciaDias = ChronoUnit.DAYS.between(fechaInicio, fechaFin)-diasFinDeSemana;
    	    valorTarifa= (TARIFA_DIA * diferenciaDias) + (TARIFA_FIN_SEMANA*TARIFA_DIA * diasFinDeSemana);
    	}else if(tipoReserva.equals(tipoReservas.HORA.toString())){
    	    Duration duracion = Duration.between(horaInicio,horaFin);
    	    double diferenciaHoras = Math.abs(duracion.toHoursPart());
    	    valorTarifa=TARIFA_HORA*diferenciaHoras;
    	    if(fechaInicio.getDayOfWeek().getValue()>5) {
    	    	valorTarifa=valorTarifa*TARIFA_FIN_SEMANA;
    		}
    	}
    	return valorTarifa;
    	
    }
    
    private double calcularDiasFinDeSemana(LocalDate fechaInicio, LocalDate fechaFin) {
    	int diaDeLaSemana=0;
    	double dias=0;
    	while(fechaFin.isAfter(fechaInicio)) {
    		diaDeLaSemana=fechaInicio.getDayOfWeek().getValue();
    		if(diaDeLaSemana>5) {
    			dias ++;
    		}
    		fechaInicio=fechaInicio.plusDays(1);
    	}
    	return dias;
    	
    }    

}
