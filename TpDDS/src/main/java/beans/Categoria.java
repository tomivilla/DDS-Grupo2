package beans;

public class Categoria {

	// Atributos
	private String categoria;
	private String unidad;
	private double cargoFijo;
	private double cargoVariable;
	
	public Categoria() {
		
	}

	public Categoria(String categoria, String unidad, double cargoFijo, double cargoVariable) {
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
		this.categoria = categoria;
		this.unidad = unidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	public void calcularCategoria(double consumoMensual) {
	    	
		if(consumoMensual < 150) {
			this.categoria = "R1"; 
			this.cargoFijo = 18.76; 
			this.cargoVariable = 18.76;
		}
		if(150 < consumoMensual && consumoMensual<=325) {
			this.categoria = "R2"; 
			this.cargoFijo = 35.32; 
			this.cargoVariable = 0.644;
		}
		if(325 < consumoMensual && consumoMensual<=400) {
			this.categoria = "R3"; 
			this.cargoFijo = 60.71; 
			this.cargoVariable = 0.644;
		}
		if(400 < consumoMensual && consumoMensual<=450) {
			this.categoria = "R4"; 
			this.cargoFijo = 71.74; 
			this.cargoVariable = 0.738;
		}		
		if(450 < consumoMensual && consumoMensual<=500) {
			this.categoria = "R5"; 
			this.cargoFijo = 110.38; 
			this.cargoVariable = 0.794;
		}
		if(500 < consumoMensual && consumoMensual<=600) {
			this.categoria = "R6"; 
			this.cargoFijo = 220.75; 
			this.cargoVariable = 0.832;
		}
		if(600 < consumoMensual && consumoMensual<=700) {
			this.categoria = "R7"; 
			this.cargoFijo = 443.59; 
			this.cargoVariable = 0.851;
		}
		if(700 < consumoMensual && consumoMensual<=1400) {
			this.categoria = "R8"; 
			this.cargoFijo = 545.96; 
			this.cargoVariable  = 0.851;
		}
		if(consumoMensual > 1400) {
			this.categoria = "R9"; 
			this.cargoFijo = 887.19; 
			this.cargoVariable = 0.851;
		}
		
	}
	
	
}
