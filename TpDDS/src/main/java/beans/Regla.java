package beans;

public class Regla {

	DispositivoInteligente dispositivo;
	ActuadorStrategy acciones;
	Sensor mediciones;

	public Regla(DispositivoInteligente dispositivo) {
		this.setDispositivo(dispositivo);
	}

	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public ActuadorStrategy getAcciones() {
		return acciones;
	}

	public void setAcciones(ActuadorStrategy acciones) {
		this.acciones = acciones;
	}

	public Sensor getMediciones() {
		return mediciones;
	}

	public void setMediciones(Sensor mediciones) {
		this.mediciones = mediciones;
	}

}
