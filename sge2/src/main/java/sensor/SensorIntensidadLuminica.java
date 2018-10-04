package sensor;

import beans.Sensor;

public class SensorIntensidadLuminica extends Sensor{
	public SensorIntensidadLuminica(int unValor,String unaManitud){
		this.setValor(unValor);
		this.setMagnitud(unaManitud);
	}
}
