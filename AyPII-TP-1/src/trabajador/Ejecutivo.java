package trabajador;

import exceptions.CuilDistintoDelDni;
import exceptions.CuilInvalido;
import exceptions.DniInvalido;
import exceptions.NumeroNegativo;

public class Ejecutivo extends Empleado {

	private double premioMonto;
	private boolean premioOtorgado = false;
	private boolean otorgarPremio = false;

	/*
	 * @param dni: dni del empleado
	 * 
	 * @param nombre: aprellido y nombre del empleado
	 * 
	 * @param cuil: el cuil del empleado
	 * 
	 * @param sueldoFijo: indica el sueldo del empleado
	 */

	public Ejecutivo(String dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo, DniInvalido, CuilInvalido, CuilDistintoDelDni {

		super(dni, nombre, cuil, sueldoFijo);

	}

	/*
	 * @otorgarPremio: otorga un premio a un ejecutivo acorde al monto que se le
	 * pasa como parametro
	 * 
	 * @param montoDelPremio: indica el monto del premio a otorgar
	 */

	public void otorgarPremio(double montoDelPremio) {

		/*
		 * El premio debe ser otorgado una sola vez, por ende necesitamos dos
		 * flags: Uno que se fije si alguna vez se entreg� el premio
		 * (premioOtorgado) y otro que haga un seguimiento de la entrega
		 * (otorgarPremio)
		 */
		if (premioOtorgado == false) {

			this.premioMonto = montoDelPremio;

			/*
			 * Cambio el flag de premioOtorgado para que no vuelva a pasar por
			 * este ciclo y tambien otorgarPremio (para que lo entregue esta
			 * vez), Ejecutivo.getSueldoTotal se va encargar de cambiarlo
			 * nuevamente.
			 */
			this.premioOtorgado = !this.premioOtorgado;
			this.otorgarPremio = !this.otorgarPremio;

		}

	}

	/*
	 * @getPremioMonto: devuelve el monto del premio
	 */

	public double getPremioMonto() {

		return this.premioMonto;
	}

	/*
	 * @toString: devuelve un String con la informacion del empleado
	 */

	public String toString() {

		// Chequea si el Ejecutivo ya recibi� el premio
		String seEntregoPremio;
		if (premioOtorgado) {
			seEntregoPremio = "Si";
		} else {
			seEntregoPremio = "No";
		}

		return super.toString() + "\nPremio entregado: " + seEntregoPremio + "\nMonto del Premio: "
				+ this.getPremioMonto();
	}

	/*
	 * @getSueldoTotal(): devuelve el sueldo del ejecutivo
	 */

	public boolean getEstadoPremioAsignado(){
		return this.premioOtorgado;
	}
	
	public double getSueldoTotal() {

		/*
		 * El premio debe ser entregado una sola vez
		 */

		double sueldo = super.getSueldoTotal();
		if (otorgarPremio) {
			sueldo += this.premioMonto;
			otorgarPremio = !otorgarPremio;
		}

		return sueldo;
	}
	
	public double getSueldoFijo(){
		return super.getSueldoTotal();
	}

}
