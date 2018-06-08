package Estado;

import dispositivo.DispositivoInteligente;

public class Encendido extends Estado{
	private static Encendido encendido;
	
	private Encendido(){
		
	}
	
	public static Encendido getInstance() {
        if (encendido == null) {
        	encendido = new Encendido();
        }
        return encendido;
    }

	public void apagar(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(Apagado.getInstance());
	}

	public void encender(DispositivoInteligente dispositivoInteligente) {
	}

	public void modoAhorro(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.setEstado(AhorroDeEnergia.getInstance());		
	}
	
	public boolean estasEncendido() {
		return true;
	}

	public boolean estasApagado() {
		return false;
	}
}
