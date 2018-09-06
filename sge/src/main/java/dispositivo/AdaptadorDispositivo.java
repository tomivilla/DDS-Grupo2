package dispositivo;

import java.util.List;

import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Estado;
import beans.Periodo;
import beans.Sensor;

public class AdaptadorDispositivo extends DispositivoInteligente {
	
	public AdaptadorDispositivo(Long id, String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores,
			List<Periodo> periodos, DispositivoEstandar dispositivo) {
		super(id, unNombre, unConsumo, unEstado, sensores, periodos);
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
