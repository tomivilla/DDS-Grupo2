package sge_ui;

public interface ICategoria {
	
	public boolean perteneceAcategoria(double unConsumo);
	public int getConsumoMinimo();
	public void setConsumoMinimo(int consumoMinimo);
	public int getConsumoMaximo();
	public void setConsumoMaximo(int consumoMaximo);
	public double getCargoFijo();
	public void setCargoFijo(double cargoFijo);
	public double getCargoVariable();
	public void setCargoVariable(double cargoVariable);

}
