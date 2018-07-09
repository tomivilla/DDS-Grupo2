package dispositivosFactory;

import Estado.Encendido;
import Estado.Estado;
import dispositivo.DispositivoInteligente;
import dispositivo.Periodo;
import dispositivo.DispositivoEstandar;
import sensor.Sensor;

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
	
	public DispositivoInteligente crearDIBajoConsumo(String nombre,Double consumo,Estado estado,List<Sensor> sensores,List<Periodo> periodos){
		return new DispositivoInteligente(nombre,consumo,estado,sensores,periodos);
	}
	public DispositivoEstandar crearDIEstandar(String nombre,Double consumo,int horasEncendido){
		return new DispositivoEstandar(nombre,consumo,horasEncendido);
	}
	public DispositivoInteligente aireAcondicionado3500(){
		return crearDIBajoConsumo("Aire acondicionado 3500",1.613,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente aireAcondicionado2200(){
		return crearDIBajoConsumo("Aire acondicionado 2200",1.013,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar tvTubo21(){
		return crearDIEstandar("TV Tubo 21",0.075,0);
	}
	public DispositivoEstandar tvTubo29_34(){
		return crearDIEstandar("TV Tubo 29 a 34",0.175,0);
	}
	public DispositivoEstandar tvLCD40(){
		return crearDIEstandar("TV LCD 40",0.18,0);
	}
	public DispositivoInteligente tvLED24(){
		return crearDIBajoConsumo("TV LED 24",0.04,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente tvLED32(){
		return crearDIBajoConsumo("TV LED 32",0.055,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente tvLED40(){
		return crearDIBajoConsumo("TV LED 40",0.08,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente heladeraFreezer(){
		return crearDIBajoConsumo("Heladera con Freezer",0.09,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente heladera(){
		return crearDIBajoConsumo("Heladera sin freezer",0.075,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar lavarropas5kgCalendadorDeAgua(){
		return crearDIEstandar("Automático de 5 kg con calentamiento de agua",0.875,0);
	}
	public DispositivoInteligente lavarropas5k(){
		return crearDIBajoConsumo("Automático de 5 kg",0.175,Encendido.getInstance(),null,null);
	}
	public DispositivoEstandar lavarropasSemiAutomatico5kg(){
		return crearDIEstandar("Semi-automático de 5 kg",0.1275,0);
	}
	public DispositivoEstandar ventiladorDePie(){
		return crearDIEstandar("Ventilador de pie",0.09,0);
	}
	public DispositivoInteligente ventiladorDeTecho(){
		return crearDIBajoConsumo("Ventilador de techo",0.065,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena40w(){
		return crearDIBajoConsumo("Lampara Alogena de 40w",0.04,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena60w(){
		return crearDIBajoConsumo("Lampara Alogena de 60w",0.06, Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena100w(){
		return crearDIBajoConsumo("Lampara Alogena de 100w",0.015,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena11w(){
		return crearDIBajoConsumo("Lampara Alogena de 11w",0.011,Encendido.getInstance(),null,null);
	}
	public DispositivoInteligente lamparaAlogena15w(){
		return crearDIBajoConsumo("Lampara Alogena de 14w",0.015,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente lamparaAlogena20w(){
		return crearDIBajoConsumo("Lampara Alogena de 20w",0.02,Encendido.getInstance(),null,null);	
	}
	public DispositivoInteligente pcDeEscritorio(){
		return crearDIBajoConsumo("PC de Escritorio",0.4,Encendido.getInstance(),null,null);	
	}
	public DispositivoEstandar microondas(){
		return crearDIEstandar("Microondas convencional",0.64,0);
	}
	public DispositivoEstandar plancha(){
		return crearDIEstandar("Plancha a vapor",0.75,0);
	}
}


