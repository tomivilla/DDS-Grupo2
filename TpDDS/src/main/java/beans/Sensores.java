package beans;

public class Sensores {
private String unidadTiempo ;
private String magnitud;

public double GetMedicionLuz() { return 0;}
public double GetMedicionMovimiento() { return 0;}
public double GetMedicionHumedad() { return 0;}
public double GetMedicionTemperatura() { return 0;}

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
