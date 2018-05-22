package beans;

import java.util.Random;

public abstract class  Dispositivo {

	protected String nombreGenerico;
	protected Adaptador adaptador = null;
	protected double consumoPeriodo;
	protected long idFabrica;
	protected Fabricante fabricante;	
    protected int periodo = 30;
    public Dispositivo() {
		// por ahora que gener un numero random como id

		Random aleatorio = new Random(System.currentTimeMillis());
		idFabrica = aleatorio.nextLong();
		aleatorio.setSeed(System.currentTimeMillis());
		this.setId(idFabrica);
	
	}
	public double getConsumoPeriodo() {
		return consumoPeriodo;
	}
	public double getConsumoHoras(int horas) {
		return (consumoPeriodo / (periodo * 24 )) * horas ;
	}
	
	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public long getId() {
	 return this.idFabrica;
	}

	public void setId(long id) {
		this.idFabrica = id;
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	}
