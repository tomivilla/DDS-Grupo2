package regla;

import dispositivo.DispositivoInteligente;

public class Apagar extends Accion{

	@Override
	public void ejecutarAccion(DispositivoInteligente unDispositivo) {
		unDispositivo.apagar();		
	}

}
