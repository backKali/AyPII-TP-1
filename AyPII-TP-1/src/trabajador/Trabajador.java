package trabajador;

import java.util.Scanner;

import exceptions.DniInvalido;
import exceptions.CuilInvalido;
import exceptions.CuilDistintoDelDni;
import exceptions.NumeroNegativo;

public class Trabajador {

	protected Integer dni;
	protected String nombre;
	protected Integer cuil;

	/*
	 * @param dni: dni del trabajador
	 * @param nombre: apellido y nombre del trabajador
	 * @param cuil: el cuil del trabajador
	 * 
	 */
	
	public Trabajador(Integer dni, String nombre, Integer cuil) {

			this.nombre = nombre;
		
			try {
				
				this.dni = setDni(dni);
			
			} catch (DniInvalido mensaje) {
				
				System.out.println(mensaje.getMessage());
				
			}
			
			
			try{
				
				this.cuil = setCuil(cuil);
				comparaDniConCuil(dni, cuil);
				
			} catch (CuilInvalido mensaje) {
				
				System.out.println(mensaje.getMessage());
				
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				System.out.println("Ingrese el cuil");
				
				this.cuil = s.nextLine();
				
			} 		
				
		}
	
	private boolean comparaDniConCuil(Integer dni, Integer cuil) throws CuilInvalido {
		
		/*
		 * Convierto ambos numeros a String para poder crear arrays
		 * y compararlos dígito por dígito
		 */
		String cuilConvertido = cuil.toString();
		String dniConvertido = dni.toString();
		
		//Me quedo con la parte del documento del CUIL
		String dniExtraidoDeCuil = cuilConvertido.substring(2,9);
		
		//Creo arrays para la comparación
		char[] arrayDni = dniConvertido.toCharArray();
		char[] arrayCuil = dniExtraidoDeCuil.toCharArray();
		
		/*
		 * Recorro el array de DNI desde la posición de unidad hasta la
		 * unidad o decena de millón. En caso de ser mayor el array del CUIL,
		 * no hace falta comparar el primer dígito, puesto que tiene que ser un 0
		 */
		
		for (int i = arrayDni.length-1; i >= 0; i--){
			if ( arrayDni[i] != arrayCuil[i]){
				throw new CuilInvalido("El CUIL y DNI ingresados no se corresponden");
			}
		}
		
		//
		return true;
		
	}

	private Integer setDni(Integer dni) throws exceptions.DniInvalido {
		
		if (dni <= 1000000 || dni >= 60000000 && dni <= 90000000 || dni > 100000000 ) {
			throw new DniInvalido("El DNI ingresado no es un número válido.");
		}
		
		return dni;
	}
	
	private Integer setCuil(Integer cuil) throws exceptions.CuilInvalido {
		
		//Convierto el número de CUIL a String para poder manejarlo
		String cuilConvertido = cuil.toString();
		
		//Si el número de CUIL no tiene 11 caracteres, es inválido
		if (cuilConvertido.length() != 11) {
			throw new CuilInvalido("El CUIL ingresado es inválido.");
		}
		
		//Me quedo con los primeros dos dígitos para verificar validez
		String primerosDosDigitos = cuilConvertido.substring(0, 1);
		
		/*
		 * Según la entrada "Clave Única de Identificación Tributaria" de Wikipedia, los
		 * valores válidos para Personas Físicas son: 20, 23, 24 y 27
		 * 
		 * Fuente: https://es.wikipedia.org/wiki/Clave_%C3%9Anica_de_Identificaci%C3%B3n_Tributaria
		 */

		if ( primerosDosDigitos != "20" || primerosDosDigitos != "23" || primerosDosDigitos != "24" || primerosDosDigitos != "27"){
			throw new CuilInvalido("El Tipo del CUIL ingresado es inválido. Verifique los dos primeros dígitos");
		}
		
		/*
		 * Tomo el último dígito del CUIL que se ingresó y lo comparo con el
		 * que calculo en el método calculoDigitoVerificador
		 */
		String ultimoDigitoIngresado = cuilConvertido.substring(10);
		Integer ultimoDigitoCalculado = calculoDigitoVerificador(cuilConvertido);
		
		if ( ultimoDigitoIngresado != ultimoDigitoCalculado.toString() ){
			throw new CuilInvalido("El dígito de verificación del CUIL ingresado es inválido. Verifique el último dígito");
		}
		
		/*
		 * El CUIL ingresado es válido, lo convierto a String,
		 * le agrego los guiones y lo devuelvo.
		 */
		return cuil;
		
		/*
		 * Util para cuando tengamos que mostrar el numero de CUIL
		 * en algún reporte:
		 * return ( primerosDosDigitos + "-" + cuilConvertido.substring(2,9) + "-" + ultimoDigitoIngresado);
		 */
		
	}
	
	private Integer calculoDigitoVerificador(String cuilConvertido) {
		/*
		 * Basado en las entradas "Clave Única de Identificación Tributaria"
		 * y "Módulo 11" encontradas en Wikipedia:
		 * 
		 * - https://es.wikipedia.org/wiki/Clave_%C3%9Anica_de_Identificaci%C3%B3n_Tributaria
		 * - https://es.wikipedia.org/wiki/C%C3%B3digo_de_control
		 * 
		 */
		
		int[] arrayFactor = new int[] {3,2,7,6,5,4,3,2};
		char[] arrayCuil = cuilConvertido.toCharArray();
		Integer cuilCalculado = 0;
		
		/*
		 * Se multiplica el valor del CUIL en posición i con el factor en posicion i
		 * y se suman los reultados.
		 */
		for (int i = 0; i < 10; i++){
			cuilCalculado += Character.getNumericValue(arrayCuil[i]) * arrayFactor[i];
		}
		
		//A 11 se le resta el resto de cuilCalculado / 11 
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
		
		return cuilCalculado;
	}

	/*
	 * @getDni: devuelve el dni del trabajador
	 */
	public Integer getDni() {

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
	
	public Integer getCuil() {

		return this.cuil;
	}

}