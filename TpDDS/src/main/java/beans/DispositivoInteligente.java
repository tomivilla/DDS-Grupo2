package beans;

public class DispositivoInteligente extends Dispositivo {

	public boolean encendido ;
	public boolean modoAhorroEnergia;
	protected boolean registrado;
	
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
