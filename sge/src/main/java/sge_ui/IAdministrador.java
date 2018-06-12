package sge_ui;

import java.text.ParseException;

public interface IAdministrador {

	public int cantidadDeMesesComoAdmin() throws ParseException;

	public String getDomicilioAdministrador();
	public void setDomicilioAdministrador(String domicilioAdministrador);
	public String getFechaDeAltaEnSistema();
	public void setFechaDeAltaEnSistema(String fechaDeAltaEnSistema);
	public int getIdSistema();
	public void setIdSistema(int idSistema);

}
