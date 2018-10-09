package beans;

import java.util.List;;

public class Regla {
	private int id;
	private List <Condicion> condiciones;
	private List <Accion> acciones;
	private DispositivoInteligente dispositivo;

	public Regla(List<Condicion> listCondiciones, List<Accion> listAcciones,DispositivoInteligente unDispositivo){
		this.setAcciones(listAcciones);
		this.setCondiciones(listCondiciones);
		this.setDispositivo(unDispositivo);
	}
	
	public boolean secumplenCondiciones(){
		boolean secumple = true;
		for(Condicion cond : this.getCondiciones()){
			if(!cond.cumple(this.getDispositivo())){
				secumple = false;
			}
		}
		return secumple;
	}
	
	public void ejecutarAcciones(){
		if(this.secumplenCondiciones()){
			for(Accion acc : this.getAcciones()){
				acc.ejecutarAccion(this.getDispositivo());
			}
		}
	}
	public boolean evaluar(){
		 boolean valid = this.secumplenCondiciones();
				 if(valid){
					 this.ejecutarAcciones();
				 }
		 return valid;
	}
	 
	public void recibirEstado(int estadoObserver) {
		//cambio el estado de Un sensor		
	}
	
	public List<Condicion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
	public List<Accion> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<Accion> acciones) {
		this.acciones = acciones;
	}
	
	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
