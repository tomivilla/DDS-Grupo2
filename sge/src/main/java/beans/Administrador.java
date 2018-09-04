package beans;

import java.text.ParseException;
import java.util.Date;

import fecha_helper.Fecha_Helper;
import sge_ui.IAdministrador;

public class Administrador extends Usuario implements IAdministrador {
	
	private String domicilio; //Cambiar nombre en diagrama
	private Date fechaDeAltaEnSistema; // Formato AAAA-MM-DD

	
	public Administrador(){
		
	}
	
	public Administrador(String unNombre, String unNmbUsuario, String unaContrasena, String unDomicilio, Date unaFecha) {
		this.setNombre(unNombre);
		this.setNombre_de_usuario(unNmbUsuario);
		this.setContrasena(unaContrasena);
		this.domicilio = unDomicilio;
		this.fechaDeAltaEnSistema = unaFecha;
	}
	
	
	
	public int cantidadDeMesesComoAdmin() throws ParseException {
		
		return Fecha_Helper.diferenciaEnMeses(this.fechaDeAltaEnSistema);
		
	}
	
	//GETTERS
	public String getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}



	public Date getFechaDeAltaEnSistema() {
		return fechaDeAltaEnSistema;
	}



	public void setFechaDeAltaEnSistema(Date fechaDeAltaEnSistema) {
		this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
	}


}
