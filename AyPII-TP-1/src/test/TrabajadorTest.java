package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.NumeroNegativo;
import exceptions.DniInvalido;
import exceptions.CuilInvalido;
import exceptions.CuilDistintoDelDni;

import trabajador.Trabajador;

public class TrabajadorTest {
	
//	@Test (expected = Error.class)
//	public void pruebaGenerarTrabajadorConDniInvalidoPorNoContenerNumeros(){
//		
//		//inicializacion
//		Trabajador pruebaTrabajadorInvalido = new Trabajador ( "StringInvalido", "Javier Lazzarino", "20-31070401-7" );
//		
//		//operacion
//		
//	}
	
	@Test
	public void pruebaGenerarTrabajadorConDniInvalidoPorMenorAUnMillon(){
		
		//inicializacion
		new Trabajador ( "900000", "Javier Lazzarino", "20-0900000-7" );
		
		//operacion
		System.out.println("Debio hacer 'catch' de 'DniInvalido'");
		System.out.println("Fin test case pruebaGenerarTrabajadorConDniInvalidoPorMenorAUnMillon");
	}
	
	@Test
	public void pruebaObtenerDniCorrectamente(){
		//inicializacion
		Trabajador pruebaTrabajadorValido = new Trabajador ( "31070401", "Javier Lazzarino", "20-31070401-7" );
		
		//operacion
		
		//evaluacion
		Assert.assertEquals("31070401", pruebaTrabajadorValido.getDni());
	}
	

}
