package trabajador;

import exceptions.NumeroNegativo;

public class Trabajador {

	private int dni;
	private String nombre;
	private String cuil;

	/*
	 * @param dni, dni del trabajador
	 * @param nombre, aprellido y nombre del trabajador
	 * @param cuil, el cuil del trabajador
	 * 
	 */
	
	public Trabajador(int dni, String nombre, String cuil) throws NumeroNegativo {


		try {
			this.dni = dni;
			this.nombre = nombre;
			this.cuil = cuil;

		} catch (Exception NumeroNegativo) {

			if(dni <= 0) {
				
				throw new NumeroNegativo("El DNI ingresaso no es valido, inserte nuevamente el DNI");
			}
		}
	}
	
	/*
	 * @getDni devuelve el dni del trabajador
	 */

	public int getDni() {

		return this.dni;
	}

	/*
	 * @getNombre devuelve el nombre y apellido del trabajador
	 */
	
	public String getNombre() {

		return this.nombre;
	}

	/*
	 * @getCuil devuelve el cuil del trabajador
	 */
	
	public String getCuil() {

		return this.cuil;
	}

}
