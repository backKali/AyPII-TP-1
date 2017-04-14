package trabajador;

import exceptions.NumeroNegativo;

public class EmpleadoPorHoras extends Remunerado {
	
	protected int horasTrabajadas;
	protected double montoPorHora;

	public EmpleadoPorHoras(String dni, String nombre, String cuil, double montoPorHora) throws NumeroNegativo {
		
		super(dni, nombre, cuil);
		
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
	
	@Override
	public String toString() {
		
		return super.toString()+ "Horas trabajadas: "+this.getHorasTrabajadas()+ "Monto por hora: "+this.getMontoPorHora();
	}
	

}
