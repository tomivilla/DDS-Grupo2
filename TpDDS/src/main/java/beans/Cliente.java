package beans;

import java.util.*;

public class Cliente extends Usuario{

	private long telefono;
	
	private Direccion domicilioHogar;
	private Date fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	private List<Adaptador> adaptadores = new ArrayList<Adaptador>();
	private Transformador transformador;
	private int puntos = 0;
	private List<Regla> reglas = new ArrayList<Regla>();
	
	public DispositivoInteligente convertirDispositivo(DispositivoEstandar dispositivoAConvertir, Adaptador adaptador)  {
    //Lanzar excepcion en caso que no exista en listas 
	if(ExisteEnLista(dispositivoAConvertir) && ExisteEnLista(adaptador)) {
		DispositivoInteligenteAdapter adapter = new DispositivoInteligenteAdapter(dispositivoAConvertir,adaptador);
		this.puntos =+ 10;
		return adapter;
    }
		return null;
	}
	
	public void CrearRegla() {
		// elijo un dispositivo al que se le va a aplicar la regla.
		
		Regla reg = new Regla(dispositivos);
		reg.AgregarAcciones(GetAccionesAatender());
		reg.agregarMediciones(GetSensoresAatender());
		reglas.add(reg);
		
		
	}
	
	private List<Sensor> GetSensoresAatender(){
		Scanner scan = new Scanner(System.in);
		List<Sensor> sendores = new ArrayList<Sensor>();
		System.out.println("Ingrese Unidad de tiempo");
		String unidadTiempo = scan.next();
		System.out.println("Ingrese magnitud");
		String magnitud = scan.next();
		Sensor unSensor = new Sensor(unidadTiempo, magnitud);
		sendores.add(unSensor);
		scan.close();
		return sendores;
	}
	
	private List<Actuador> GetAccionesAatender(){
		Scanner scan = new Scanner(System.in);
		List<Actuador> acciones = new ArrayList<Actuador>();
		
		System.out.println("Ingrese la acciones de la regla");
		String accionNombre = scan.next();
		Actuador accion = null;
		 switch(accionNombre) {
		 case "Apagar Dispositivo": 
			 accion = new ApagarDispositivo();
		 case "Encender Dispositivo":
			 accion = new EncenderDispositivo();
		 case "Encender Modo Ahorro":
		 accion = new EncenderModoAhorro();
		 }
		 if(accion != null) {
	      	acciones.add(accion);
		}
		scan.close();

		return acciones;
	}
	
	public void RegistrarDispositivo(DispositivoInteligente dispositivo) {
		dispositivo.setRegistrado(true);
		this.puntos =+ 15;
	}
	

	private boolean ExisteEnLista( DispositivoEstandar dispositivo) {
		for(Dispositivo dis :dispositivos ) {
				if(dispositivo.getFabricante().getIdFabricante()== dis.getFabricante().getIdFabricante()) {
					return true;
				}
			
		}
		return false;
	}
	
	private boolean ExisteEnLista( Adaptador adaptador) {
		for(Adaptador ad :adaptadores ) {
			if(ad.getId() == adaptador.getId()) {
					return true;
				}
			}
		return false;
	}
	
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
		 if(dispositivo instanceof DispositivoInteligente)	
			if (((DispositivoInteligente) dispositivo).isEncendido()) {
				respuesta = true;
			}
		}
		
		return respuesta;
	}
	
	public int getCantidadDispositivosEncendidos() {
		
		int cantidad = 0;
		
		for (Dispositivo dispositivo : getDispositivos()) {
		   if(dispositivo instanceof DispositivoInteligente)	
			if (((DispositivoInteligente) dispositivo).isEncendido()) {
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

	public List<Adaptador> getAdaptadores() {
		return adaptadores;
	}

	public void setAdaptadores(List<Adaptador> adaptadores) {
		this.adaptadores = adaptadores;
	}

	public int getPuntos() {
		return puntos;
	}


	
}
