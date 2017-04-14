package trabajador;


public class Trabajador {

	protected String dni;
	protected String nombre;
	protected String cuil;

	/*
	 * @param dni, dni del trabajador
	 * @param nombre, apellido y nombre del trabajador
	 * @param cuil, el cuil del trabajador
	 * 
	 */
	
	public Trabajador(String dni, String nombre, String cuil) {

			this.dni = dni;
			this.nombre = nombre;
			this.cuil = cuil;

	}
	
	/*
	 * @getDni devuelve el dni del trabajador
	 */

	public String getDni() {

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
