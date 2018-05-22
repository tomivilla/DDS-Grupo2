package beans;

public class ActuadorStrategy {
	DispositivoInteligente dispositivo;
	Mediador mediador = new Mediador();

	public ActuadorStrategy(DispositivoInteligente dispositivo) {
		this.setDispositivo(dispositivo);
	}

	public void EncenderModoAhorroEnergia() {

	}

	public void EncenderDispositivo() {
	}

	public void ApagarDispositivo() {
	}

	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Mediador getMediador() {
		return mediador;
	}

	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}

}
