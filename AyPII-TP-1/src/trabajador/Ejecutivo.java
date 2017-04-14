package trabajador;



public class Ejecutivo extends Empleado {

	private boolean premioOtorgado = false;
	private double premioMonto;
	
	public Ejecutivo(String dni, String nombre, String cuil, double sueldoFijo) {
		
		super(dni, nombre, cuil, sueldoFijo);
		
	}
	
	
	public void otorgarPremio(double montoDelPremio) {
		
		if(premioOtorgado == false) {
			
			this.premioMonto = montoDelPremio;
			this.sueldoFijo += this.premioMonto;
			this.premioOtorgado = true;
		}
	}
	
	public double getPremioMonto() {
		
		return this.premioMonto;
	}
	
	@Override
	public String toString() {
		
		return super.toString()+ "Monto del Premio: "+this.getPremioMonto();
	}
	

}
