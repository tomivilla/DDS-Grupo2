package actuador;

import beans.Actuador;
import beans.DispositivoInteligente;
import beans.Implementador;

public class ActuadorTV extends Actuador{

	public ActuadorTV(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
		// TODO Auto-generated constructor stub
	}

	public void modoAhorro(){
		this.getImplementador().modoAhorro();
	}

}
