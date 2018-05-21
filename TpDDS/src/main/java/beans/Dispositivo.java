package beans;

public class Dispositivo {

	private String nombreGenerico;
	
	private double consumo;
	
	private boolean encendido;
    
	private boolean modoAhorroDeEnergia;

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

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public boolean isModoAhorroDeEnergia() {
		return modoAhorroDeEnergia;
	}

	public void setModoAhorroDeEnergia(boolean modoAhorroDeEnergia) {
		this.modoAhorroDeEnergia = modoAhorroDeEnergia;
	}
	
	}
