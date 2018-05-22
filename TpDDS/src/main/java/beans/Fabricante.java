package beans;

import java.util.List;

public class Fabricante {

	private List<Dispositivo> dispositivos;

	private Mediador mediador;

	private long id;

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Mediador getMediador() {
		return mediador;
	}

	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void recibirMensaje(long idDispositivo, String mensaje) {
		
	}

	public DispositivoInteligente getDispositivoById(long idDispositivo) {
		for (Dispositivo dis : dispositivos) {
			if ((dis instanceof DispositivoInteligente) && (dis.getId() == idDispositivo)) {
				return (DispositivoInteligente) dis;
			}
		}
		return null;
	}
}
