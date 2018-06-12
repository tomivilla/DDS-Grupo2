package actuador;

import dispositivo.DispositivoInteligente;
import implementador.Implementador;

public class ActuadorHeladera extends Actuador{
	
	public ActuadorHeladera(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
	}

	public void aumentarTemperatura(){
		this.getImplementador().aumentarTemperatura();
	}
	
	public void disminuirTemperatura(){
		this.getImplementador().disminuirTemperatura();
	}
	public void modoAhorro(){
		this.getImplementador().modoAhorro();
	}
}
