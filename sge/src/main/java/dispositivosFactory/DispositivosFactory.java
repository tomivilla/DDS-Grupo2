package dispositivosFactory;

import Estado.Encendido;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Estado;
import beans.Periodo;
import beans.Sensor;

import java.util.List;



public class DispositivosFactory {

	private static DispositivosFactory dispositivoFactory;

	private DispositivosFactory(){
		
	}

	public static DispositivosFactory getInstance() {
	    if (dispositivoFactory == null) {
	    	dispositivoFactory = new DispositivosFactory();
	    }
	    return dispositivoFactory;
	}
	
	public DispositivoInteligente crearDIBajoConsumo(Long id, String nombre,Double consumo,Estado estado,List<Sensor> sensores,List<Periodo> periodos){
		return new DispositivoInteligente(id, nombre,consumo,estado,sensores,periodos);
	}
	public DispositivoEstandar crearDIEstandar(Long id, String nombre,Double consumo,int horasEncendido){
		return new DispositivoEstandar(id, nombre,consumo,horasEncendido);
	}
	public DispositivoInteligente aireAcondicionado3500(){
		return crearDIBajoConsumo(1L, "Aire acondicionado 3500",1.613,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente aireAcondicionado2200(){
		return crearDIBajoConsumo(2L, "Aire acondicionado 2200",1.013,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar tvTubo21(){
		return crearDIEstandar(3L, "TV Tubo 21",0.075,0);
	}
	public DispositivoEstandar tvTubo29_34(){
		return crearDIEstandar(4L, "TV Tubo 29 a 34",0.175,0);
	}
	public DispositivoEstandar tvLCD40(){
		return crearDIEstandar(5L, "TV LCD 40",0.18,0);
	}
	public DispositivoInteligente tvLED24(){
		return crearDIBajoConsumo(6L, "TV LED 24",0.04,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente tvLED32(){
		return crearDIBajoConsumo(7L, "TV LED 32",0.055,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente tvLED40(){
		return crearDIBajoConsumo(8L, "TV LED 40",0.08,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente heladeraFreezer(){
		return crearDIBajoConsumo(9L, "Heladera con Freezer",0.09,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente heladera(){
		return crearDIBajoConsumo(10L, "Heladera sin freezer",0.075,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar lavarropas5kgCalendadorDeAgua(){
		return crearDIEstandar(11L, "Automático de 5 kg con calentamiento de agua",0.875,0);
	}
	public DispositivoInteligente lavarropas5k(){
		return crearDIBajoConsumo(12L, "Automático de 5 kg",0.175,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar lavarropasSemiAutomatico5kg(){
		return crearDIEstandar(13L, "Semi-automático de 5 kg",0.1275,0);
	}
	public DispositivoEstandar ventiladorDePie(){
		return crearDIEstandar(14L, "Ventilador de pie",0.09,0);
	}
	public DispositivoInteligente ventiladorDeTecho(){
		return crearDIBajoConsumo(15L, "Ventilador de techo",0.065,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena40w(){
		return crearDIBajoConsumo(16L, "Lampara Alogena de 40w",0.04,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena60w(){
		return crearDIBajoConsumo(17L, "Lampara Alogena de 60w",0.06, Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena100w(){
		return crearDIBajoConsumo(18L, "Lampara Alogena de 100w",0.015,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena11w(){
		return crearDIBajoConsumo(19L, "Lampara Alogena de 11w",0.011,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena15w(){
		return crearDIBajoConsumo(20L, "Lampara Alogena de 14w",0.015,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena20w(){
		return crearDIBajoConsumo(21L, "Lampara Alogena de 20w",0.02,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente pcDeEscritorio(){
		return crearDIBajoConsumo(22L, "PC de Escritorio",0.4,Encendido.getInstance(),null,null);	
	}
	public DispositivoEstandar microondas(){
		return crearDIEstandar(23L, "Microondas convencional",0.64,0);
	}
	public DispositivoEstandar plancha(){
		return crearDIEstandar(24L, "Plancha a vapor",0.75,0);
	}
}


