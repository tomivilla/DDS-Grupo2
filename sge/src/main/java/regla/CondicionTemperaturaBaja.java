package regla;

import dispositivo.Dispositivo;

public class CondicionTemperaturaBaja extends Condicion {

	public CondicionTemperaturaBaja() {
		super();
	}
	
	public boolean cumple(Dispositivo unDispositivo) {
		return this.getValor() <= 15 ;
		 
	}
	
}
