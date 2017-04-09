package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHorasAComision extends Trabajador {

	private double porcentajeDeComision;
	private double totalDeVentas;
	private int horasTrabajadas;
	private double montoPorHora;
	private double sueldoFijo;

	public EmpleadoPorHorasAComision(int dni, String nombre, String cuil, double porcentajeDeComision,
			double montoPorHora) throws NumeroNegativo {

		super(dni, nombre, cuil);
		try {
			
			this.porcentajeDeComision = porcentajeDeComision;
			this.montoPorHora = montoPorHora;
		} catch (Exception NumeroNegativo) {
			
			if(porcentajeDeComision <= 0) {
				
				throw new NumeroNegativo("El porcentaje ingresado es negativo, vuelva a ingresar el porcentaje");
			}
			if(montoPorHora <= 0) {
				
				throw new NumeroNegativo("El monto ingresado no esta permitido, vuelva a ingresar el monto");
			}
		}
	}
	
	public void setHorasTrabajadas(int horasTrabajadas) throws NumeroNegativo {
		
		try {
			
			this.horasTrabajadas = horasTrabajadas;
		} catch (Exception NumeroNegativo) {
			
			if(horasTrabajadas <= 0){
				
				throw new NumeroNegativo("La cant. de horas es invalida, vuelva a ingresar las horas trabajadas");
			}
		}
	}
	
	public int getHorasTrabajadas() {
		
		return this.horasTrabajadas;
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
