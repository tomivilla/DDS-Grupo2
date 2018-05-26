package beans;
import java.util.*;
public  class Sensor {

	private String unidadTiempo;
	private String magnitud;
    protected List<Regla> observadores ;
	public Sensor(String unidadTiempo, String magnitud) {
		this.unidadTiempo = unidadTiempo;
		this.magnitud = magnitud;
	}

	public void AccionarReglaObservadora() {
		
	}
	
	public String getUnidadTiempo() {
		return unidadTiempo;
	}

	public void setUnidadTiempo(String unidadTiempo) {
		this.unidadTiempo = unidadTiempo;
	}

	public String getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}

}
