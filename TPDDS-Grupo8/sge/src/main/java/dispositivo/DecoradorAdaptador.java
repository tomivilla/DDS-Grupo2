package dispositivo;

import java.util.List;

import Estado.Estado;
import sensor.Sensor;

public class DecoradorAdaptador extends Decorador{

	public DecoradorAdaptador(String unNombre, double unConsumo, Estado unEstado,
			List<Sensor> sensores, List<Periodo> periodos, Dispositivo dispositivo) {
		super(unNombre, unConsumo, unEstado, sensores, periodos, dispositivo);
	}

	
	
}
