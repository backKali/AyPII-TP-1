package test;

import java.io.IOException;
import java.util.HashSet;

import empresa.Empresa;
import trabajador.EmpleadoPorHorasAComision;
import trabajador.Trabajador;
import trabajador.Voluntario;
import trabajador.Ejecutivo;
import trabajador.EmpleadoPorHoras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {
	
	//Inicializo variables de Empresa
	Empresa empresaTest;
	HashSet<Trabajador> empleados;
	
	//Inicializo variables de Empleados
	EmpleadoPorHoras empleadoPorHorasTest;
	EmpleadoPorHorasAComision empleadoPorHorasComisionTest;
	Ejecutivo ejecutivoTest;
	Voluntario voluntarioTest;
	
	@Before
	public void inicializarVariables(){
		//genero Empresa para las pruebas
		empleados = new HashSet<Trabajador>();
		empresaTest = new Empresa();
		
		//genero Empleados para las pruebas
		empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		empleadoPorHorasComisionTest = new EmpleadoPorHorasAComision("31070401", "Javier Lazzarino", "20-31070401.7", 25.0, 250.0);
		ejecutivoTest = new Ejecutivo("31070401", "Javier Lazzarino", "20-31070401-7", 35000.0);
		voluntarioTest = new Voluntario ("31070401", "Javier Lazzarino", "20-31070401-7");

	}
	
	@Test
	public void pruebaContratarEmpleado(){
		//inicializacion
		
		//operacion
		empresaTest.contratarEmpleado(voluntarioTest);
		
		//evaluacion
		Assert.assertTrue(empleados.contains(voluntarioTest));
	}
	
	@Test
	public void pruebaDespedirEmpleado(){
		//inicializacion
		
		//operacion
		empresaTest.contratarEmpleado(ejecutivoTest);
		boolean empleadoContratado = empleados.contains(ejecutivoTest);
		empresaTest.despedirEmpleado(ejecutivoTest);
		boolean empleadoDespedido = empleados.contains(ejecutivoTest);
		
		//evaluacion
		Assert.assertTrue(empleadoContratado);
		Assert.assertFalse(empleadoDespedido);
	}
	
	
	
	@Test
	public void pruebaCalcularSueldoAPagarTodosLosEmpleados() {
		//inicializacion
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(ejecutivoTest);
		empresaTest.contratarEmpleado(voluntarioTest);
		
		empleadoPorHorasComisionTest.setTotalDeVentas(100);
		empleadoPorHorasComisionTest.setHorasTrabajadas(160);
		empleadoPorHorasComisionTest.setSueldoFijo();
		
		empleadoPorHorasTest.setHorasTrabajadas(80);
		empleadoPorHorasTest.setSueldoFijo();
		
		double sueldoAPagarPorHoras = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasTest);
		double sueldoAPagarPorHorasComision = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasComisionTest);
		double sueldoEjecutivo = empresaTest.calcularSueldoAPagarEmpleado(ejecutivoTest);
		
		//evaluacion
		Assert.assertEquals(20000.0, sueldoAPagarPorHoras,0.0);
		Assert.assertEquals(40025.0, sueldoAPagarPorHorasComision,0.0);
		Assert.assertEquals(35000.0, sueldoEjecutivo,0.0);
		
	}
	
	@Test
	public void pruebaGenerarReporte() {
		//inicializacion
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(ejecutivoTest);
		empresaTest.contratarEmpleado(voluntarioTest);
		
		//evaluacion
		try {
			empresaTest.fileWriter("./pruebaGenerarReporte.txt");
		} catch (IOException mensaje) {
			System.out.println(mensaje);
		}
		

	}
}
