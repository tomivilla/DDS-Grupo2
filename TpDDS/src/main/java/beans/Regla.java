package beans;

public class Regla {

Dispositivo dispositivo;	
ActuadorStrategy acciones;
SensorStrategy mediciones;

public Regla(Dispositivo dispositivo) {
 this.setDispositivo(dispositivo);		
}

public Dispositivo getDispositivo() {
	return dispositivo;
}


public void setDispositivo(Dispositivo dispositivo) {
	this.dispositivo = dispositivo;
}



}
