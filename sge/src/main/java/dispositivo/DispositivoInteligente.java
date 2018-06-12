package dispositivo;

import java.time.Instant;
import java.util.List;

import Estado.Estado;
import sensor.Sensor;

<<<<<<< HEAD:sge/src/main/java/dispositivo/DispositivoInteligente.java
public class DispositivoInteligente extends Dispositivo {
=======
public  class DispositivoInteligente extends Dispositivo {
>>>>>>> ad5562c5626f5fd8ccb55447eff972eba8ce5610:TPDDS-Grupo8/sge/src/main/java/dispositivo/DispositivoInteligente.java
	private Estado estado;
	private List<Sensor> sensores;
	private List<RegistroConsumo> periodos;
	
	public DispositivoInteligente(String unNombre, double unConsumo, Estado unEstado, List<Sensor> sensores, List<RegistroConsumo> periodos) {
		this.nombre_generico = unNombre;
		this.consumoKWHora = unConsumo;
		this.setEstado(unEstado);
		this.setSensores(sensores);
		this.setPeriodos(periodos);
	}
	
	public DispositivoInteligente() {
		// TODO Auto-generated constructor stub
	}

	public double cuanConsumisteEnHoras(int horas){
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		RegistroConsumo periodo = new RegistroConsumo(timeStampSeconds-(horas*60*60),timeStampSeconds);
		return cuantoConsumisteEnPeriodo(periodo);
	}
	
	public double cuantoConsumisteEnPeriodo(RegistroConsumo unPeriodo){
		return this.tiempoEncendidoEn(unPeriodo)*this.getConsumoKWHora();
	}
	
	public double tuConsumo(){
		return this.tiempoEncendido()*this.getConsumoKWHora();	
	}
	
	public double tiempoEncendido() {
		double tiempo=0;
		for(RegistroConsumo periodo : this.getPeriodos()){
			tiempo+=periodo.horasTranscurridas();
		}
		return tiempo;
	}
	public double tiempoEncendidoEn(RegistroConsumo unPeriodo){
		double tiempo=0;
		for(RegistroConsumo periodo : this.getPeriodos()){
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

	public List<RegistroConsumo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<RegistroConsumo> periodos) {
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
