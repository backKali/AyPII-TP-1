package test;

import static org.junit.Assert.*;

import java.io.IOException;

import empresa.Empresa;
import trabajador.EmpleadoPorHorasAComision;
import trabajador.EmpleadoPorHoras;
import org.junit.Test;

public class EmpresaTest {
	
//	@Test
//	public void pruebaEscrituraStaticFileWriterEnLinux() {
//		//inicializacion
//		Empresa empresaTest = new Empresa();
//		
//		try {
//			empresaTest.staticFileWriter();
//		} catch (IOException message) {
//			System.out.println(message);
//		}
//	}

	@Test
	public void pruebaEscrituraFileWriterEnLinuxConArchivoDinamico() {
		//inicializacion
		Empresa empresaTest = new Empresa();
		EmpleadoPorHorasAComision empleadoPorHorasComisionTest = new EmpleadoPorHorasAComision("31070401", "Javier Lazzarino", "20-31070401.7", 25.0, 250.0);
		EmpleadoPorHoras empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		
		//evaluacion
		try {
			empresaTest.fileWriter("./empleados.txt");
		} catch (IOException message) {
			System.out.println(message);
		}
	}
	
	@Test
	public void pruebaCalcularSueldoAPagarUnEmpleadoPorHora() {
		//inicializacion
		Empresa empresaTest = new Empresa();
		EmpleadoPorHoras empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		double sueldoAPagar = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasTest);
		
		//evaluacion
		assert.assertEquals(0.0, sueldoAPagar);
		
		try {
			empresaTest.fileWriter("./empleados.txt");
		} catch (IOException message) {
			System.out.println(message);
		}
	}
	
	@Test
	public void pruebaCalcularSueldoAPagarUnEmpleadoPorHoraYUnEmpleadoPorHoraAComision() {
		//inicializacion
		Empresa empresaTest = new Empresa();
		EmpleadoPorHorasAComision empleadoPorHorasComisionTest = new EmpleadoPorHorasAComision("31070401", "Javier Lazzarino", "20-31070401.7", 25.0, 250.0);
		EmpleadoPorHoras empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		double sueldoAPagarEmpleadoHorasComision = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasComisionTest);
		double sueldoAPagarEmpleadoHoras = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasTest);
		
		//evaluacion
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHorasComision);
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHoras);
		
		try {
			empresaTest.fileWriter("./empleados.txt");
		} catch (IOException message) {
			System.out.println(message);
		}
	}
	
	@Test
	public void pruebaCalcularSueldoAPagarUnPorHorasYUnEjecutivoSinPremio() {
		//inicializacion
		Empresa empresaTest = new Empresa();
		EmpleadoPorHorasAComision empleadoPorHorasComisionTest = new EmpleadoPorHorasAComision("31070401", "Javier Lazzarino", "20-31070401.7", 25.0, 250.0);
		EmpleadoPorHoras empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		double sueldoAPagarEmpleadoHorasComision = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasComisionTest);
		double sueldoAPagarEmpleadoHoras = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasTest);
		
		//evaluacion
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHorasComision);
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHoras);
		
		try {
			empresaTest.fileWriter("./empleados.txt");
		} catch (IOException message) {
			System.out.println(message);
		}
	}
	
	@Test
	public void pruebaCalcularSueldoAPagarUnPorHorasYUnEjecutivoConPremio() {
		//inicializacion
		Empresa empresaTest = new Empresa();
		EmpleadoPorHorasAComision empleadoPorHorasComisionTest = new EmpleadoPorHorasAComision("31070401", "Javier Lazzarino", "20-31070401.7", 25.0, 250.0);
		EmpleadoPorHoras empleadoPorHorasTest = new EmpleadoPorHoras("31070401", "Javier Lazzarino", "20-31070401-7",250.0);
		
		//operacion
		empresaTest.contratarEmpleado(empleadoPorHorasComisionTest);
		empresaTest.contratarEmpleado(empleadoPorHorasTest);
		double sueldoAPagarEmpleadoHorasComision = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasComisionTest);
		double sueldoAPagarEmpleadoHoras = empresaTest.calcularSueldoAPagarEmpleado(empleadoPorHorasTest);
		
		//evaluacion
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHorasComision);
		assert.assertEquals(0.0,sueldoAPagarEmpleadoHoras);
		
		try {
			empresaTest.fileWriter("./empleados.txt");
		} catch (IOException message) {
			System.out.println(message);
		}
	}
	
}
