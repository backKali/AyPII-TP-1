package trabajador;

import exceptions.CuilDistintoDelDni;
import exceptions.CuilInvalido;
import exceptions.DniInvalido;

public class Voluntario extends Trabajador {
	
	/*
	 * @param dni: dni del empleado
	 * @param nombre: aprellido y nombre del empleado
	 * @param cuil: el cuil del empleado
	 */

	public Voluntario(String dni, String nombre, String cuil) throws DniInvalido, CuilInvalido, CuilDistintoDelDni {
		
		super(dni, nombre, cuil);
	}
	
}
