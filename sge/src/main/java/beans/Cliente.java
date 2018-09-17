package beans;

import java.util.Date;
import java.util.List;

import dispositivo.AdaptadorDispositivo;

public class Cliente extends Usuario {

	private Documento documento;
	private String numero_documento;
	private int telefono;
	private String domicilio;
	private Date fecha_de_alta_de_servicio;
	private Categoria categoria;
	private List<DispositivoEstandar> dispositivosEstandar;
	private List<DispositivoInteligente> dispositivosInteligentes;
	private int puntos;

	// CONSTRUCTOR

	public Cliente() {

	}

	public Cliente(String nombre, String nombre_de_usuario, String contrasena, Documento documento,
			String numero_documento, int telefono, String domicilio, Date fecha_de_alta_de_servicio,
			Categoria categoria, List<DispositivoEstandar> dispositivosEstandar,
			List<DispositivoInteligente> dispositivosInteligentes) {
		super(nombre, nombre_de_usuario, contrasena);
		this.documento = documento;
		this.numero_documento = numero_documento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fecha_de_alta_de_servicio = fecha_de_alta_de_servicio;
		this.categoria = categoria;
		this.dispositivosEstandar = dispositivosEstandar;
		this.dispositivosInteligentes = dispositivosInteligentes;
		this.puntos = 0;
	}

	public boolean tenesAlgunDispositivoEncendido() {
		return dispositivosInteligentes.stream()
				.anyMatch(unDispositivo -> ((DispositivoInteligente) unDispositivo).estasEncendido());
	}

	public int totalDispositivosEncendidos() {
		return (int) dispositivosInteligentes.stream()
				.filter(unDispositivo -> ((DispositivoInteligente) unDispositivo).estasEncendido()).count();
	}

	public int totalDispositivosApagados() {
		return (int) dispositivosInteligentes.stream()
				.filter(unDispositivo -> !((DispositivoInteligente) unDispositivo).estasEncendido()).count();
	}

	public int totalDeDispositivos() {
		return this.totalDispositivosEncendidos() + this.totalDispositivosApagados();
	}

	public double consumoMensual() {
		double totalConsumo = 0;

		// Sumo el consumo de cada uno de los dispositivos de este cliente
		for (DispositivoEstandar dispositivo : this.dispositivosEstandar) {
			totalConsumo += dispositivo.getConsumoKWHora();
		}

		for (DispositivoInteligente dispositivo : this.dispositivosInteligentes) {
			totalConsumo += dispositivo.getConsumoKWHora();
		}
		return totalConsumo * 30;
	}

	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public void setCategoria(Categoria unaCategoria) {
		this.categoria = unaCategoria;
	}

	public void agregarDispositivo(DispositivoInteligente unDispositivo) {
		this.dispositivosInteligentes.add(unDispositivo);
		this.sumarPuntos(15);
	}

	public void agregarDispositivo(AdaptadorDispositivo unDispositivo) {
		this.dispositivosInteligentes.add(unDispositivo);
		this.sumarPuntos(10);
	}

	public void agregarDispositivo(DispositivoEstandar unDispositivo) {
		this.dispositivosEstandar.add(unDispositivo);
	}

	public boolean perteneceAcategoria(double unConsumo) {
		if (unConsumo > this.getCategoria().getConsumoMinimo() && unConsumo <= this.getCategoria().getConsumoMaximo())
			return true;
		else
			return false;
	}

	public void agregarAdaptador(DispositivoEstandar unDispositivo, AdaptadorDispositivo unAdaptador) {
		unAdaptador.setDispositivo(unDispositivo);
		this.agregarDispositivo(unAdaptador);
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
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

	public List<DispositivoEstandar> getDispositivosEstandar() {
		return dispositivosEstandar;
	}

	public void setDispositivosEstandar(List<DispositivoEstandar> dispositivosEstandar) {
		this.dispositivosEstandar = dispositivosEstandar;
	}

	public List<DispositivoInteligente> getDispositivosInteligentes() {
		return dispositivosInteligentes;
	}

	public void setDispositivosInteligentes(List<DispositivoInteligente> dispositivosInteligentes) {
		this.dispositivosInteligentes = dispositivosInteligentes;
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

	public DispositivoEstandar getDispositivoEstandar(int n) {
		return this.dispositivosEstandar.get(n);
	}

	public Dispositivo getDispositivoInteligente(int n) {
		return this.dispositivosInteligentes.get(n);
	}
}
