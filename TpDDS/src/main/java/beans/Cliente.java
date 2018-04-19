package beans;

import java.util.Calendar;
import java.util.List;

public class Cliente extends Usuario{

	private long telefono;
	
	private Direccion domicilioHogar;
	
	private Calendar fechaAlta;
	
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

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
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
	
	
}
