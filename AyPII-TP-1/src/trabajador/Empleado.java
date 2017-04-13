package trabajador;

import exceptions.NumeroNegativo;

public class Empleado extends Remunerado {


	/*
	 * @param dni, dni del empleado
	 * @param nombre, aprellido y nombre del empleado
	 * @param cuil, el cuil del empleado
	 * @param sueldoFijo, indica el sueldo del emplea
	 */
	
	public Empleado(int dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {

		super(dni, nombre, cuil, sueldoFijo);
	}

}
