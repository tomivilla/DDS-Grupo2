package dispositivo;

public class DispositivoEstandar extends Dispositivo {
	
	private int horasEncendido; 
	
	public DispositivoEstandar(String unNombre, double unConsumo, int horasEncendido) {
		this.nombre_generico = unNombre;
		this.consumoKWHora = unConsumo;
		this.horasEncendido = horasEncendido;
	}
	
	public double tuConsumo(){
		return this.consumoKWHora * this.horasEncendido;
	}

	public int getHorasEncendido() {
		return horasEncendido;
	}

	public void setHorasEncendido(int horasEncendido) {
		this.horasEncendido = horasEncendido;
	}
	
}
