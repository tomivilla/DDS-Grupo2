package beans;

import observer.ObserverSensor;;

public class Sensor {

	private Long id;
	private ObserverSensor observer;
	private int valor;
	private String magnitud;

	
	
	public Sensor() {
		super();
	}

	public Sensor(Long id, ObserverSensor observer, int valor, String magnitud) {
		super();
		this.id = id;
		this.observer = observer;
		this.valor = valor;
		this.magnitud = magnitud;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adscribir(ObserverSensor observer) {
		setObserver(observer);
	}

	public void notificar() {
		this.getObserver().actualizar(this);
	}

	public int medirMagnitud() {
		// realizar medicion...
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
