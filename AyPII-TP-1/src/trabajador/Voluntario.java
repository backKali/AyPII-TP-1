package trabajador;

import exceptions.NumeroNegativo;

public class Voluntario extends Trabajador {

	public Voluntario(int dni, String nombre, String cuil) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
	}

}
