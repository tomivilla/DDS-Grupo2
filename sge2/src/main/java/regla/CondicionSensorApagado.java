package regla;

import beans.Condicion;
import beans.Dispositivo;

public class CondicionSensorApagado extends Condicion{
	
	public CondicionSensorApagado() {
		super();
	}
	
	public boolean cumple(Dispositivo unDispositivo) {
		return this.getValor() == 0;
		 
	}
}
