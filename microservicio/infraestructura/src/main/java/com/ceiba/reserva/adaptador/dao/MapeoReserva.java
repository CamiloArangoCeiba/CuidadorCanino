package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {
	
	 @Override
	    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

	        Long id = resultSet.getLong("id");
	        String tipoReserva = resultSet.getString("tipo_reserva");
	        LocalDate fechaInicio = extraerLocalDate(resultSet, "fecha_inicio");
	        LocalDate fechaFin = extraerLocalDate(resultSet, "fecha_fin");
	        LocalTime horaInicio = extraerLocalTime(resultSet, "hora_inicio");
	        LocalTime horaFin = extraerLocalTime(resultSet, "hora_fin");
	        String tipoTarifa = resultSet.getString("tipo_tarifa");
	        double valorTotalReserva=resultSet.getFloat("valor_total_reserva");
	        String datosCliente = resultSet.getString("datos_cliente");
	        return new DtoReserva(id,tipoReserva,fechaInicio,fechaFin,horaInicio,horaFin,tipoTarifa,valorTotalReserva,datosCliente);
	 }

}
