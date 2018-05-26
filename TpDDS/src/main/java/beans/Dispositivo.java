package beans;

import java.util.Random;

public class Dispositivo {

	private String nombreGenerico;
	private Adaptador adaptador = null;
	private double consumo;
	private int periodo = 30;
<<<<<<< HEAD
    private Fabricante fabricante;
    
=======

	public Dispositivo() {
		// por ahora que genere un numero random como id

		Random aleatorio = new Random(System.currentTimeMillis());
		id = aleatorio.nextLong();
		aleatorio.setSeed(System.currentTimeMillis());
		this.setId(id);

	}
	
	

	public Dispositivo(String nombreGenerico, long idFabricante, long id) {
		this.nombreGenerico = nombreGenerico;
		this.id = id;
		this.idFabricante = idFabricante;
	}



>>>>>>> def33656f3edf1a70cf2d9566a201dab05b91fc5
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
