package beans;

import java.util.Observable;

public class Dispositivo extends Observable {

	private Long id;
	private String nombre_generico;
	private double consumoKWHora;
	private boolean Inteligente;
	private boolean BajoConsumo;

	public Dispositivo() {

	}

	public Dispositivo(Long id, String nombre_generico, double consumoKWHora, boolean esInteligente,
			boolean esBajoConsumo) {
		super();
		this.id = id;
		this.nombre_generico = nombre_generico;
		this.consumoKWHora = consumoKWHora;
		this.Inteligente = esInteligente;
		this.BajoConsumo = esBajoConsumo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_generico() {
		return nombre_generico;
	}

	public void setNombre_generico(String nombre_generico) {
		this.nombre_generico = nombre_generico;
	}

	public double getConsumoKWHora() {
		return consumoKWHora;
	}

	public void setConsumoKWHora(double consumoKWHora) {
		this.consumoKWHora = consumoKWHora;
	}


	public boolean isInteligente() {
		return Inteligente;
	}

	public void setInteligente(boolean inteligente) {
		Inteligente = inteligente;
	}

	public boolean isBajoConsumo() {
		return BajoConsumo;
	}

	public void setBajoConsumo(boolean bajoConsumo) {
		BajoConsumo = bajoConsumo;
	}

	public double tuConsumo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
