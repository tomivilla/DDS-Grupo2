package beans;

public class ActuadorEstrategiaComun extends ActuadorStrategy {

	public ActuadorEstrategiaComun(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public void encenderModoAhorroEnergia() {
		super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "EncenderModoAhorro");
	}

	public void encenderDispositivo() {
		if (dispositivo.isApagado()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "Encender");			
		}
		if (dispositivo.isModoAhorroEnergia()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "ApagarModoAhorro");
		}
	}

	public void apagarDispositivo() {
		if (dispositivo.isEncendido()) {
			super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "Apagar");			
		}
	}
	public void resetiarConsumoEnPeriodo() {
		super.mediador.enviarMensaje(dispositivo.getIdFabricante(), dispositivo.getId(), "ResetiarConsumoPeriodo");
	}
}
