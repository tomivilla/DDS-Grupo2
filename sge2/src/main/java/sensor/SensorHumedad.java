package sensor;

import beans.Sensor;

public class SensorHumedad extends Sensor{
	public SensorHumedad(int unValor,String unaManitud){
		this.setValor(unValor);
		this.setMagnitud(unaManitud);
	}
}
