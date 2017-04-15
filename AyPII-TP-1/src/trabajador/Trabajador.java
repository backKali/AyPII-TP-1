package trabajador;

import java.util.Scanner;

import exceptions.DniInvalido;
import exceptions.CuilInvalido;
import exceptions.CuilDistintoDelDni;
import exceptions.NumeroNegativo;

public class Trabajador {

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
			
			ingresoDni(dni);
			
			try{
				
				this.cuil = setCuil(cuil);	
				
			} catch (java.lang.Error | CuilInvalido mensaje) {
				
				System.out.println(mensaje.getMessage());
				
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				System.out.println("Ingrese el CUIL:");
				
				this.cuil = s.nextLine();
				
			}
				
	}
	
	private void ingresoDni(String dni) {
		
		try {
			
			this.dni = setDni(dni);
		
		} catch (java.lang.Error mensaje) {
			
			System.out.println("El valor ingresado no era del Tipo esperado");
			
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Ingrese el DNI:");
			
			String nuevoDni = s.nextLine();

			ingresoDni(nuevoDni);
					
		} catch (DniInvalido mensaje){
			
			System.out.println(mensaje.getMessage());
			
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Ingrese el DNI:");
			
			String nuevoDni = s.nextLine();

			ingresoDni(nuevoDni);
			
		} catch (java.lang.NumberFormatException mensaje){
			
			System.out.println("El valor ingresado no contenía números");
			
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Ingrese el DNI:");
			
			String nuevoDni = s.nextLine();

			ingresoDni(nuevoDni);
			
		}
		
	}

	private boolean dniYCuilSonIguales(String dni, String cuil) throws CuilInvalido {
		
		//Inicializo variable booleana
		boolean sonIguales = true;
		
		/*
		 * Tomo la parte del numero de DNI del CUIL
		 */
		String dniExtraidoDelCuil = cuil.substring(3,11);
		
		/*
		 * Paso el DNI a ocho caracteres para, en caso de ser uno
		 * de 7, hacer la comparacion contra el CUIL completo 
		 */
		if (dni.length() == 7) {
			dni = "0" + dni;
		}
		
		//Creo arrays para la comparación
		char[] arrayDni = dni.toCharArray();
		char[] arrayCuil = dniExtraidoDelCuil.toCharArray();
		
		/*
		 * Recorro el array de DNI desde la posición de unidad
		 * hasta la decena de millón. Si alguna posición -cualquiera sea-
		 * es dinstinta, los números no son iguales.
		 */
		for (int i = arrayDni.length-1; i >= 0 && arrayDni[i] == arrayCuil[i] ; i--){
			if ( arrayDni[i] != arrayCuil[i] ){
				sonIguales = !sonIguales;
			}
		}
		
		return sonIguales;
		
	}

	private String setDni(String dni) throws DniInvalido {
		
		/*
		 * Saco las comillas del String y convierto
		 * el String del DNI a Integer para poder operar
		 */
		Integer DniNumerico = Integer.parseInt(dni.replaceAll("[^\\d]", ""));
		
		if ( DniNumerico <= 1000000 || DniNumerico >= 60000000 && DniNumerico <= 90000000 || DniNumerico > 99999999 ) {
			throw new DniInvalido("El DNI ingresado no es un número válido.");
		} 
		
		//Retorno el DNI que solo contiene numeros (en caso que haya habido alguno)
		return dni.replaceAll("[^\\d]", "");
	}
	
	private String setCuil(String cuil) throws CuilInvalido {

		//Le saco los caracteres no numéricos al CUIL para poder manejarlo
		String cuilSoloNumeros = cuil.replaceAll("[^\\d]", "");
		
		//Si el número de CUIL no tiene 11 caracteres, es inválido
		if (cuilSoloNumeros.length() != 11) {
			throw new CuilInvalido("El CUIL ingresado es inválido.");
		}
		
		//Me quedo con los primeros dos dígitos para verificar validez
		String primerosDosDigitos = cuilSoloNumeros.substring(0, 2);

		/*
		 * Según la entrada "Clave Única de Identificación Tributaria" de Wikipedia, los
		 * valores válidos para Personas Físicas son: 20, 23, 24 y 27
		 * 
		 * Fuente: https://es.wikipedia.org/wiki/Clave_%C3%9Anica_de_Identificaci%C3%B3n_Tributaria
		 */
		if ( !primerosDosDigitos.equals("20") && !primerosDosDigitos.equals("23")
				&& !primerosDosDigitos.equals("24") && !primerosDosDigitos.equals("27") ){
			throw new CuilInvalido("El Tipo del CUIL ingresado es inválido. Verifique los dos primeros dígitos");
		}
		
		/*
		 * Tomo el último dígito del CUIL que se ingresó y lo comparo con el
		 * que calculo en el método calculoDigitoVerificador
		 */
		String ultimoDigitoIngresado = cuilSoloNumeros.substring(10);
		String ultimoDigitoCalculado = calculoDigitoVerificador(cuilSoloNumeros.substring(0,10));
		
		if ( !ultimoDigitoIngresado.equals(ultimoDigitoCalculado) ){
			throw new CuilInvalido("El dígito de verificación del CUIL ingresado es inválido. Verifique el último dígito");
		}
		
		/*
		 * El CUIL ingresado es válido, lo convierto a String,
		 * le agrego los guiones y lo devuelvo.
		 */
		
		if (!dniYCuilSonIguales(dni, cuil)){
			throw new CuilInvalido("El CUIL y DNI ingresados no se corresponden");
		}
		
		return ( primerosDosDigitos + "-" + cuilSoloNumeros.substring(2,10) + "-" + ultimoDigitoIngresado);		
	}
	
	private String calculoDigitoVerificador(String cuilSoloNumeros) {
		/*
		 * Basado en las entradas "Clave Única de Identificación Tributaria"
		 * y "Módulo 11" encontradas en Wikipedia:
		 * 
		 * - https://es.wikipedia.org/wiki/Clave_%C3%9Anica_de_Identificaci%C3%B3n_Tributaria
		 * - https://es.wikipedia.org/wiki/C%C3%B3digo_de_control
		 * 
		 */
		int[] arrayFactor = new int[] {5,4,3,2,7,6,5,4,3,2};
		char[] arrayCuil = cuilSoloNumeros.toCharArray();
		Integer cuilCalculado = 0;
		
		/*
		 * Se multiplica el valor del CUIL en posición i con el factor en posicion i
		 * y se suman los reultados.
		 */
		for (int i = 0; i < 10; i++){
			cuilCalculado += Character.getNumericValue(arrayCuil[i]) * arrayFactor[i];
		}
		
		//A 11 se le quita el resto de cuilCalculado / 11
		cuilCalculado = 11 - (cuilCalculado % 11);
		
		/*
		 * Se debe devolver un solo caracter. Para los casos donde
		 * cuilCalculado = 11 o cuilCalculado = 10, se cambia a 1 y 0 respectivamente.
		 */
		if (cuilCalculado == 11){
			cuilCalculado = 0;
		} else if (cuilCalculado == 10){
			cuilCalculado = 1;
		}
		
		return String.valueOf(cuilCalculado);
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

}