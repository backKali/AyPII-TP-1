package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHorasAComision extends EmpleadoPorHoras {

	private double porcentajeDeComision;
	public double getPorcentajeDeComision() {
		return porcentajeDeComision;
	}

	private double totalDeVentas;

	public EmpleadoPorHorasAComision(String dni, String nombre, String cuil, double porcentajeDeComision,
			double montoPorHora) throws NumeroNegativo {

		super(dni, nombre, cuil, montoPorHora);
		
		try {
			
			
		} catch (Exception NumeroNegativo) {
			
			System.out.println("La comision ingresada es negativa, vuelva a ingresar la comision");
		}
		
	}
	
	public double getTotalDeVentas() {
		
		return this.totalDeVentas;
	}
	
	public void setTotalDeVentas(int totalDeVentas) throws NumeroNegativo {
		
		try {
			
			this.totalDeVentas = totalDeVentas;
		} catch (Exception NumeroNegativo){
			
			if(totalDeVentas <= 0) {
				
				throw new NumeroNegativo("El total de ventas ingresado es negativo, vuelva a ingresar el total de ventas");
			}
		}
	}
	
	
	
	public void setSueldoFijo() {
		
		this.sueldoFijo = ((this.horasTrabajadas * this.montoPorHora) + (this.totalDeVentas * this.porcentajeDeComision /100));
	}
	
	@Override
	public String toString() {
		
		return super.toString() +"Comision: "+this.getPorcentajeDeComision() +"Ventas: "+this.getTotalDeVentas();
	}
	
}
