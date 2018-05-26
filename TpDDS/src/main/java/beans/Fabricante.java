package beans;

import java.util.*;

public abstract class Fabricante {

	private long idFabricante;

	public abstract void EjecutarAccion(double idFabricante, Actuador accion);

	public long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}

}
