package beans;

import java.util.Random;

public abstract class Dispositivo {

	protected String nombreGenerico;
	protected Adaptador adaptador = null;
	protected double consumoPeriodo;
	protected long id;
	protected long idFabricante;
	protected int periodo = 30;

	public Dispositivo() {
		// por ahora que genere un numero random como id

		Random aleatorio = new Random(System.currentTimeMillis());
		id = aleatorio.nextLong();
		aleatorio.setSeed(System.currentTimeMillis());
		this.setId(id);

	}

	public double getConsumoPeriodo() {
		return consumoPeriodo;
	}

	public double getConsumoHoras(int horas) {
		return (consumoPeriodo / (periodo * 24)) * horas;
	}

	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public void setConsumo(double consumo) {
		this.consumoPeriodo = consumo;
	}

	public Adaptador Adaptador() {
		return adaptador;
	}

	public void setAdaptador(Adaptador adaptador) {
		this.adaptador = adaptador;
	}

	public long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}

}
