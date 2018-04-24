package beans;
import java.util.*;

public class Zona {
private String zona;
private List<Transformador> transformadores;

public Zona() {
	this.zona = new ArrayList<Transformador>();
}
public void addTransformador(Transformador sTransformador) {
	this.transformadores.add(sTransformador);	
}

public String GetZona() {
	this.zona;
}

public void SetZona(String zona) {
	this.zona = zona;
}

}
