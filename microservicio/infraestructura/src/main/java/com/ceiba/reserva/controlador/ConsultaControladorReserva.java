package com.ceiba.reserva.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.reserva.consulta.ManejadorConsultarReserva;
import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador consulta reservas" })
public class ConsultaControladorReserva {

	private final ManejadorListarReservas manejadorListarReservas;
	private final ManejadorConsultarReserva manejadorConsultarReserva;

	public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas, ManejadorConsultarReserva manejadorConsultarReserva) {
		this.manejadorListarReservas = manejadorListarReservas;
		this.manejadorConsultarReserva=manejadorConsultarReserva;
	}

	@GetMapping
	@ApiOperation("Listar Reservas")
	public List<DtoReserva> listar() {
		return this.manejadorListarReservas.ejecutar();
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation("Consultar Reserva")
	public DtoReserva consultarPorId(@PathVariable Long id) {
		return manejadorConsultarReserva.ejecutar(id);
	}
}
