package actuador;

import dispositivo.DispositivoInteligente;
import implementador.Implementador;

public class ActuadorTV extends Actuador{

	public ActuadorTV(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
		// TODO Auto-generated constructor stub
	}

	public void modoAhorro(){
		this.getImplementador().modoAhorro();
	}

}
