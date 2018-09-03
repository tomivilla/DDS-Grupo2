package regla;

import beans.Accion;
import dispositivo.DispositivoInteligente;

public class PasarAModoAhorro extends Accion {

	@Override
	public void ejecutarAccion(DispositivoInteligente unDispositivo) {
		unDispositivo.modoAhorro();		
	}

}
