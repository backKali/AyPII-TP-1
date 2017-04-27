package empresa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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

	public double calcularSueldoAPagarEmpleado(Trabajador empleado) {

		return ((Empleado) empleado).getSueldoTotal();
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

		
		//Creo el FileWriter
		FileWriter escritor = new FileWriter(file);
		
		/*
		 * Recorro el HashSet con todos los trabajadores (si hay
		 * que hacerlo ordenado, podemos convertirlo en SortedList
		 * con el m�todo hashToArrayList
		 */
//		for (Trabajador trabajador : empleados) {
//
//			//Escribo los trabajadores en el archivo que se haya pasado
//			escritor.write(trabajador.toString()+"\n"+"\n");			
//		}
//
//		HAY QUE PROBAR SI ESTO CON ESTO FUNCIONA
//		SI FUNCIONA LO CAMBIAMOS POR EL for each
		
		//Convirtiendo el Hash a Array antes de iterarlo, goes like a punch ;)
		hashToArrayList();
		
		Iterator<Trabajador> itr = sortedList.iterator(); 
		 	while(itr.hasNext()) {
		 		
		 		escritor.write(itr.next().toString()+"\n"+"\n");
		 }
		

		//Cierro el archivo
		escritor.close();

	}
	

	/*
	 * @hashToArray: convirte el HashSet en un ArrayList
	 */

	public void hashToArrayList() {

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
