package beans;

import java.util.ArrayList;
import java.util.List;

public class FabricanteLG extends Fabricante {
 
	public FabricanteLG(List<DispositivoInteligente> dispositivos, long id) {
		super(dispositivos, id);
		// TODO Auto-generated constructor stub
	}
	private List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
	private DispositivoInteligente dispositivo ;

	
	public void recibirMensaje(long idDispositivo, String mensaje) {
		DispositivoInteligente dispo = getDispositivoById(idDispositivo);
		if(dispo != null) {
			this.setDispositivo(dispo);
			switch(mensaje) {
			case "Encender" : encenderDispositivo();
			case "Apagar" : apagarDispositivo();
			case "EncenderModoAhorro" : encenderModoAhorroEnergia();
			case "ResetiarConsumoPeriodo": resetiarConsumoPeriodo();
			case "ApagarModoAhorro": apagarModoAhorro();
			}
		}
	}
	
	private void apagarModoAhorro() {
		dispositivo.apagarAhorroEnergia();		
	}

	public void resetiarConsumoPeriodo() {
		dispositivo.setConsumo(0);
	}
	public void encenderModoAhorroEnergia() {
		dispositivo.activaAhorroEnergia();
	}

	public void encenderDispositivo() {
			dispositivo.encender();
	}

	public void apagarDispositivo() {
		if(dispositivo.isEncendido()) {
		   dispositivo.apagar();
		}
	}
	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}


}
