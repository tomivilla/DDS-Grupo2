package beans;

public class Categoria {

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




	public Categoria calcularCategoria(double consumoMensual) {
	    Categoria cat = new Categoria();	
		if(consumoMensual < 150) {
			cat.setCategoria("R1"); 
			cat.setCargoFijo(18.76); 
			cat.setCargoVariable(18.76);
		}
		if(150 < consumoMensual && consumoMensual<=325) {
			cat.setCategoria("R2"); 
			cat.setCargoFijo(35.32); 
			cat.setCargoVariable(0.644);
		}
		if(325 < consumoMensual && consumoMensual<=400) {
			cat.setCategoria("R3"); 
			cat.setCargoFijo(60.71); 
			cat.setCargoVariable(0.644);
		}
		if(400 < consumoMensual && consumoMensual<=450) {
			cat.setCategoria("R4"); 
			cat.setCargoFijo(71.74); 
			cat.setCargoVariable(0.738);
		}		
		if(450 < consumoMensual && consumoMensual<=500) {
			cat.setCategoria("R5"); 
			cat.setCargoFijo(110.38); 
			cat.setCargoVariable(0.794);
		}
		if(500 < consumoMensual && consumoMensual<=600) {
			cat.setCategoria("R6"); 
			cat.setCargoFijo(220.75); 
			cat.setCargoVariable(0.832);
		}
		if(600 < consumoMensual && consumoMensual<=700) {
			cat.setCategoria("R7"); 
			cat.setCargoFijo(443.59); 
			cat.setCargoVariable(0.851);
		}
		if(700 < consumoMensual && consumoMensual<=1400) {
			cat.setCategoria("R8"); 
			cat.setCargoFijo(545.96); 
			cat.setCargoVariable(0.851);
		}
		if(consumoMensual > 1400) {
			cat.setCategoria("R9"); 
			cat.setCargoFijo(887.19); 
			cat.setCargoVariable(0.851);
		}
		return cat;
	}
	
	
}
