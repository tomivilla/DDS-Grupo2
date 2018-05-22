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

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public boolean isModoAhorroEnergia() {
		return modoAhorroEnergia;
	}

	public void setModoAhorroEnergia(boolean modoAhorroEnergia) {
		this.modoAhorroEnergia = modoAhorroEnergia;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

}
