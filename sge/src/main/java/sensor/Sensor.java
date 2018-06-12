package sensor;
import observer.ObserverSensor;;

public abstract class Sensor {
	
	private ObserverSensor observer;
	private int valor;
	private String magnitud;
	
	public void adscribir(ObserverSensor observer){
		setObserver(observer);
	}
	public void	notificar(){
		this.getObserver().actualizar(this);
	}
	public int medirMagnitud(){
		//realizar medicion...
		this.notificar();
		return this.getValor();
	}
	public ObserverSensor getObserver() {
		return observer;
	}
	public void setObserver(ObserverSensor observer) {
		this.observer = observer;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getMagnitud() {
		return magnitud;
	}
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}
}
