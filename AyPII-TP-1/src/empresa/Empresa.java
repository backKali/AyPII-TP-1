package empresa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import trabajador.*;

public class Empresa {

	private static HashSet<Trabajador> empleados = new HashSet<Trabajador>();
	private static ArrayList<Trabajador> sortedList = new ArrayList<>();
	
	public Empresa() {
		
	}

	/*
	 * @contratarEmpleado: la empresa contrata un empleado
	 * 
	 * @param empleado: el empleado a contratar
	 */

	public void contratarEmpleado(Trabajador empleado) {

		if (!empleados.contains(empleado)) {
			empleados.add(empleado);
		}
	}

	/*
	 * @despedirEmpleado: la empresa despide a un empleado
	 * 
	 * @param empleado: el empleado a despedir
	 */

	public void despedirEmpleado(Trabajador empleado) {

		if (empleados.contains(empleado)) {
			empleados.remove(empleado);
		}
	}

	// Hay que terminar de aca en adelante

	/*
	 * @calcularSueldoAPagarEmpleado: devuelve cuanto tiene que pagarle la
	 * empresa a un empleado
	 * 
	 * @param empleado: empleado al que se le va a pagar el sueldo
	 */

	public double calcularSueldoAPagarEmpleado(Empleado empleado) {
		
		return ((Empleado)empleado).getSueldoTotal();

	}

	/*
	 * @main: inicia el menu interactivo
	 */

	public static void main(String[] args) {
		
			try {
				EmpresaGUI window = new EmpresaGUI();
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		}
		
	/*
	 * @fileWriter: crea un archivo con toda la informacion de los empleados que
	 * posee la empresa
	 */

	// Hay que hacer tests de esto
	
	public void fileWriter(String file) throws IOException {
		//Convirtiendo el Hash a Array antes de iterarlo
		hashToArrayList();
		
		//Creo el FileWriter
		FileWriter escritor = new FileWriter(file);

		//Uso el iterador para recorrer el listado de Trabajadores
		Iterator<Trabajador> iteradorTrabajadores = sortedList.iterator(); 
		 	while(iteradorTrabajadores.hasNext()) {
		 		
		 		escritor.write(iteradorTrabajadores.next().toString()+"\n"+"\n");
		 }

		//Cierro el archivo
		escritor.close();

	}
	

	/*
	 * @hashToArray: convirte el HashSet en un ArrayList
	 */

	private void hashToArrayList() {

		sortedList = new ArrayList<Trabajador>(empleados);
		sortArray();
	}

	/*
	 * @sortArray: ordena el ArrayList acorde al compareTo de Remunerado
	 */

	private void sortArray() {

		Collections.sort(sortedList);
	}

}
