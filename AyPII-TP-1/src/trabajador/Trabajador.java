package trabajador;

import java.util.Scanner;

public class Trabajador implements Comparable<Trabajador> {

	protected String dni;
	protected String nombre;
	protected String cuil;

	/*
	 * @param dni: dni del trabajador
	 * @param nombre: apellido y nombre del trabajador
	 * @param cuil: el cuil del trabajador
	 * 
	 */
	
	public Trabajador(String dni, String nombre, String cuil) {

			this.nombre = nombre;
		
			try {
				if (isNumber(dni)) {
					
					this.dni = dni;
				}
			} catch (Exception DniInvalido) {
				
			}
			
			try{
				 //Hay que hacer test para ver si los numeros
				 // donde se corta el string estan bien
				if (isNumber(cuil.substring(0,1)) && isNumber(cuil.substring(3, 8)) && isNumber(cuil.substring(10, 10))) {
				
					this.cuil = cuil;	
				}
			} catch(Exception CuilDistintoDelDni) {
							
				if(!(dni.equals(cuil.substring(3, 8)))) {
								
					System.out.println("El cuil ingresado no se corresponde con el dni");
					
					@SuppressWarnings("resource")
					Scanner s = new Scanner(System.in);
					System.out.println("Ingrese el cuil");
					
					this.cuil = s.nextLine();
				}
			} 
			
	}
	
	/*
	 * @isNumber: verifica si el String esta formado por numeros
	 * @param string: String a verificar
	 */
	
	public static boolean isNumber(String string) {
		
		if(string == null || string.isEmpty()) {
			
			return false;
		}
		int i = 0;
		if (string.charAt(0) == '-') {
			
			if(string.length() > 1) {
				i++;
			} else {
				return false;
			}
		}
		for (; i < string.length(); i++) {
			
			if(!Character.isDigit(string.charAt(i))) {
				
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

	@Override
	public int compareTo(Trabajador o) {
		
		return 0;				
	}


}
