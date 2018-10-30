package beans;

import java.util.List;

public class ResponseDispositivos {

	private List<DispositivoEstandar> dispositivosEstandar;

	private List<DispositivoInteligente> dispositivosInteligentes;

	public List<DispositivoEstandar> getDispositivosEstandar() {
		return dispositivosEstandar;
	}

	public void setDispositivosEstandar(List<DispositivoEstandar> dispositivosEstandar) {
		this.dispositivosEstandar = dispositivosEstandar;
	}

	public List<DispositivoInteligente> getDispositivosInteligentes() {
		return dispositivosInteligentes;
	}

	public void setDispositivosInteligentes(List<DispositivoInteligente> dispositivosInteligentes) {
		this.dispositivosInteligentes = dispositivosInteligentes;
	}

}
