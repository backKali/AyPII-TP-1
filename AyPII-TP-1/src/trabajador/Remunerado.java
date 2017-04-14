package trabajador;

import exceptions.NumeroNegativo;

public class Remunerado extends Trabajador implements Comparable<Remunerado>{
	
	protected double sueldoFijo;

	public Remunerado(String dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		
		try {
			
			this.sueldoFijo = sueldoFijo;
		} catch (Exception NumeroNegativo) {
			
			System.out.println("El sueldo ingresado es negativo, vuelva a ingresar el sueldo");
		}
		
	}
	
	public Remunerado(String dni, String nombre, String cuil) {
		
		super(dni, nombre, cuil);
		
	}
	
	/*
	 * @getSueldoFijo, devuelve el sueldo del empleado
	 */

	public double getSueldoTotal() {

		return sueldoFijo;
	}
	
	public String toString() {
		
		return "Nombre: "+this.getNombre() +"Cuil: "+this.getCuil()+ "Dni: "+this.getDni()+ "Sueldo: "+this.getSueldoTotal();
	}
	
	@Override
	public int compareTo(Remunerado empleado) {

		if(this.sueldoFijo > empleado.sueldoFijo) {
			
			return -1;
		} else if (this.sueldoFijo < empleado.sueldoFijo) {
			
			return 1;
		}
		
		return this.dni.compareTo(empleado.dni);
	}
	


	

}
