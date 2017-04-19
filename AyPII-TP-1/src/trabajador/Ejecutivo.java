package trabajador;



public class Ejecutivo extends Empleado {

	private boolean premioOtorgado = false;
	private double premioMonto;
	
	/*
	 * @param dni: dni del empleado
	 * @param nombre: aprellido y nombre del empleado
	 * @param cuil: el cuil del empleado
	 * @param sueldoFijo: indica el sueldo del empleado
	 */
	
	public Ejecutivo(String dni, String nombre, String cuil, double sueldoFijo) {
		
		super(dni, nombre, cuil, sueldoFijo);
		
	}
	
	/*
	 * @otorgarPremio: otorga un premio a un ejecutivo 
	 * acorde al monto que se le pasa como parametro
	 * @param montoDelPremio: indica el monto del premio a otorgar
	 */
	
	public void otorgarPremio(double montoDelPremio) {
		
		if(premioOtorgado == false) {
			
			this.premioMonto = montoDelPremio;
			this.sueldoFijo += this.premioMonto;
			this.premioOtorgado = true;
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
		
		return super.toString()+ "Monto del Premio: "+this.getPremioMonto();
	}
	

}
