package dispositivo;

import java.util.List;

import Estado.*;

public class DispositivoAdapter extends DispositivoInteligente{

	private DispositivoEstandar dispositivoEstandar;
	public DispositivoAdapter(Adaptador adaptador) {
	 super();	
	 dispositivoEstandar = new DispositivoEstandar();		
	 Estado estado = Encendido.getInstance();
	 this.setEstado(estado);
	 //al momento de hacer la adaptacion no voy a administrar ningun sensor ni voy a tener periodos activos aun.
	 this.setSensores(null);
	 this.setPeriodos(null);
	 this.setNombre_generico(dispositivoEstandar.getNombre_generico());
	 this.setConsumoKWHora(dispositivoEstandar.getConsumoKWHora());
	 this.setAdaptador(adaptador);
	}	
	
}
