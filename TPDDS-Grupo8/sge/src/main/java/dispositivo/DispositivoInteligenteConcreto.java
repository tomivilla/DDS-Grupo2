package dispositivo;

import java.util.List;

import Estado.Estado;
import sensor.Sensor;

public class DispositivoInteligenteConcreto extends DispositivoInteligente {
	
	public DispositivoInteligenteConcreto(String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores, List<Periodo> periodos) {
		super(unNombre, unConsumo, unEstado, sensores, periodos);
	}
}
