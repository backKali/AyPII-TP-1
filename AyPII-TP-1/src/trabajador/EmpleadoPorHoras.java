package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHoras extends Empleado {

	protected double horasTrabajadas;
	protected double montoPorHora;

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
	 */
	
	public EmpleadoPorHoras(String dni, String nombre, String cuil, double montoPorHora) throws NumeroNegativo{

		super(dni, nombre, cuil);

		try {
			
			if (montoPorHora < 0){
				throw new NumeroNegativo("La cantidad de horas es negativa, vuelva a ingresar las horas");
			} else {

			this.montoPorHora = montoPorHora;
			}
			
		} catch (NumeroNegativo mensaje) {

			System.out.println(mensaje);
		}

	}


	/*
	 * post: devuelve la cantida de horas trabajadas
	 */

	public double getHorasTrabajadas() {

		return this.horasTrabajadas;
	}

	/*
	 * @setHorasTrabajadas: asigna la cant de horas que trabajo un empleado
	 * 
	 * @param horasTrabajadas: indica la cantidad de horas que el empleado
	 * trabajo
	 */

	public void setHorasTrabajadas(double horasTrabajadas) {

		this.horasTrabajadas = horasTrabajadas;
	}

	/*
	 * @getMontoPorHora: devuelve cuanto se le paga a un empleado por hora
	 */

	public double getMontoPorHora() {

		return this.montoPorHora;
	}

	/*
	 * @setSueldoFijo: asigna el sueldo del empleado, acorde al monto por hora y
	 * la cantidad de horas trabajadas
	 */

	public void setSueldoFijo() {

		this.sueldoFijo = (this.montoPorHora * this.horasTrabajadas);
	}

	/*
	 *
	 * @toString: devuelve un String con la informacion del empleado
	 */

	public String toString() {

		return super.toString() + "\nHoras trabajadas: " + this.getHorasTrabajadas() + "\nMonto por hora: "
				+ this.getMontoPorHora();
	}

}
