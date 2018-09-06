package beans;

public class DispositivoEstandar extends Dispositivo {

	private int horasEncendido;

	public DispositivoEstandar(Long id, String nombre_generico, double consumoKWHora, int horasEncendido) {
		super(id, nombre_generico, consumoKWHora);
		this.horasEncendido = horasEncendido;
	}

	public double tuConsumo() {
		return this.getConsumoKWHora() * this.horasEncendido;
	}

	public int getHorasEncendido() {
		return horasEncendido;
	}

	public void setHorasEncendido(int horasEncendido) {
		this.horasEncendido = horasEncendido;
	}

}
