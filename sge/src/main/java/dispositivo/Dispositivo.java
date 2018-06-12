package dispositivo;

public abstract class Dispositivo implements IDispositivo {
	public String nombre_generico;
	public double consumoKWHora;
	
	public String getNombre_generico() {
		return nombre_generico;
	}

	public void setNombre_generico(String nombre_generico) {
		this.nombre_generico = nombre_generico;
	}

	public double getConsumoKWHora() {
		return consumoKWHora;
	}

	public void setConsumoKWHora(double consumoKWHora) {
		this.consumoKWHora = consumoKWHora;
	}
}
