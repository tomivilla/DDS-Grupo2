package beans;

import java.util.Date;
import java.util.List;

public class Cliente extends Usuario{

	private long telefono;
	
	private Direccion domicilioHogar;
	
	private Date fechaAlta;
	
	private Categoria categoria;
	
	private List<Dispositivo> dispositivos;
	
	private Transformador transformador;

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Direccion getDomicilioHogar() {
		return domicilioHogar;
	}

	public void setDomicilioHogar(Direccion domicilioHogar) {
		this.domicilioHogar = domicilioHogar;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Transformador getTransformador() {
		return transformador;
	}

	public void setTransformador(Transformador transformador) {
		this.transformador = transformador;
	}
	
	public boolean hayDispositivoEncendido() {
		
		boolean respuesta = false;
		
		for (Dispositivo dispositivo : getDispositivos()) {
			if (dispositivo.isEncendido()) {
				respuesta = true;
			}
		}
		
		return respuesta;
	}
	
	public int getCantidadDispositivosEncendidos() {
		
		int cantidad = 0;
		
		for (Dispositivo dispositivo : getDispositivos()) {
			if (dispositivo.isEncendido()) {
				cantidad ++;
			}
		}
		
		return cantidad;
	}
	
	public int getCantidadDispositivosApagados() {
		
		int cantidad = 0;
		
		cantidad = getCantidadDispositivos() - this.getCantidadDispositivosEncendidos();
		
		return cantidad;
	}
	
	public int getCantidadDispositivos() {
		
		return getDispositivos().size();
	}
}
