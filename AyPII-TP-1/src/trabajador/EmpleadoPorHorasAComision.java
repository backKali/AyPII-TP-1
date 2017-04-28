package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHorasAComision extends EmpleadoPorHoras {

	private double porcentajeDeComision;
	private int totalDeVentas;
	

	/*
	 * @param dni: dni del empleado
	 * 
	 * @param nombre: aprellido y nombre del empleado
	 * 
	 * @param cuil: el cuil del empleado
	 * 
	 * @param sueldoFijo: indica el sueldo del empleado
	 * 
	 * @param montoPorHora: indica el monto que se le paga por hora
	 * 
	 * @param porcentajeDeComision: indica el porcentaje de la comision que
	 * recibe el empleado
	 */

	public EmpleadoPorHorasAComision(String dni, String nombre, String cuil, double porcentajeDeComision,
			double montoPorHora) {

		super(dni, nombre, cuil, montoPorHora);

		try {
			
			this.porcentajeDeComision = porcentajeDeComision;

		} catch (Exception NumeroNegativo) {

			System.out.println("La comision ingresada es negativa, vuelva a ingresar la comision");
		}

	}

	/*
	 * @getTotalDeVentas: devuelve el total de ventas de un empleado
	 */

	public double getTotalDeVentas() {

		return this.totalDeVentas;
	}

	/*
	 * @setTotalDeVentas: asigna el total de ventas de un empleado
	 * 
	 * @param totalDeVentas: indica el total de ventas de un empleado
	 */

	public void setTotalDeVentas(int totalDeVentas) {

		try {
			
			if (totalDeVentas < 0) {

				throw new NumeroNegativo("El total de ventas ingresado es negativo, vuelva a ingresar el total de ventas");

			}

			this.totalDeVentas = totalDeVentas;

		} catch (Exception NumeroNegativo) {
			
			System.out.println(NumeroNegativo);

		}
	}

	/*
	 * @setSueldoFijo: asigna el sueldo de un empleado acorde al monto por hora,
	 * la cantidad de horas trabajadas y le suma la comision que obtuvo por sus
	 * ventas
	 */

	public void setSueldoFijo() {

		this.sueldoFijo = ((this.horasTrabajadas * this.montoPorHora)
				+ (this.totalDeVentas * this.porcentajeDeComision / 100));
		
	}

	/*
	 * @getPorcentajeDeComision: devuelve la comision que recibe un empleado por
	 * sus ventas
	 */

	public double getPorcentajeDeComision() {
		return porcentajeDeComision;
	}

	/*
	 * 
	 * @toString: devuelve un String con la informacion del empleado
	 */

	public String toString() {

		return super.toString() + "\nComision: " + this.getPorcentajeDeComision() + "\nVentas: "
				+ this.getTotalDeVentas();
	}

}
