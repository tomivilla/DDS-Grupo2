package Estado;

import beans.DispositivoInteligente;

public interface iEstado {
	public boolean estasEncendido();
	public boolean estasApagado();
	public void apagar(DispositivoInteligente dispositivoInteligente);
	public void encender(DispositivoInteligente dispositivoInteligente);
	public void modoAhorro(DispositivoInteligente dispositivoInteligente);
}
