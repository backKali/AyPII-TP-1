package trabajador;

import exceptions.NumeroNegativo;

public class NoRemunerado extends Trabajador{

	public NoRemunerado(String dni, String nombre, String cuil) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
	}

}
