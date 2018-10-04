package beans;

public class DispositivoEstandar extends Dispositivo {

	private int horasEncendido;

	public DispositivoEstandar() {
		super();
	}

	public DispositivoEstandar(Long id, String nombre_generico, double consumoKWHora, int horasEncendido,
			boolean esBajoConsumo) {
		super(id, nombre_generico, consumoKWHora, false, esBajoConsumo);
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
