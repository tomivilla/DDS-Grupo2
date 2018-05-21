package beans;

//https://es.wikipedia.org/wiki/Command_(patr%C3%B3n_de_dise%C3%B1o)
public class ActuadorStrategy {
Dispositivo dispositivo;

public ActuadorStrategy(Dispositivo dispositivo) {
	this.setDispositivo(dispositivo);
}

public void EncenderModoAhorroEnergia() {
	
}

public void EncenderDispositivo() {
}

public void ApagarDispositivo() {
}
public Dispositivo getDispositivo() {
	return dispositivo;
}

public void setDispositivo(Dispositivo dispositivo) {
	this.dispositivo = dispositivo;
}
	
}
