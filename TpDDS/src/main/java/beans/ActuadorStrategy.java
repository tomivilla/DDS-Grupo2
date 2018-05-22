package beans;

//https://es.wikipedia.org/wiki/Command_(patr%C3%B3n_de_dise%C3%B1o)
public class ActuadorStrategy {
	DispositivoInteligente dispositivo;
	Mediador mediador = new Mediador();

public ActuadorStrategy(DispositivoInteligente dispositivo) {
	this.setDispositivo(dispositivo);
}

public void EncenderModoAhorroEnergia() {
	
}

public void EncenderDispositivo() {
}

public void ApagarDispositivo() {
}
public DispositivoInteligente getDispositivo() {
	return dispositivo;
}

public void setDispositivo(DispositivoInteligente dispositivo) {
	this.dispositivo = dispositivo;
}

public Mediador getMediador() {
	return mediador;
}

public void setMediador(Mediador mediador) {
	this.mediador = mediador;
}
	
}
