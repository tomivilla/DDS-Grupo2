package beans;

public class SensorEstrategiaComun extends SensorStrategy {

	int periodo = 30 * 24;
	public SensorEstrategiaComun(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}
	public double GetConsumoPeriodo() {
		/* 30 ut  -- consumo
		 * perido ut  -- x = periodo * consumo / 30
		 * */
		return periodo * dispositivo.getConsumo() / dispositivo.getTiempoMedido();
	}
	public double GetConsumoPorHoras(int horas) {
		return horas * dispositivo.getConsumo() / dispositivo.getTiempoMedido();
	}

}
