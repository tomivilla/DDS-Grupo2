package beans;

import regla.iAccion;

public class Accion implements iAccion {

	private int id;
	private String nombre;
	@Override
	public void ejecutarAccion(DispositivoInteligente unDispositivo) {
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
