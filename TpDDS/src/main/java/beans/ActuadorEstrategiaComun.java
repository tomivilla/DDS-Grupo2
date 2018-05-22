package beans;

public class ActuadorEstrategiaComun extends ActuadorStrategy {

	public ActuadorEstrategiaComun(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public void EncenderModoAhorroEnergia() {
		super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "EncenderModoAhorro");
	}

	public void EncenderDispositivo() {
		if (!dispositivo.isEncendido()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "Encender");			
		}
		if (dispositivo.isModoAhorroEnergia()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "ApagarModoAhorro");
		}
	}

	public void ApagarDispositivo() {
		if (dispositivo.isEncendido()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "Apagar");			
		}
	}
	public void ResetiarConsumoEnPeriodo() {
		super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "ResetiarConsumoPeriodo");
	}
}
