package beans;

import java.util.Random;

public class Dispositivo {

	private String nombreGenerico;
	private Adaptador adaptador = null;
	private double consumo;
	private int periodo = 30;
    private Fabricante fabricante;
    
	public double getConsumo() {
		return consumo;
	}

	public double getConsumoHoras(int horas) {
		return (consumo / (periodo * 24)) * horas;
	}

	public String getNombreGenerico() {
		return nombreGenerico;
	}


	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public Adaptador Adaptador() {
		return adaptador;
	}

	public void setAdaptador(Adaptador adaptador) {
		this.adaptador = adaptador;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
