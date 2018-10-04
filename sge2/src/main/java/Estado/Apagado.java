package Estado;

import beans.DispositivoInteligente;
import beans.Estado;

public class Apagado extends Estado{
	private static Apagado apagado;
	
	private Apagado(){
		
	}
	
	public static Apagado getInstance() {
        if (apagado == null) {
            apagado = new Apagado();
        }
        return apagado;
    }
	
	public boolean estasEncendido() {
		return false;
	}
	
	public boolean estasApagado() {
		return true;
	}
	
	public void apagar(DispositivoInteligente dispositivoInteligente) {
	}

	public void encender(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(Encendido.getInstance());
	}

	public void modoAhorro(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(AhorroDeEnergia.getInstance());
	}
}
