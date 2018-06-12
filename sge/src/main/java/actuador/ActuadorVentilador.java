package actuador;

import dispositivo.DispositivoInteligente;
import implementador.Implementador;

public class ActuadorVentilador extends Actuador{
		
	public ActuadorVentilador(String unID, DispositivoInteligente unDispositivo, Implementador implementador) {
		super(unID, unDispositivo, implementador);
		// TODO Auto-generated constructor stub
	}
	public void aumentarVelocidad(){
		this.getImplementador().aumentarVelocidad();
	}
	public void  disminuirVelocidad(){
		this.getImplementador().disminuirVelocidad();
	}
	
}
