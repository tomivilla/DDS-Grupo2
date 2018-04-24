package beans;
import java.util.*;

public class Zona {
private String zona;
private List<Transformador> transformadores;

public void addTransformador(Transformador sTransformador) {
	this.transformadores.add(sTransformador);	
}

public String getZona() {
	return zona;
}

public void setZona(String zona) {
	this.zona = zona;
}

public List<Transformador> getTransformadores() {
	return transformadores;
}

public void setTransformadores(List<Transformador> transformadores) {
	this.transformadores = transformadores;
}



}
