package beans;

import Estado.AhorroDeEnergia;
import Estado.Apagado;
import Estado.Encendido;
import Estado.iEstado;

public abstract class Estado implements iEstado {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public static Estado seleccionarEstado(String estado) {
		if(estado.equals("Encendido")){
			return Encendido.getInstance();
		}
		else{
			if(estado.equals("ModoAhorro")){
				return AhorroDeEnergia.getInstance();
			}
			else{
				return Apagado.getInstance();
			}
		}
	}

}
