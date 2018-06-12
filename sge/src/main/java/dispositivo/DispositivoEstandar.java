package dispositivo;

public class DispositivoEstandar extends Dispositivo {
	
	private int horasEncendido; 
	
	public DispositivoEstandar() {}	
	public DispositivoEstandar(String unNombre, double unConsumo, int horasEncendido) {
		this.nombre_generico = unNombre;
		this.consumoKWHora = unConsumo;
		this.horasEncendido = horasEncendido;
	}
	
	public double tuConsumo(){
		return this.consumoKWHora * this.horasEncendido;
	}
	
}
