package beans;

public class SensorEstrategiaComun extends SensorStrategy {

	public SensorEstrategiaComun(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public double GetConsumoPeriodo() {
		return dispositivo.getConsumo();
	}
	public double GetConsumoPorHoras(int horas) {
		return dispositivo.getConsumo();
	}

}
