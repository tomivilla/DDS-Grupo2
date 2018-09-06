package dispositivos_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Estado.Encendido;
import actuador.ActuadorHeladera;
import beans.Accion;
import beans.Actuador;
import beans.Condicion;
import beans.DispositivoInteligente;
import beans.Periodo;
import beans.Regla;
import beans.Sensor;
import implementador.ImplementadorHeladeraLG;
import observer.ObserverSensor;
import regla.Apagar;
import regla.CondicionSinMovimiento;
import regla.CondicionTemperaturaAlta;
import regla.CondicionTemperaturaBaja;
import regla.Encender;
import regla.PasarAModoAhorro;
import sensor.SensorDeMovimiento;
import sensor.SensorHumedad;
import sensor.SensorIntensidadLuminica;
import sensor.SensorTemperatura;

public class Dispositivo_inteligente2 {

	private DispositivoInteligente heladera;
	private Actuador actuador1;
	private Periodo p1,p2,p3,p4,p5,p6,p7,p8;
	private List<Periodo> periodos;
	private SensorDeMovimiento sMov;
	private SensorHumedad sHume;
	private SensorIntensidadLuminica sIntLum;
	private SensorTemperatura sTemp;
	private ObserverSensor ObsSensorTemp, ObsSensorMov;
	private Regla r1;
	private Accion accionApagar,accionEncender,accionModoaAhorro;
	private Condicion condicionTemperaturaBaja,condicionTemperaturaAlta,condicionSinMovimiento;
	private List<Sensor> sensores;
	private List<Accion> acciones1,acciones2,acciones3;
	private List<Condicion> condiciones1,condiciones2,subscritores,subscritores2;
	@Before
    public void setup(){
		this.p1 = new Periodo(1526680200,1526683800);//1 Hora
		this.p2 = new Periodo(1526410200,1526510200);//27 Horas Inicio 05/15/2018 @ 6:50pm (UTC) ; Fin 05/16/2018 @ 10:36pm (UTC)
		this.p3 = new Periodo(1526520200,1526680200);//44 Horas Inicio 05/17/2018 @ 1:23am (UTC) ; Fin 05/18/2018 @ 9:50pm (UTC)
		this.p4 = new Periodo(1526680200,1526683800);//1 Hora
		this.p5 = new Periodo(1526680200,1526683800);//1 Hora
		this.p6 = new Periodo(1526680200,1526683800);//1 Hora
		this.p7 = new Periodo(1526680200,1526683800);//1 Hora
		this.p8 = new Periodo(1526680200,1526683800);//1 Hora
		this.accionApagar = new Apagar();
		this.accionEncender = new Encender();
		this.accionModoaAhorro = new PasarAModoAhorro();
		this.periodos = new ArrayList<Periodo>();
		this.periodos.add(p1);
		this.periodos.add(p2);
		this.periodos.add(p3);
		this.periodos.add(p4);
		this.periodos.add(p5);
		this.periodos.add(p6);
		this.periodos.add(p7);
		this.periodos.add(p8);
		this.sensores = new ArrayList<Sensor>();
		this.sMov = new SensorDeMovimiento(0,"Movimieto");
		this.sHume = new SensorHumedad(25,"%");
		this.sIntLum= new SensorIntensidadLuminica(1000,"Lums");
		this.sTemp = new SensorTemperatura(14,"°C");
		this.condicionTemperaturaBaja = new CondicionTemperaturaBaja();
		this.condicionTemperaturaAlta = new CondicionTemperaturaAlta();
		this.condicionSinMovimiento = new CondicionSinMovimiento(); 
		this.sensores.add(sMov);
		this.sensores.add(sHume);
		this.sensores.add(sTemp);
		this.sensores.add(sIntLum);
		this.acciones1 = new ArrayList<Accion>();
		this.acciones2 = new ArrayList<Accion>();
		this.acciones3 = new ArrayList<Accion>();
		this.acciones1.add(accionApagar);
		this.acciones2.add(accionModoaAhorro);
		this.acciones3.add(accionEncender);
		this.condiciones1 = new ArrayList<Condicion>();
		this.condiciones2 = new ArrayList<Condicion>();
		this.subscritores = new ArrayList<Condicion>();
		this.subscritores2 = new ArrayList<Condicion>();
		this.condiciones1.add(condicionTemperaturaBaja);
		this.condiciones1.add(condicionSinMovimiento);
		this.condiciones2.add(condicionTemperaturaAlta);
		this.subscritores.add(condicionTemperaturaBaja);
		this.subscritores.add(condicionTemperaturaAlta);
		this.subscritores2.add(condicionSinMovimiento);
		this.ObsSensorTemp = new ObserverSensor(subscritores);
		this.ObsSensorMov = new ObserverSensor(subscritores2);
		this.sTemp.adscribir(ObsSensorTemp);
		this.sMov.adscribir(ObsSensorMov);
		this.sTemp.medirMagnitud();
		this.sMov.medirMagnitud();
		
		this.heladera = new DispositivoInteligente(25L, "Heladera LG", 0.230,Encendido.getInstance(),sensores,periodos);
		this.actuador1 = new ActuadorHeladera("AD:12:34:12:42:12",heladera,new ImplementadorHeladeraLG());
		//temperatura menor a 15° y sin movimiento --> ejecuta accion apagar sobre dispositivo 'di'
		this.r1= new Regla(condiciones1,acciones1,heladera);
	}
	
	@Test
	public void testPeriodos() {
		//8 periodos cargados
		assertEquals(8.0,heladera.getPeriodos().size(),0.0);
		//0.230*77=17.71 kwH
		assertEquals(17.71,heladera.tuConsumo(),0.0);
		//44 Horas Inicio 05/17/2018 @ 1:23am (UTC) ; Fin 05/18/2018 @ 9:50pm (UTC)
		Assert.assertEquals("Horas transcurridas 'p3'", 44, p3.horasTranscurridas());
		//Energia consumida en 27 horas --> 27*0.230=6.21
		assertEquals(6.21,heladera.cuantoConsumisteEnPeriodo(p2),0.0);
		//Esta se comenta por va variando segun la hora a la que preguntes
		//assertEquals(6.21,di.cuanConsumisteEnHoras(120),0.0);
	}
	@Test
	public void testEncendido() {
		Assert.assertEquals("El dispositivo esta prendido", true ,heladera.estasEncendido());
		this.heladera.apagar();
		Assert.assertEquals("El dispositivo esta apagado", false ,heladera.estasEncendido());
		this.heladera.encender();
		Assert.assertEquals("El dispositivo esta prendido", false ,heladera.estasApagado());
		this.heladera.modoAhorro();
		Assert.assertEquals("El dispositivo esta prendido", false ,heladera.estasApagado());
		actuador1.apagar();
		Assert.assertEquals("El dispositivo esta prendido", true ,heladera.estasApagado());
		actuador1.encender();
		Assert.assertEquals("El dispositivo esta prendido", false ,heladera.estasApagado());
	}
	@Test
	public void testReglas() {
		this.heladera.encender();
		Assert.assertEquals("Se cumplen las condiciones", true ,r1.secumplenCondiciones());
		this.r1.ejecutarAcciones();
		Assert.assertEquals("El dispositivo esta prendido", true ,heladera.estasApagado());
	}
}
