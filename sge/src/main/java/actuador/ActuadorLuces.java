package actuador;

import beans.Actuador;
import beans.Implementador;
import dispositivo.DispositivoInteligente;

public class ActuadorLuces extends Actuador {

	public ActuadorLuces(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
	}

	public void modoAhorro(){
		this.getImplementador().modoAhorro();
	}

}
