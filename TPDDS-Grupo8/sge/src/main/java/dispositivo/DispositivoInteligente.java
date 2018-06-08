package dispositivo;

import java.time.Instant;
import java.util.List;

import Estado.Estado;
import sensor.Sensor;

public abstract class DispositivoInteligente extends Dispositivo {
	private Estado estado;
	private List<Sensor> sensores;
	private List<Periodo> periodos;
	
	public DispositivoInteligente(String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores, List<Periodo> periodos) {
		this.nombre_generico = unNombre;
		this.consumoKWHora = unConsumo;
		this.setEstado(unEstado);
		this.setSensores(sensores);
		this.setPeriodos(periodos);
	}
	
	public double cuanConsumisteEnHoras(int horas){
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		Periodo periodo = new Periodo(timeStampSeconds-(horas*60*60),timeStampSeconds);
		return cuantoConsumisteEnPeriodo(periodo);
	}
	
	public double cuantoConsumisteEnPeriodo(Periodo unPeriodo){
		return this.tiempoEncendidoEn(unPeriodo)*this.getConsumoKWHora();
	}
	
	public double tuConsumo(){
		return this.tiempoEncendido()*this.getConsumoKWHora();	
	}
	
	public double tiempoEncendido() {
		double tiempo=0;
		for(Periodo periodo : this.getPeriodos()){
			tiempo+=periodo.horasTranscurridas();
		}
		return tiempo;
	}
	public double tiempoEncendidoEn(Periodo unPeriodo){
		double tiempo=0;
		for(Periodo periodo : this.getPeriodos()){
			if(periodo.estasEnPeriodo(unPeriodo)){
			tiempo+=periodo.horasTranscurridas();
			}
		}
		return tiempo;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public boolean estasEncendido(){
		return this.getEstado().estasEncendido();
	}
	
	public boolean estasApagado(){
		return this.getEstado().estasApagado();
	}
	
	public void apagar(){
		this.getEstado().apagar(this);
	}
	
	public void encender(){
		this.getEstado().encender(this);
	}
	
	public void modoAhorro(){
		this.getEstado().modoAhorro(this);
	}
}
