package actuador;

import dispositivo.DispositivoInteligente;
import implementador.Implementador;

public class ActuadorLuces extends Actuador {

	public ActuadorLuces(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
	}

	public void modoAhorro(){
		this.getImplementador().modoAhorro();
	}

}
