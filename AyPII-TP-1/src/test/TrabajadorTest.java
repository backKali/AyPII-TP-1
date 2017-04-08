package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.NumeroNegativo;
import trabajador.Trabajador;

public class TrabajadorTest {

	@Test
	public void trabajadorConDniInvalido() throws NumeroNegativo {

		try{
			new Trabajador(-89, "Juan", "978");
		}
		catch (Exception NumeroNegativo){
			System.out.println("El dni ingresado es invalido");
		}
	}
	
	@Test
	public void obtenerElDniDeUnTrabajador() throws NumeroNegativo {
		Trabajador t = new Trabajador(32654987, "Juan", "32-32654987-7");
		Assert.assertEquals(32654987, t.getDni());
	}
	
	@Test
	public void obtenerElNombreDeUnTrabajador() throws NumeroNegativo {
		Trabajador e = new Trabajador(36852741, "Juan", "36-36852741-1");
		Assert.assertEquals("Juan", e.getNombre());
	}
	
	@Test
	public void obtenerElCuilDeUnTrabajador() throws NumeroNegativo {
		Trabajador r = new Trabajador(30123654, "Juan", "30-30123654-4");
		Assert.assertEquals("30-30123654-4", r.getCuil());
	}

}
