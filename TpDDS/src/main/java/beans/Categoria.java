package beans;

public class Categoria {

	private String categoria;
	
	private String unidad;
		
	private float cargoFijo;
	
	private float cargoVariable;

	public Categoria(String categoria, String unidad, float cargoFijo, float cargoVariable) {
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
		this.categoria = categoria;
		this.unidad = unidad;
	}
	
	public float GetcargoFijo() {
		return this.GetcargoFijo()
	}
	
	public floar GetCargoVariable() {
		return this.GetCargoVariable();
	}
	
	public void SetCargoVariable(float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}
	
	public void SetCargoFijo(floar cargoFijo) {
		this.cargoFijo = cargoFijo;
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

	
	public Categoria calcularCategoria(float ConsumoMensual) {
	    Categoria cat = new Categoria();	
		if(consumoMensual < 150) {cat.categoria = "R1", cat.cargoFijo = 18.76, cat.cargoVariable =18.76}
		if(consumoMensual > 150 and consumoMensual<=325) {cat.categoria = "R2", cat.cargoFijo = 35.32, cat.cargoVariable =0.644}
		if(consumoMensual > 325 and consumoMensual<=400) {cat.categoria = "R3", cat.cargoFijo = 60.71, cat.cargoVariable =0.644}
		if(consumoMensual > 400 and consumoMensual<=450) {cat.categoria = "R4", cat.cargoFijo = 71.74, cat.cargoVariable =0.738}		
		if(consumoMensual > 450 and consumoMensual<=500) {cat.categoria = "R5", cat.cargoFijo = 110.38, cat.cargoVariable =0.794}
		if(consumoMensual > 500 and consumoMensual<=600) {cat.categoria = "R6", cat.cargoFijo = 220.75, cat.cargoVariable =0.832}
		if(consumoMensual > 600 and consumoMensual<=700) {cat.categoria = "R7", cat.cargoFijo = 443.59, cat.cargoVariable =0.851}
		if(consumoMensual > 700 and consumoMensual<=1400) {cat.categoria = "R8", cat.cargoFijo = 545.96, cat.cargoVariable =0.851}
		if(consumoMensual > 1400) {cat.categoria = "R9", cat.cargoFijo = 887.19, cat.cargoVariable =0.851}
		}
	
	
}
