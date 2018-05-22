package beans;

import java.util.*;

public class Mediador {

	List<Fabricante> fabricantes = new ArrayList<Fabricante>();

	public void enviarMensaje(long idFabricante, long idDispositivo, String mensaje) {
		for (Fabricante fab : fabricantes) {
			if (fab.getId() == idFabricante) {
				fab.recibirMensaje(idDispositivo, mensaje);
			}
		}
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricas(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

}
