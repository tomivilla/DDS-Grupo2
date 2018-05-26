package beans;

import java.util.*;
public class Sensor {

protected String unidadTiempo;
protected String  magnitud;
protected List<Regla> reglas = new ArrayList<Regla>();
public Sensor(String UnidadTiempo, String magnitud) {
	this.setMagnitud(magnitud);
	this.setUnidadTiempo(UnidadTiempo);
	
}

public void AccionarReglaObservadora() {
	for(Regla reg: reglas) {
		reg.RealizarAcciones();
	}
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

public List<Regla> getReglas() {
	return reglas;
}

public void setReglas(List<Regla> reglas) {
	this.reglas = reglas;
}
}
