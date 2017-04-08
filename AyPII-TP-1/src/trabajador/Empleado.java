package trabajador;

import exceptions.NumeroNegativo;

public class Empleado extends Trabajador {

	private double sueldoFijo;

	/*
	 * @param dni, dni del empleado
	 * @param nombre, aprellido y nombre del empleado
	 * @param cuil, el cuil del empleado
	 * @param sueldoFijo, indica el sueldo del emplea
	 */
	
	public Empleado(int dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {

		super(dni, nombre, cuil);
		try {
			
			this.sueldoFijo = sueldoFijo;			
		} catch (Exception NumeroNegativo) {
			
			if (sueldoFijo >= 0) {
				throw new NumeroNegativo("El monto ingresado es menor a cero, ingrese nuevamente el monto");
			}
		}
	}
	
	/*
	 * @getSueldoFijo, devuelve el sueldo del empleado
	 */

	public double getSueldoFijo() {

		return sueldoFijo;
	}

}
