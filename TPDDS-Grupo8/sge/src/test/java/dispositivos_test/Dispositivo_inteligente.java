package dispositivos_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Estado.Apagado;
import Estado.Encendido;
import actuador.Actuador;
import actuador.ActuadorEstufa;
import dispositivo.*;
import implementador.ImplementadorEstufaLG;
import json_helper.Json_Helper;
import sge_ui.Administrador;
import sge_ui.Categoria;
import sge_ui.Cliente;
import sge_ui.SGE;

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
	private Actuador actuador1;
	private Adaptador adaptador;
	long inicio,fin;
	
	
    @Before
    public void setup() throws IOException{
    	this.sge = SGE.getInstance();
    	this.R1 = new Categoria(0, 150, 18.76, 0.644);
    	this.R2 = new Categoria(150, 325, 35.32, 0.644);
    	this.R3 = new Categoria(325, 400, 60.71, 0.681);
    	this.R4 = new Categoria(400, 450, 71.74, 0.738);
    	this.R5 = new Categoria(450, 500, 110.38, 0.794);
    	this.R6 = new Categoria(500, 600, 220.75, 0.832);
    	this.R7 = new Categoria(600, 700, 443.59, 0.851);
    	this.R8 = new Categoria(700, 1400, 545.96, 0.851);
    	this.R9 = new Categoria(1400, Integer.MAX_VALUE, 887.19, 0.851);
    	this.administrador = new Administrador("Juan Carlos Perez", "admin", "contraseña123", "Calle Falsa 321", "2016-07-23", 01);
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
    	di = (DispositivoInteligente) clientes.get(2).getDispositivo(8);
    	de = (DispositivoEstandar) clientes.get(2).getDispositivo(3);
    	adaptador = new Adaptador();
    	this.actuador1 = new ActuadorEstufa("AD:12:34:12:42:12",di,new ImplementadorEstufaLG());
    	fin=di.getPeriodos().get(1).getHoraFin();
    	inicio=di.getPeriodos().get(1).getHoraInicio();
    	//clientes.get(2).agregarAdaptador(de, adaptador); //Suma 10 Puntos por agregar un adaptador
    	clientes.get(2).agregarDispositivo(di); //Suma 15 Puntos por agregar un Dispositivo Inteligente
    
    }
    
    @Test
    //Verifico carga y comportamiento de dispositivos_inteligentes
    public void dispositivosInteligentesTest() {    
    	Assert.assertEquals("Consumo maximo 'R5'", 1526979600, di.getPeriodos().get(1).getHoraInicio());
    	Assert.assertEquals("Consumo maximo 'R5'", 1526983200, di.getPeriodos().get(1).getHoraFin());
    	Assert.assertEquals("Consumo maximo 'R5'", 3600, di.getPeriodos().get(1).getHoraFin()-di.getPeriodos().get(1).getHoraInicio());
    	Assert.assertEquals("Consumo maximo 'R5'", true, Encendido.getInstance().estasEncendido());
    	Assert.assertEquals("Consumo maximo 'R5'", false, Apagado.getInstance().estasEncendido());
    	Assert.assertEquals("Consumo maximo 'R5'", true, di.getEstado().estasEncendido());
    	Assert.assertEquals("Consumo maximo 'R5'", false, di.getEstado().estasApagado());
    	Assert.assertEquals("Cantidad de puntos 'Cliente 3' deberia ser 25", 25, clientes.get(2).getPuntos());
    	//0.182*2=0.364
    	assertEquals(0.364,di.tuConsumo(),0.0);
    	//tiene 2 periodos
    	assertEquals(2.0,di.getPeriodos().size(),0.0);
    	
    }
}
