package beans;

import java.util.*;
public class Mediador {

List<Fabricante> fabricas = new ArrayList<Fabricante>();

public void enviarMensaje(long idFabrica, String mensaje) {
	for(Fabricante fab : fabricas) {
		fab.recibirMensaje(idFabrica, mensaje);
	}
}

public List<Fabricante> getFabricas() {
	return fabricas;
}

public void setFabricas(List<Fabricante> fabricas) {
	this.fabricas = fabricas;
}

}
