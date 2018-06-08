package regla;

import dispositivo.Dispositivo;

public class CondicionSinMovimiento extends Condicion{
	
	public boolean cumple(Dispositivo unDispositivo) {
		return (this.getValor() == 0);
		 
	}
}
