package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.NumeroNegativo;
import trabajador.Empleado;
import trabajador.EmpleadoPorHoras;
import trabajador.EmpleadoPorHorasAComision;
import trabajador.Ejecutivo;
import trabajador.Voluntario;

public class EmpleadoTest {
	
	@Test
	public void pruebaMetodoDevuelveSueldoSinPremioAEjecutivo(){
		//inicializacion
		Ejecutivo pruebaEjecutivo = new Ejecutivo("31070401","Javier Lazzarino","20310704017",30000.0);
		
		//operacion
		double sueldoSinPremio = pruebaEjecutivo.getSueldoTotal();
		
		//evaluacion
		Assert.assertEquals(30000.0, sueldoSinPremio, 0.0);
		
	}
	
	@Test
	public void pruebaMetodoDevuelveValorPremioDeEjecutivo(){
		//inicializacion
		Ejecutivo pruebaEjecutivo = new Ejecutivo("31070401","Javier Lazzarino","20310704017",30000.0);
		
		//operacion
		pruebaEjecutivo.otorgarPremio(5000.0);
		
		//evaluacion
		Assert.assertEquals(5000.0, pruebaEjecutivo.getPremioMonto(), 0.0);
		
	}
	
	@Test
	public void pruebaEntregaPremioAEjecutivo(){
		//inicializacion
		Ejecutivo pruebaEjecutivo = new Ejecutivo("31070401","Javier Lazzarino","20310704017",30000.0);
		
		//operacion
		pruebaEjecutivo.otorgarPremio(5000.0);
		double sueldoConPremioUnaVez = pruebaEjecutivo.getSueldoTotal();
		
		//evaluacion
		Assert.assertEquals(35000.0, sueldoConPremioUnaVez, 0.0);
		
	}
	
	@Test
	public void pruebaEntregaPremioAEjecutivoPorSegundaVez(){
		//inicializacion
		Ejecutivo pruebaEjecutivo = new Ejecutivo("31070401","Javier Lazzarino","20310704017",30000.0);
		
		//operacion
		pruebaEjecutivo.getSueldoTotal();
		pruebaEjecutivo.otorgarPremio(5000.0);
		pruebaEjecutivo.getSueldoTotal();
		double sueldoConPremioSegundaVez = pruebaEjecutivo.getSueldoTotal(); 
		
		//evaluacion
		Assert.assertEquals(30000.0, sueldoConPremioSegundaVez, 0.0);
		
	}
	
	
	
	
	
	
}