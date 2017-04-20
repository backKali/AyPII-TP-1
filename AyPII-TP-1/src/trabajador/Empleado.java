package trabajador;

public class Empleado extends Trabajador {


	protected double sueldoFijo;
	
	/*
	 * @param dni: dni del empleado
	 * @param nombre: aprellido y nombre del empleado
	 * @param cuil: el cuil del empleado
	 * @param sueldoFijo: indica el sueldo del emplea
	 */
	
	public Empleado(String dni, String nombre, String cuil, double sueldoFijo)  {

		super(dni, nombre, cuil);
		try {
			
			this.sueldoFijo = sueldoFijo;
		} catch (Exception NumeroNegativo) {
			
			System.out.println("El sueldo ingresado es negativo, vuelva a ingresar el sueldo");
		}
	}
	
	/*
	 * @param dni: dni del empleado
	 * @param nombre: aprellido y nombre del empleado
	 * @param cuil: el cuil del empleado
	 */
	
	public Empleado(String dni, String nombre, String cuil) {
		
		super(dni, nombre, cuil);
		
	}
	
	/*
	 * @getSueldoFijo: devuelve el sueldo del empleado
	 */

	public double getSueldoTotal() {

		return sueldoFijo;
	}
	
	/*
	 * @toString: devuelve un String con la informacion del empleado
	 */
	
	public String toString() {
		
		return super.toString() + "\nSueldo: "+this.getSueldoTotal();
	}
	
	/*
	 * @compareTo: ordena los empleados por sueldo (de mayor a menor)
	 * en caso de que existan dos con el mismo sueldo, los ordenado por dni
	 */
	
	
	public int compareTo(Empleado empleado) {

		if(this.sueldoFijo > empleado.sueldoFijo) {
			
			return -1;
		} else if (this.sueldoFijo < empleado.sueldoFijo) {
			
			return 1;
		}
		
		return this.dni.compareTo(empleado.dni);
	}
	
}
