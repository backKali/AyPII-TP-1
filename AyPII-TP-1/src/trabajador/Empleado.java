package trabajador;

public class Empleado extends Remunerado {


	/*
	 * @param dni, dni del empleado
	 * @param nombre, aprellido y nombre del empleado
	 * @param cuil, el cuil del empleado
	 * @param sueldoFijo, indica el sueldo del emplea
	 */
	
	public Empleado(String dni, String nombre, String cuil, double sueldoFijo)  {

		super(dni, nombre, cuil, sueldoFijo);
	}
	

}
