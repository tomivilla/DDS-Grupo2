package regla;

import beans.Condicion;
import beans.Dispositivo;

public class CondicionTemperaturaBaja extends Condicion {

	public CondicionTemperaturaBaja() {
		super();
	}
	
	public boolean cumple(Dispositivo unDispositivo) {
		return this.getValor() <= 15 ;
		 
	}
	
}
