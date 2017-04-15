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
				
				this.dni = dni;
			} catch (Exception DniInvalido) {
				
			}
			
			try{
				
				this.cuil = cuil;				
			} catch(Exception CuilDistintoDelDni) {
							
				if(!(dni.equals(cuil.substring(3, 11)))) {
								
					System.out.println("El cuil ingresado no se corresponde con el dni");
					
					@SuppressWarnings("resource")
					Scanner s = new Scanner(System.in);
					System.out.println("Ingrese el cuil");
					
					this.cuil = s.nextLine();
				}
			} 
			
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
