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
	
	public void contratarEmpleado(Trabajador empleado) {
		
		if(empleados.contains(empleado) == true) {
			empleados.add(empleado);
		}		
	}
	
	public void despedirEmpleado(Trabajador empleado) {
		
		if(empleados.contains(empleado) == true) {
			empleados.remove(empleado);
		}
	}
	
	/*
	 * Hay que terminar de aca en adelante
	 */
	
	public double calcularTotalAPagar() {
		
		double totalAPagar = 0;
		
		Iterator<Trabajador> itr = empleados.iterator();
		while(itr.hasNext()) {
			itr.next();
					
		}
		
		return totalAPagar;
	}
	
	public double calcularSueldoAPagarEmpleado(Trabajador empleado) {
		
		return ((Remunerado) empleado).getSueldoTotal();
	}
	
	
	public static void main (String[] args) {
		
	}
	
	public void fileWritter(String file) {
		
	}
	
	private void hashToArray() {
		
		arrayDeEmpleados = empleados.toArray(new Trabajador[empleados.size()]); 				
	}
	
	private void sortArray() {
		
		Arrays.sort(arrayDeEmpleados);
	}


}
