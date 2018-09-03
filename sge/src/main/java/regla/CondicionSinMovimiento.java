package regla;

import beans.Condicion;
import beans.Dispositivo;

public class CondicionSinMovimiento extends Condicion{
	
	public boolean cumple(Dispositivo unDispositivo) {
		return (this.getValor() == 0);
		 
	}
}
