package regla;

import dispositivo.DispositivoInteligente;

public class Encender extends Accion{

	@Override
	public void ejecutarAccion(DispositivoInteligente unDispositivo) {
		unDispositivo.encender();		
	}

}