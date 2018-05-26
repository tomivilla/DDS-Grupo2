package beans;

import java.util.*;

public abstract class Fabricante {


	private long idFabricante;

	public abstract void EjecutarAccion(double idFabricante, Actuador accion);

	public long getIdFabricante() {
		return idFabricante;
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

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}

<<<<<<< HEAD
=======
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
>>>>>>> def33656f3edf1a70cf2d9566a201dab05b91fc5
}
