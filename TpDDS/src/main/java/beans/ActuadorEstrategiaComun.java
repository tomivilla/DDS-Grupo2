package beans;

public class ActuadorEstrategiaComun extends ActuadorStrategy {

	public ActuadorEstrategiaComun(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public void EncenderModoAhorroEnergia() {
		dispositivo.setModoAhorroDeEnergia(true);
	}

	public void EncenderDispositivo() {
		if(dispositivo.isModoAhorroDeEnergia()) {
		dispositivo.setEncendido(true);
		}
	}

	public void ApagarDispositivo() {
		if(dispositivo.isEncendido()) {
		   dispositivo.setEncendido(false);
		}
	}
}
