package Estado;

import beans.Estado;
import dispositivo.DispositivoInteligente;

public class AhorroDeEnergia extends Estado {
	private static AhorroDeEnergia modoAhorro;
	
	private AhorroDeEnergia(){
		
	}
	
	public static AhorroDeEnergia getInstance() {
        if (modoAhorro == null) {
        	modoAhorro = new AhorroDeEnergia();
        }
        return modoAhorro;
    }
	
	public void apagar(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(Apagado.getInstance());
	}

	public void encender(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(Encendido.getInstance());
	}

	public void modoAhorro(DispositivoInteligente dispositivoInteligente) {
	}
	
	public boolean estasEncendido() {
		return true;
	}

	public boolean estasApagado() {
		return false;
	}
}
