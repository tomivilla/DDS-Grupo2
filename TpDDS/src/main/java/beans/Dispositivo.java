package beans;

public class Dispositivo {

	private String nombreGenerico;
	
	private double consumo;
	
	private boolean Encendido;
	

	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public boolean isEstado() {
		return Encendido;
	}

	public void setEstado(boolean estado) {
		this.Encendido = estado;
	}
	
	
}
