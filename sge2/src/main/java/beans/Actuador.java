package beans;

public abstract class Actuador {

	private String ID;
	private DispositivoInteligente dispositivo;
	private Implementador implementador;
	
	public Actuador(String unID, DispositivoInteligente unDispositivo, Implementador implementador){
		this.setID(unID);
		this.setDispositivo(unDispositivo);
		this.setImplementador(implementador);
	}

	public void encender() {
		this.dispositivo.encender();
		this.implementador.encender();
	}

	public void modoAhorro() {
		this.dispositivo.modoAhorro();
		this.implementador.modoAhorro();
	}

	public void apagar() {
		this.dispositivo.apagar();
		this.implementador.apagar();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Implementador getImplementador() {
		return implementador;
	}

	public void setImplementador(Implementador implementador) {
		this.implementador = implementador;
	}
}
