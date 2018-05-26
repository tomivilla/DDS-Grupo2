package beans;
import java.util.*;
public  class Regla {

	List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	List<Actuador> acciones;
	List<Sensor> mediciones;

	public Regla(List<Dispositivo> dispositivo) {
		this.setDispositivos(dispositivo);
	}
	
	public void RealizarAcciones() {
		for(Actuador accion: acciones) {
			for(Dispositivo dispositivo : dispositivos) {
			if(dispositivo instanceof DispositivoInteligente ) {
			ActuadorAdapter.EjecutarAccionEnFabricante(dispositivo.getFabricante().getIdFabricante(), accion);
			}
		}
		}
	}

	public List<Dispositivo> getDispositivo() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivo) {
		this.dispositivos = dispositivo;
	}

	public List<Actuador> getAcciones() {
		return acciones;
	}

	public void AgregarAcciones(List<Actuador> acciones) {
		this.acciones = acciones;
	}

	public List<Sensor> getMediciones() {
		return mediciones;
	}

	public void agregarMediciones(List<Sensor> mediciones) {
		this.mediciones = mediciones ;
	}

}
