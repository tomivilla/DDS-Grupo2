package regla;

import beans.Dispositivo;

public interface iCondicion{
	public boolean cumple(Dispositivo unDispositivo);
	public boolean evaluar(Double valor);
}
