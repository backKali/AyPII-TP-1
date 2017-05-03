package trabajador;

import java.util.Scanner;

import exceptions.CuilDistintoDelDni;
import exceptions.CuilInvalido;
import exceptions.DniInvalido;

public class Trabajador implements Comparable<Trabajador> {

	protected String dni;
	protected String nombre;
	protected String cuil;

	/*
	 * @param dni: dni del trabajador
	 * 
	 * @param nombre: apellido y nombre del trabajador
	 * 
	 * @param cuil: el cuil del trabajador
	 * 
	 */

	public Trabajador(String dni, String nombre, String cuil) throws DniInvalido, CuilDistintoDelDni, CuilInvalido{

		boolean huboErrores = false;
		
		this.nombre = nombre;

		if (!isNumber(dni) || (dni.length() < 7 || dni.length() > 8)) {
			
			huboErrores = !huboErrores;
			throw new DniInvalido("El DNI ingresado no es válido");
				
		} else if (dni.length() == 7) {
				
			dni = "0" + dni;
				
		}
			
		this.dni = dni;

		/*
		 * Agrego verificacion por si solo se ingresaron numeros (sin los guiones)
		 * ------------------------
		 * Si son todos numeros y el length es 11, le agrego los guiones para
		 * unificar y que quede mas prolijo
		 */
		boolean cantidadCaracteresCuil = cuil.length() == 11 || cuil.length() == 13;
		
		if (!cantidadCaracteresCuil && !huboErrores){
			huboErrores = !huboErrores;
			throw new CuilInvalido("El CUIL ingresado no es valido");
		}
		
		if (isNumber(cuil) && cuil.length() == 11 && !huboErrores){
			cuil = cuil.substring(0, 2) + "-" + cuil.substring(2,10) + "-" + cuil.substring(10,11);
		}
		
		if (!huboErrores){
		
			boolean sonNumeros = isNumber(cuil.substring(0, 2)) && isNumber(cuil.substring(3, 11)) && isNumber(cuil.substring(12, 13));
		
			if (!sonNumeros) {
				
				huboErrores = !huboErrores;
				throw new CuilInvalido("El CUIL ingresado no es valido");

			}
		}
		
		/*
		 * Hay que hacer test para ver si los numeros
		 * donde se corta el string estan bien
		 * 
		 * Actualizacion: Se hicieron tests durante ejecucion y cambiaron substrings
		 */
		
		//Genero la variable local sonNumeros para evaluarla despues
		if (!dni.equals(cuil.substring(3, 11)) && !huboErrores) {

			throw new CuilDistintoDelDni("El CUIL ingresado no se corresponde con el DNI");
		
		}
		
		this.cuil = cuil;
		
	}

	/*
	 * @isNumber: verifica si el String esta formado por numeros
	 * 
	 * @param string: String a verificar
	 */

	public static boolean isNumber(String string) {

		if (string == null || string.isEmpty()) {

			return false;
		}
		int i = 0;
		if (string.charAt(0) == '-') {

			if (string.length() > 1) {
				i++;
			} else {
				return false;
			}
		}
		for (; i < string.length(); i++) {

			if (!Character.isDigit(string.charAt(i))) {

				return false;
			}
		}

		return true;
	}

	/*
	 * @getDni: devuelve el dni del trabajador
	 */

	public String getDni() {

		return this.dni;
	}

	/*
	 * @getNombre: devuelve el nombre y apellido del trabajador
	 */

	public String getNombre() {

		return this.nombre;
	}

	/*
	 * @getCuil: devuelve el cuil del trabajador
	 */

	public String getCuil() {

		return this.cuil;
	}

	/*
	 * @toString: devuelve un String con la informacion del empleado
	 */

	public String toString() {

		return "Nombre: " + this.getNombre() + "\nCUIL: " + this.getCuil() + "\nDNI: " + this.getDni() + "\nTipo de Empleado: " + this.getClass().getSimpleName() ;
	}

	@Override
	public int compareTo(Trabajador o) {

		return 0;
	}

}
