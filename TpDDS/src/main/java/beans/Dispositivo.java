package beans;

import java.util.Random;

public abstract class  Dispositivo {

	protected String nombreGenerico;
	protected Adaptador adaptador = null;
	private double consumo;
	protected long idFabrica;
	protected Fabricante fabricante;	
	protected double tiempoMedido = 0;
    protected String magnitudMedicion = "watts";
    protected String unidadMedicion = "ut";
    public Dispositivo() {
		// por ahora que gener un numero random como id

		Random aleatorio = new Random(System.currentTimeMillis());
		idFabrica = aleatorio.nextLong();
		aleatorio.setSeed(System.currentTimeMillis());
		this.setId(idFabrica);
	
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

	public double getConsumo() {
		return consumo;
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
	public double getUnidadTiempoMedicion() {
		return tiempoMedido;
	}

	public void setUnidadTiempoMedicion(double unidadTiempoMedicion) {
		this.tiempoMedido = unidadTiempoMedicion;
	}

	public String getMagnitudMedicion() {
		return magnitudMedicion;
	}

	public void setMagnitudMedicion(String magnitudMedicion) {
		this.magnitudMedicion = magnitudMedicion;
	}

	public double getTiempoMedido() {
		return tiempoMedido;
	}

	public void setTiempoMedido(double tiempoMedido) {
		this.tiempoMedido = tiempoMedido;
	}

	public String getUnidadMedicion() {
		return unidadMedicion;
	}

	public void setUnidadMedicion(String unidadMedicion) {
		this.unidadMedicion = unidadMedicion;
	}

	
	}
