package com.ceiba.reserva.servicio;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

public class ServicioCrearReservaTest {
	
    @Test
    public void validarReservasExistentesTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existenReservas(Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"Ya existen reservas en las fechas ingresadas");
    }
    
    
    @Test
    public void crearReserva() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existenReservas(Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject(),Mockito.anyObject())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(Mockito.anyObject())).thenReturn(10L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act 
        long id=servicioCrearReserva.ejecutar(reserva);
        //assert
        assertEquals(10L, id);
    }
    

}
