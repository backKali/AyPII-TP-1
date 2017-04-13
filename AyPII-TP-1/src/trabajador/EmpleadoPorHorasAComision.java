package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHorasAComision extends EmpleadoPorHoras {

	private double porcentajeDeComision;
	private double totalDeVentas;

	public EmpleadoPorHorasAComision(int dni, String nombre, String cuil, double porcentajeDeComision,
			double montoPorHora) throws NumeroNegativo {

		super(dni, nombre, cuil, montoPorHora);
		
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
	
	public double getTotalDeVentas() {
		
		return this.totalDeVentas;
	}
	
	public void setSueldoFijo() {
		
		this.sueldoFijo = ((this.horasTrabajadas * this.montoPorHora) + (this.totalDeVentas * this.porcentajeDeComision /100));
	}

	public double getSueldoTotal() {
		
		return this.sueldoFijo;
	}

}
