package empresa;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import trabajador.*;

public class Empresa {

	private HashSet<Trabajador> empleados = new HashSet<Trabajador>();
	private Trabajador[] arrayDeEmpleados;
	
	public Empresa() {
		
	}
	
	/*
	 * @contratarEmpleado: la empresa contrata un empleado
	 * @param empleado: el empleado a contratar
	 */
	
	public void contratarEmpleado(Trabajador empleado) {
		
		if(empleados.contains(empleado) == true) {
			empleados.add(empleado);
		}		
	}
	
	/*
	 * @despedirEmpleado: la empresa despide a un empleado
	 * @param empleado: el empleado a despedir
	 */
	
	public void despedirEmpleado(Trabajador empleado) {
		
		if(empleados.contains(empleado) == true) {
			empleados.remove(empleado);
		}
	}
	

	 //Hay que terminar de aca en adelante
	
	/*
	 * @calcularTotalAPagar: devuelve la suma del sueldo de todos los empleados
	 */
	
	//No se si esto es necesario
	
	public double calcularTotalAPagar() {
		
		double totalAPagar = 0;
		
		Iterator<Trabajador> itr = empleados.iterator();
		while(itr.hasNext()) {
			itr.next();
					
		}
		
		return totalAPagar;
	}
	
	/*
	 * @calcularSueldoAPagarEmpleado: devuelve cuanto 
	 * tiene que pagarle la empresa a un empleado
	 * @param empleado: empleado al que se le va a pagar el sueldo
	 */
	
	public double calcularSueldoAPagarEmpleado(Trabajador empleado) {
		
		return ((Remunerado) empleado).getSueldoTotal();
	}
	
	/*
	 * @main: inicia el menu interactivo
	 */
	
	public static void main (String[] args) {
		
	}
	
	/*
	 * @fileWriter: crea un archivo con toda la informacion 
	 * de los empleados que posee la empresa
	 */
	
	public void fileWritter(String file) {
		
	}
	
	/*
	 * @hashToArray: convirte el hashSet en un array
	 */
	
	@SuppressWarnings("unused")
	private void hashToArray() {
		
		arrayDeEmpleados = empleados.toArray(new Trabajador[empleados.size()]); 				
	}
	
	/*
	 * @sortArray: ordena el array acorde al compareTo de Remunerado
	 */
	
	@SuppressWarnings("unused")
	private void sortArray() {
		
		Arrays.sort(arrayDeEmpleados);
	}


}
