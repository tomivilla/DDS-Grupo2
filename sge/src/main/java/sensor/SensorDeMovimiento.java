package sensor;

import beans.Sensor;

public class SensorDeMovimiento extends Sensor {
	public SensorDeMovimiento(int unValor,String unaManitud){
		this.setValor(unValor);
		this.setMagnitud(unaManitud);
	}
}
