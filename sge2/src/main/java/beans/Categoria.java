package beans;

public class Categoria{

	private int id;
	private int consumoMaximo;
	private double cargoFijo;
	private double cargoVariable;
	private int consumoMinimo;
	// Constructor

	public Categoria() {

	}

	public Categoria(int id, int unConsumoMin, int unConsumoMax, double unCargoFijo, double unCargoVariable) {
		this.id = id;
		this.consumoMinimo = unConsumoMin;
		this.consumoMaximo = unConsumoMax;
		this.cargoFijo = unCargoFijo;
		this.cargoVariable = unCargoVariable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean perteneceAcategoria(double unConsumo) {
		if (unConsumo > this.consumoMinimo && unConsumo <= this.consumoMaximo)
			return true;
		else
			return false;
	}

	public int getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(int consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public int getConsumoMaximo() {
		return consumoMaximo;
	}

	public void setConsumoMaximo(int consumoMaximo) {
		this.consumoMaximo = consumoMaximo;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

}
