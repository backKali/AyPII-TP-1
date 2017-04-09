package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHoras extends Trabajador {
	
	private int horasTrabajadas;
	private double montoPorHora;
	private double sueldoFijo;

	public EmpleadoPorHoras(int dni, String nombre, String cuil, double montoPorHora) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		try{
			
			this.montoPorHora = montoPorHora;
		} catch (Exception NumeroNegativo) {
			
			if (montoPorHora >= 0) {
				throw new NumeroNegativo("El monto ingresado es menor a cero, ingrese nuevamente el monto");
			}	
		}
		
	}

	public int getHorasTrabajadas() {
		
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getMontoPorHora() {
		
		return this.montoPorHora;
	}

	public void setSueldoFijo() {
		
		this.sueldoFijo = (this.montoPorHora * this.horasTrabajadas);
	}
	
	public double getSueldoTotal() {
		
		return this.sueldoFijo;
	}

}
