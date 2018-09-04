package sge_ui;

import java.text.ParseException;
import java.util.Date;

public interface IAdministrador {

	public int cantidadDeMesesComoAdmin() throws ParseException;

	public String getDomicilio();
	public void setDomicilio(String domicilioAdministrador);
	public Date getFechaDeAltaEnSistema();
	public void setFechaDeAltaEnSistema(Date fechaDeAltaEnSistema);

}
