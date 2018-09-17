package dispositivos_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Estado.Apagado;
import Estado.Encendido;
import actuador.ActuadorEstufa;
import beans.Actuador;
import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.SGE;
import dispositivo.AdaptadorDispositivo;
import implementador.ImplementadorEstufaLG;
import json_helper.Json_Helper;

public class Dispositivo_inteligente {
	private Categoria R1;
	private Categoria R2;
	private Categoria R3;
	private Categoria R4;
	private Categoria R5;
	private Categoria R6;
	private Categoria R7;
	private Categoria R8;
	private Categoria R9;
	private Administrador administrador;
	private SGE sge;
	private List<Cliente> clientes;
	private DispositivoInteligente di;
	private DispositivoEstandar de;
	private AdaptadorDispositivo adaptador;
	private Actuador actuador1;
	long inicio,fin;
	
	
    @Before
    public void setup() throws IOException{
    	this.sge = SGE.getInstance();
    	this.R1 = new Categoria(1, 0, 150, 18.76, 0.644);
    	this.R2 = new Categoria(2, 150, 325, 35.32, 0.644);
    	this.R3 = new Categoria(3, 325, 400, 60.71, 0.681);
    	this.R4 = new Categoria(4, 400, 450, 71.74, 0.738);
    	this.R5 = new Categoria(5, 450, 500, 110.38, 0.794);
    	this.R6 = new Categoria(6, 500, 600, 220.75, 0.832);
    	this.R7 = new Categoria(7, 600, 700, 443.59, 0.851);
    	this.R8 = new Categoria(8, 700, 1400, 545.96, 0.851);
    	this.R9 = new Categoria(9, 1400, Integer.MAX_VALUE, 887.19, 0.851);
    	this.administrador = new Administrador("Juan Carlos Perez", "admin", "contraseña123", "Calle Falsa 321", new Date());
    	this.sge.agregarCategoria(R1); 
    	this.sge.agregarCategoria(R2);
    	this.sge.agregarCategoria(R3);
    	this.sge.agregarCategoria(R4);
    	this.sge.agregarCategoria(R5);
    	this.sge.agregarCategoria(R6);
    	this.sge.agregarCategoria(R7);
    	this.sge.agregarCategoria(R8);
    	this.sge.agregarCategoria(R9);
    	this.sge.agregarAdministrador(administrador);
    	
    	this.sge.agregarActuador(actuador1);
    	
    	
    	//Se cargan los clientes jusnto con sus dispositivos_estandar desde el Jason "datos.json"
    	clientes = new ArrayList<Cliente>();
    	clientes = Json_Helper.JsonToCliente("datos.json");
    	this.sge.setearClientes(clientes);
    	//Tomo uno de el 8vo dispositivo inteligente que se cargó desde el JSON, para el cliente 2
    	di = (DispositivoInteligente) clientes.get(2).getDispositivoInteligente(8);
    	de = (DispositivoEstandar) clientes.get(2).getDispositivoEstandar(3);
    	adaptador = new AdaptadorDispositivo(0L, null, 0, Encendido.getInstance(), null, null, de);
    	this.actuador1 = new ActuadorEstufa("AD:12:34:12:42:12",adaptador,new ImplementadorEstufaLG());
    	fin=di.getPeriodos().get(1).getHoraFin();
    	inicio=di.getPeriodos().get(1).getHoraInicio();
    	clientes.get(2).agregarAdaptador(de, adaptador); //Suma 10 Puntos por agregar un adaptador
    	clientes.get(2).agregarDispositivo(di); //Suma 15 Puntos por agregar un Dispositivo Inteligente
    
    }
    
    
    @Test
    //Verifico carga y comportamiento de dispositivos_inteligentes
    public void dispositivosInteligentesTest() {    
    	Assert.assertEquals("Consumo maximo 'R5'", 1526979600, di.getPeriodos().get(1).getHoraInicio());
    	Assert.assertEquals("Consumo maximo 'R5'", 1526983200, di.getPeriodos().get(1).getHoraFin());
    	Assert.assertEquals("Consumo maximo 'R5'", 3600, di.getPeriodos().get(1).getHoraFin()-di.getPeriodos().get(1).getHoraInicio());
    	
    	Assert.assertEquals("Consulta de estado 'di'", true, di.getEstado().estasEncendido());
    	Assert.assertEquals("Consulta de estado'di'", false, di.getEstado().estasApagado());
    	Assert.assertEquals("Cantidad de puntos 'Cliente 3' deberia ser 25", 25, clientes.get(2).getPuntos());
    	//0.182*2=0.364
    	assertEquals(0.364,di.tuConsumo(),0.0);
    	//Verifico que se hayan cargado 2 periodos
    	assertEquals(2.0,di.getPeriodos().size(),0.0);
    }
    
    @Test
    //Verifico comportamiento de las clases de Estado
    public void estateTest() {
    Assert.assertEquals("Consumo maximo 'R5'", true, Encendido.getInstance().estasEncendido());
	Assert.assertEquals("Consumo maximo 'R5'", false, Apagado.getInstance().estasEncendido());
    }
}
