package com.ceiba.reserva.modelo.entidad;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ReservaTest {
	
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

    private static final int TARIFA_DIA = 18000;
    private static final int TARIFA_HORA = 1000;
    private static final double TARIFA_DUO = 1.8;
    private static final double TARIFA_FAMILIAR = 2.6;
    private static final double TARIFA_FIN_SEMANA = 1.5;
	
    @Test
    public void validarTipoReservaNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,null, LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_RESERVA);
    }

	
    @Test
    public void validarTipoReservaNoExisteTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"NOEXISTE", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, EL_TIPO_RESERVA_NO_EXISTE);
    }
    
    @Test
    public void validarFechaInicioNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", null, LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
    }
    
    @Test
    public void validarFechaFinNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), null, LocalTime.now(), LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_FIN);
    }
    
    @Test
    public void validarHoraInicioNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), null, LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_HORA_INICIO);
    }
    
    @Test
    public void validarHoraFinNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now(),null, "UNICO", "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_HORA_FIN);
    }
    
    @Test
    public void validarTipoTarifaNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), null, "Cliente prueba"), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_TARIFA);
    }
    
    @Test
    public void validarTipoTarifaNoExisteTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "NOEXISTE", "Cliente prueba"), ExcepcionValorInvalido.class, EL_TIPO_TARIFA_NO_EXISTE);
    }
    
    @Test
    public void validarDatosClienteNullTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "UNICO", null), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_DATOS_DEL_CLIENTE);
    }
    
    @Test
    public void validarFechaInicioMayorIgualFechaActualTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now().minusDays(1), LocalDate.now(), LocalTime.now().plusHours(2), LocalTime.now().plusHours(3), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_FECHA_INICIAL_DEBE_SER_MAYOR_O_IGUAL_QUE_FECHA_ACTUAL);
    }
    
    @Test
    public void validarFechaInicioMenorFechaFinalTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"FECHA", LocalDate.now(), LocalDate.now().minusDays(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(3), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_FECHA_INICIAL_DEBE_SER_MENOR_QUE_FECHA_FINAL);
    }
    
    @Test
    public void validarHoraInicioMayorHoraFinalTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now().plusHours(3), LocalTime.now().plusHours(2), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_INICIAL);
    }
    
    @Test
    public void validarFechaInicioIgualFechaFinalTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now().plusDays(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(3), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_FECHA_INICIAL_DEBE_SER_IGUAL_QUE_FECHA_FINAL);
    }
    
    @Test
    public void validarHoraInicioMayorIgualHoraSistemaMas2HorasTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"HORA", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(3), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_INICIAL_DEBE_SER_MAYOR_2_HORAS);
    }

    @Test
    public void validarHoraInicioMayorHoraMinimaTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"FECHA", LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),  LocalTime.of(5, 0), LocalTime.now().plusHours(1), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_INICIAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA);
    }
    
    @Test
    public void validarHoraInicioMenorHoraMaximaTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"FECHA", LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),  LocalTime.of(22, 0), LocalTime.of(22, 0), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_INICIAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA);
    }
    
    @Test
    public void validarHoraFinalMayorHoraMinimaTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"FECHA", LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),  LocalTime.now(), LocalTime.of(6, 0), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_FINAL_DEBE_SER_MAYOR_QUE_HORA_MINIMA);
    }
    
    @Test
    public void validarHoraFinalMenorHoraMaximaTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new Reserva(null,"FECHA", LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),  LocalTime.now(), LocalTime.of(22, 0), "UNICO", "Cliente prueba"), ExcepcionValorInvalido.class, LA_HORA_FINAL_DEBE_SER_MENOR_QUE_HORA_MAXIMA);
    }
    
    @Test
    public void calcularTarifaHoraUnicoTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 3), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "UNICO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_HORA*2,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaHoraUnicoFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 2), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "UNICO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_FIN_SEMANA*TARIFA_HORA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaUnicoTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 5), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "UNICO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_DIA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaUnicoFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 1), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "UNICO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_FIN_SEMANA*TARIFA_DIA*1.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaHoraDuoTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 3), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "DUO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_DUO*TARIFA_HORA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaHoraDuoFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 2), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "DUO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_DUO*TARIFA_FIN_SEMANA*TARIFA_HORA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaDuoTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 5), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "DUO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_DUO*TARIFA_DIA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaDuoFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 1), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "DUO", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_DUO*TARIFA_FIN_SEMANA*TARIFA_DIA*1.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaHoraFamiliarTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 3), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "FAMILIAR", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_FAMILIAR*TARIFA_HORA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaHoraFamiliarFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"HORA", LocalDate.of(2050, 1, 2), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "FAMILIAR", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(Math.round(TARIFA_FAMILIAR*TARIFA_FIN_SEMANA*TARIFA_HORA*2.0),reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaFamiliarTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 3), LocalDate.of(2050, 1, 5), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "FAMILIAR", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_FAMILIAR*TARIFA_DIA*2.0,reserva.getValorTotalReserva(),0);
    	
    }
    
    @Test
    public void calcularTarifaDiaFamiliarFinDeSemanaTest() {
        // arrange-act
    	Reserva reserva=new Reserva(null,"FECHA", LocalDate.of(2050, 1, 1), LocalDate.of(2050, 1, 2), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), "FAMILIAR", "Cliente prueba");
        //  assert
    	 Assert.assertEquals(TARIFA_FAMILIAR*TARIFA_FIN_SEMANA*TARIFA_DIA*1.0,reserva.getValorTotalReserva(),0.0);
    	
    }
}
