package beans;

public class SensorHumedad extends Sensor {

	public SensorHumedad(String unidadTiempo, String magnitud) {
		super(unidadTiempo, magnitud);
		setUnidadTiempo("h");
		super.setMagnitud("%");
		// TODO Auto-generated constructor stub
	}

}
