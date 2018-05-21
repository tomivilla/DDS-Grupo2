package beans;

public class SensorStrategy {
    int periodo = 30*24;
	Dispositivo dispositivo;
	    
	public SensorStrategy(Dispositivo dispositivo) {
    	this.setDispositivo(dispositivo);
    }
	public double GetConsumoPeriodo() {
		return dispositivo.getConsumo();
	}
	public double GetConsumoPorHoras(int horas) {
		return dispositivo.getConsumo();
	}
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
}
