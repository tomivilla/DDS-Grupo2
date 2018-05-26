package beans;

public class DispositivoInteligente extends Dispositivo {

	public boolean encendido;
	public boolean modoAhorroEnergia;
	public boolean registrado;

	public DispositivoInteligente() {

	}

	public DispositivoInteligente(String nombreGenerico, long idFabricante, boolean encendido,
			boolean modoAhorroEnergia, boolean registrado, long id) {
		this.encendido = encendido;
		this.modoAhorroEnergia = modoAhorroEnergia;
		this.registrado = registrado;
	}

	public Adaptador getAdaptador() {
		return null;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void encender() {
		this.encendido = true;
	}

	public void apagar() {
		this.encendido = false;
	}

	public boolean isModoAhorroEnergia() {
		return modoAhorroEnergia;
	}

	public void activaAhorroEnergia() {
		this.modoAhorroEnergia = true;
	}
	
	public void apagarAhorroEnergia() {
		this.modoAhorroEnergia = false;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public boolean isApagado() {
		return !encendido;
	}

}
