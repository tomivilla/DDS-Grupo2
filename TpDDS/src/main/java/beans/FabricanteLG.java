package beans;

import java.util.ArrayList;
import java.util.List;

public class FabricanteLG extends Fabricante {
 
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	private DispositivoInteligente dispositivo ;
	private Mediador mediador;

	
	public void recibirMensaje(long idFabrica, String mensaje) {
		DispositivoInteligente dispo = GetDispositivoById(idFabrica);
		if(dispo != null) {
			this.setDispositivo(dispo);
			switch(mensaje) {
			case "Encender" : EncenderDispositivo();
			case "Apagar" : ApagarDispositivo();
			case "EncenderModoAhorro" : EncenderModoAhorroEnergia();
			case "ResetiarConsumoPeriodo": ResetiarConsumoPeriodo();
			}
		}
	}
	private DispositivoInteligente GetDispositivoById(long idFabrica) {
		for(Dispositivo dis : dispositivos) {
			if((dis instanceof DispositivoInteligente) && (dis.getId() == idFabrica)) {
				return (DispositivoInteligente) dis;
			}
		}
		return null;
	}
	
	public void ResetiarConsumoPeriodo() {
		dispositivo.setConsumo(0);
	}
	public void EncenderModoAhorroEnergia() {
		dispositivo.setModoAhorroEnergia(true);
	}

	public void EncenderDispositivo() {
		if(dispositivo.isModoAhorroEnergia()) {
			if(!dispositivo.isEncendido()) {
		        dispositivo.setEncendido(true);
		     }
		}
	}

	public void ApagarDispositivo() {
		if(dispositivo.isEncendido()) {
		   dispositivo.setEncendido(false);
		}
	}
	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}
	public Mediador getMediador() {
		return mediador;
	}
	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
