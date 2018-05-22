package beans;

public class Regla {

DispositivoInteligente dispositivo;	
ActuadorStrategy acciones;
SensorStrategy mediciones;

public Regla(DispositivoInteligente dispositivo) {
 this.setDispositivo(dispositivo);		
}

public DispositivoInteligente getDispositivo() {
	return dispositivo;
}


public void setDispositivo(DispositivoInteligente dispositivo) {
	this.dispositivo = dispositivo;
}



}
