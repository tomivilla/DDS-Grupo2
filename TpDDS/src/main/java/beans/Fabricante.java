package beans;

import java.util.List;

public class Fabricante {

	private List<DispositivoInteligente> dispositivos;

	private long id;

	
	public Fabricante(List<DispositivoInteligente> dispositivos, long id) {
		this.dispositivos = dispositivos;
		this.id = id;
	}

	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
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
