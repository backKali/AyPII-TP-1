package empresa;
import java.util.HashSet;
import java.util.Iterator;

import trabajador.*;

public class Empresa {

	private HashSet<Trabajador> empleados = new HashSet<Trabajador>();
	
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
		
		Iterator<Trabajador> itr = empleados.iterator();
		while(itr.hasNext()) {
			
			
		}
		
		return 0;
	}
	
	public double calcularSueldoAPagarEmpleado(Trabajador empleado) {
		
		return 0;
	}
	
	public String toString(){
		
		return null;
	}
	
	public static final void main (String[] args) {
		
	}
	
	public void fileWritter(String file) {
		
	}

}
