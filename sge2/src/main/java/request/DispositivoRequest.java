package request;

public class DispositivoRequest {

	private String nombre;

	private Double consumo;

	private boolean inteligente;

	private boolean bajoConsumo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public boolean isInteligente() {
		return inteligente;
	}

	public void setInteligente(boolean inteligente) {
		this.inteligente = inteligente;
	}

	public boolean isBajoConsumo() {
		return bajoConsumo;
	}

	public void setBajoConsumo(boolean bajoConsumo) {
		this.bajoConsumo = bajoConsumo;
	}

}
