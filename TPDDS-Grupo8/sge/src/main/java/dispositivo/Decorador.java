package dispositivo;

import java.util.List;

import Estado.Estado;
import sensor.Sensor;

public abstract class Decorador extends DispositivoInteligente {
	
	public Decorador(String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores,
			List<Periodo> periodos, Dispositivo dispositivo) {
		super(unNombre, unConsumo, unEstado, sensores, periodos);
		this.setDispositivo(dispositivo);
	}

	private Dispositivo dispositivo;
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
}
