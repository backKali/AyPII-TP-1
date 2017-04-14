package trabajador;

import exceptions.NumeroNegativo;

public class Voluntario extends NoRemunerado {

	public Voluntario(String dni, String nombre, String cuil) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
	}

}
