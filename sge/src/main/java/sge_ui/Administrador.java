package sge_ui;

import java.text.ParseException;

import fecha_helper.Fecha_Helper;

public class Administrador extends Usuario implements IAdministrador {
	
	private String domicilioAdministrador; //Cambiar nombre en diagrama
	private String fechaDeAltaEnSistema; // Formato AAAA-MM-DD
	private int idSistema; //Agregar al Diagrama

	
	public Administrador(String unNombre, String unNmbUsuario, String unaContrasena, String unDomicilio, String unaFecha, int unID) {
		this.setNombre(unNombre);
		this.setNombre_de_usuario(unNmbUsuario);
		this.setContrasena(unaContrasena);
		this.domicilioAdministrador = unDomicilio;
		this.fechaDeAltaEnSistema = unaFecha;
		this.idSistema = unID;
	}
	
	
	
	public int cantidadDeMesesComoAdmin() throws ParseException {
		
		return Fecha_Helper.diferenciaEnMeses(this.fechaDeAltaEnSistema);
		
	}
	
	//GETTERS
	public String getDomicilioAdministrador() {
		return domicilioAdministrador;
	}



	public void setDomicilioAdministrador(String domicilioAdministrador) {
		this.domicilioAdministrador = domicilioAdministrador;
	}



	public String getFechaDeAltaEnSistema() {
		return fechaDeAltaEnSistema;
	}



	public void setFechaDeAltaEnSistema(String fechaDeAltaEnSistema) {
		this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
	}



	public int getIdSistema() {
		return idSistema;
	}



	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}
	
}
