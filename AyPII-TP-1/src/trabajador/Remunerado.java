package trabajador;

import exceptions.NumeroNegativo;

public class Remunerado extends Trabajador{
	
	protected double sueldoFijo;

	public Remunerado(int dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		
	}
	
	public Remunerado(int dni, String nombre, String cuil) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		
	}
	
	/*
	 * @getSueldoFijo, devuelve el sueldo del empleado
	 */

	public double getSueldoTotal() {

		return sueldoFijo;
	}


	

}
