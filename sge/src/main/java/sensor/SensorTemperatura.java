package sensor;

import beans.Sensor;

public class SensorTemperatura extends Sensor {
	public SensorTemperatura(int unValor,String unaManitud){
		this.setValor(unValor);
		this.setMagnitud(unaManitud);
	}
}
