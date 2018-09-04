package observer;

import java.util.List;

import beans.Condicion;
import beans.Sensor;

public class ObserverSensor {
	private int estadoObserver;
	private List<Condicion> subscriptores;
	
	public ObserverSensor(List<Condicion> subs){
		this.setSubscriptores(subs);
	}
	
	public void actualizar(Sensor unSensor){
		estadoObserver = unSensor.getValor();
		this.informarASubcriptores();
	}
	
	public void informarASubcriptores(){
		for (Condicion condicion : this.getSubscriptores()){
		condicion.recibirEstado(this.getEstadoObserver());
		}
	}

	public int getEstadoObserver() {
		return estadoObserver;
	}

	public void setEstadoObserver(int estadoObserver) {
		this.estadoObserver = estadoObserver;
	}

	public List<Condicion> getSubscriptores() {
		return subscriptores;
	}

	public void setSubscriptores(List<Condicion> subscriptores) {
		this.subscriptores = subscriptores;
	}
	
	public void agregarSubscriptor(Condicion subscriptor){
		this.subscriptores.add(subscriptor);
	}
	
}
