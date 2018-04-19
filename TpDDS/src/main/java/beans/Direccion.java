package beans;

import java.util.List;

public class Direccion {

	private String direccion;
	
	private String zona;
	
	private List<Transformador> transformador;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<Transformador> getTransformador() {
		return transformador;
	}

	public void setTransformador(List<Transformador> transformador) {
		this.transformador = transformador;
	}
	
}
