package beans;

import java.util.*;

public abstract class Fabricante {


	private long idFabricante;
	private List<DispositivoInteligente> dispositivos;

	abstract void EjecutarAccion(double idFabricante, Actuador accion);

	
	public Fabricante(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public void recibirMensaje(long idDispositivo, String mensaje) {
				
	}

	public DispositivoInteligente getDispositivoById(long idDispositivo) {
		for (Dispositivo dis : dispositivos) {
			if ((dis instanceof DispositivoInteligente) && (dis.getFabricante().getIdFabricante() == idDispositivo)) {
				return (DispositivoInteligente) dis;
			}
		}
		return null;
	}
}
