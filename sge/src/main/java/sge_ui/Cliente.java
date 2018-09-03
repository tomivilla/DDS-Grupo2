package sge_ui;
import java.util.Date;
import java.util.List;

import dispositivo.AdaptadorDispositivo;
import dispositivo.Dispositivo;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;


public class Cliente extends Usuario implements ICliente {
	private int tipo_documento;
	private String numero_documento;
	private int telefono;
	private String domicilio; // Puede ser una cadena de domicilios?
	private Date fecha_de_alta_de_servicio; // Formato AAAAMMDD
	private Categoria categoria;
	private List <Dispositivo> dispositivos;
	private int puntos;

	//CONSTRUCTOR
	public Cliente(String unNombre, String unNmbUsuario, String unaContrasena, int unTipoDoc, String unNumDoc, int unTelefono,
				   String unDomicilio, Date unaFecha, Categoria unaCategoria, List<Dispositivo> nDispositivos) {
		this.setNombre(unNombre);
		this.setNombre_de_usuario(unNmbUsuario);
		this.setContrasena(unaContrasena);
		this.tipo_documento = unTipoDoc;
		this.numero_documento = unNumDoc;
		this.telefono = unTelefono;
		this.domicilio = unDomicilio;
		this.fecha_de_alta_de_servicio = unaFecha;
		categoria = unaCategoria;
		this.dispositivos = nDispositivos;
		this.puntos=0;
	}
	
	
	public boolean tenesAlgunDispositivoEncendido() {
		return dispositivos.stream().anyMatch(unDispositivo -> ((DispositivoInteligente) unDispositivo).estasEncendido());
	}
	public int totalDispositivosEncendidos() {
		return  (int) dispositivos.stream().filter(unDispositivo -> ((DispositivoInteligente) unDispositivo).estasEncendido()).count();
	}
	public int totalDispositivosApagados() {
		return  (int) dispositivos.stream().filter(unDispositivo -> !((DispositivoInteligente) unDispositivo).estasEncendido()).count();
	}
	public int totalDeDispositivos() {
		return this.totalDispositivosEncendidos() + this.totalDispositivosApagados();
	}

	public double consumoMensual() {
		 	double totalConsumo=0;
	        
	        // Sumo el consumo de cada uno de los dispositivos de este cliente
	        for (Dispositivo dispositivo : this.dispositivos) {
	        	totalConsumo += dispositivo.getConsumoKWHora();
	        }
	        return totalConsumo*30;
	}
	
	public void sumarPuntos(int puntos){
		this.puntos+=puntos;
	}
	
	public void setCategoria(Categoria unaCategoria){
		this.categoria = unaCategoria;
	}
	
	public void agregarDispositivo(DispositivoInteligente unDispositivo){
		this.dispositivos.add(unDispositivo);
		this.sumarPuntos(15);
	}
	
	public void agregarDispositivo(AdaptadorDispositivo unDispositivo){
		this.dispositivos.add(unDispositivo);
		this.sumarPuntos(10);
	}
	public void agregarDispositivo(Dispositivo unDispositivo){
		this.dispositivos.add(unDispositivo);
	}
	public boolean perteneceAcategoria(double unConsumo) {
		if (unConsumo > this.getCategoria().getConsumoMinimo() && unConsumo <= this.getCategoria().getConsumoMaximo())
	        return true;
	    else
	        return false;
	}
	
	public void agregarAdaptador(DispositivoEstandar unDispositivo, AdaptadorDispositivo unAdaptador){
		unAdaptador.setDispositivo(unDispositivo);
		this.agregarDispositivo(unAdaptador);
	}

	public int getTipo_documento() {
		return tipo_documento;
	}


	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}


	public String getNumero_documento() {
		return numero_documento;
	}


	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public Date getFecha_de_alta_de_servicio() {
		return fecha_de_alta_de_servicio;
	}


	public void setFecha_de_alta_de_servicio(Date fecha_de_alta_de_servicio) {
		this.fecha_de_alta_de_servicio = fecha_de_alta_de_servicio;
	}


	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}


	public Categoria getCategoria() {
		return categoria;
	}
	
	public int getPuntos() {
		return puntos;
	}

	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public Dispositivo getDispositivo(int n){
		return this.getDispositivos().get(n);
	}
}
