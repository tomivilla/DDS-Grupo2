package beans;

import java.util.Observable;

import dispositivo.IDispositivo;

public abstract class Dispositivo extends Observable implements IDispositivo {

	private Long id;
	private String nombre_generico;
	private double consumoKWHora;
	
	public Dispositivo() {
		
	}

	public Dispositivo(Long id, String nombre_generico, double consumoKWHora) {
		super();
		this.id = id;
		this.nombre_generico = nombre_generico;
		this.consumoKWHora = consumoKWHora;
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
}
