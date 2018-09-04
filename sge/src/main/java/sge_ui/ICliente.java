package sge_ui;

import java.util.Date;
import java.util.List;

import beans.Categoria;
import beans.Dispositivo;

public interface ICliente {

	
	public boolean tenesAlgunDispositivoEncendido();
	public int totalDispositivosEncendidos();
	public int totalDispositivosApagados();
	public int totalDeDispositivos();	
	public void setCategoria(Categoria unaCategoria);
	public void agregarDispositivo(Dispositivo unDispositivo);
	public boolean perteneceAcategoria(double unConsumo);
	public int getTipo_documento();
	public void setTipo_documento(int tipo_documento);
	public String getNumero_documento();
	public void setNumero_documento(String numero_documento);
	public int getTelefono();
	public void setTelefono(int telefono);
	public String getDomicilio();
	public void setDomicilio(String domicilio);
	public Date getFecha_de_alta_de_servicio();
	public void setFecha_de_alta_de_servicio(Date fecha_de_alta_de_servicio);
	public List<Dispositivo> getDispositivos();
	public void setDispositivos(List<Dispositivo> dispositivos);
	public Categoria getCategoria();
	
}
