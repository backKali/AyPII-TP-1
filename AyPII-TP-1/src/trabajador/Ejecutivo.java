package trabajador;

import exceptions.NumeroNegativo;

public class Ejecutivo extends Trabajador {

	private boolean premioOtorgado = false;
	private double premioMonto;
	private double sueldoFijo;
	
	public Ejecutivo(int dni, String nombre, String cuil, double sueldoFijo) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		try {
			
			this.sueldoFijo = sueldoFijo;
		} catch (Exception NumeroNegativo) {
			
			if(sueldoFijo <= 0) {
				
				throw new NumeroNegativo("El monto ingresado es menor a cero, ingrese nuevamente el monto");
			}	
		}
	}
	
	public double getSueldoFijo() {
		
		return this.sueldoFijo;
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
