package dispositivo;

public interface IDispositivo {
	
	public String getNombre_generico();
	public void setNombre_generico(String nombre_generico);
	public double getConsumoKWHora();
	public void setConsumoKWHora(double consumoKWHora);
	public double tuConsumo();
}
