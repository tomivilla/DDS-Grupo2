package regla;

import beans.Condicion;
import beans.Dispositivo;

public class CondicionTemperaturaAlta extends Condicion {

	public CondicionTemperaturaAlta() {
		super();
	}
	
	public boolean cumple(Dispositivo unDispositivo) {
		return (this.getValor() >= 35);
		 
	}

}
