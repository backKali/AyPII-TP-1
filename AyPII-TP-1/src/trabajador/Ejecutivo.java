package trabajador;

import exceptions.NumeroNegativo;

public class Ejecutivo extends Empleado {

	private boolean premioOtorgado = false;
	private double premioMonto;
	
	public Ejecutivo(int dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {
		
		super(dni, nombre, cuil, sueldoFijo);
		
	}
	
	
	public void otorgarPremio(double montoDelPremio) {
		
		if(premioOtorgado == false) {
			
			this.premioMonto = montoDelPremio;
			this.premioOtorgado = true;
		}
	}
	
	public double getPremioMonto() {
		
		return this.premioMonto;
	}
	
	public double getSueldoTotal() {
		
		return (this.premioMonto + this.sueldoFijo);
	}

}
