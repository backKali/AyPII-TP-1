package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.NumeroNegativo;
import trabajador.Empleado;

public class EmpleadoTest {
	
	@Test
	public void empleadoConDniInvalido() throws NumeroNegativo {

		try{
			new Empleado(-89, "Juan", "978", 8000);
		}
		catch (Exception NumeroNegativo){
			System.out.println("El dni ingresado es invalido");
		}
	}
	
	@Test
	public void empleadoConSueldoInvalido() throws NumeroNegativo {

		try{
			new Empleado(31258456, "Juan", "31-31258456-6", -12000);
		}
		catch (Exception NumeroNegativo){
			System.out.println("El El monto ingresado es menor a cero, ingrese nuevamente el monto");
		}
	}
	
	@Test
	public void obtenerElSueldoDeUnEmpleado() throws NumeroNegativo {
		
		
			Empleado alfonzo = new Empleado(27853156, "Alfonzo", "27-27853156-6", 13500);
			Assert.assertEquals(13500, alfonzo.getSueldoTotal(), 10);
			
	}		
	
}