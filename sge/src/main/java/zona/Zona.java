package zona;

import transformador.Transformador;

public class Zona {
	public String zona ;
	public boolean activado;
	public  Transformador transformador;
	public double radio;
	public double coordenadaX;
	public double coordenadaY;
	
	public Zona() {
		
	}
	
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public boolean isActivado() {
		return activado;
	}
	public void setActivado(boolean activado) {
		this.activado = activado;
	}
	public Transformador getTransformador() {
		return transformador;
	}
	public void setTransformador(Transformador transformador) {
		this.transformador = transformador;
	}
}
