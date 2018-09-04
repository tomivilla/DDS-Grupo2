package regla;

import beans.Accion;
import beans.DispositivoInteligente;

public class Encender extends Accion{

	@Override
	public void ejecutarAccion(DispositivoInteligente unDispositivo) {
		unDispositivo.encender();		
	}

}
