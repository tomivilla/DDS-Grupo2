package beans;

public class ActuadorEstrategiaComun extends ActuadorStrategy {

	public ActuadorEstrategiaComun(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public void EncenderModoAhorroEnergia() {
		super.mediador.enviarMensaje(dispositivo.getId(), "EncenderModoAhorro");
	}

	public void EncenderDispositivo() {
		super.mediador.enviarMensaje(dispositivo.getId(), "Encender");
	}

	public void ApagarDispositivo() {
		super.mediador.enviarMensaje(dispositivo.getId(), "Apagar");
	}
	public void ResetiarConsumoEnPeriodo() {
		super.mediador.enviarMensaje(dispositivo.getId(), "ResetiarConsumoPeriodo");
	}
}
