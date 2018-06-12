package dispositivo;

import java.util.List;

import Estado.Estado;
import sensor.Sensor;

public class AdaptadorDispositivo extends DispositivoInteligente {
	
	public AdaptadorDispositivo(String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores,
			List<Periodo> periodos, DispositivoEstandar dispositivo) {
		super(unNombre, unConsumo, unEstado, sensores, periodos);
		this.setDispositivo(dispositivo);
	}

	private DispositivoEstandar dispositivo;
	
	public DispositivoEstandar getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoEstandar dispositivo) {
		this.dispositivo = dispositivo;
	}
	
}
