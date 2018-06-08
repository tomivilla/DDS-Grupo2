package dispositivos_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import json_helper.Json_Helper;
import sge_ui.Administrador;
import sge_ui.Categoria;
import sge_ui.Cliente;
import sge_ui.SGE;

public class Dispositivo_estandar {

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
    	
    	//Se cargan los clientes jusnto con sus dispositivos_estandar desde el Jason "datos.json"
    	clientes = new ArrayList<Cliente>();
    	clientes = Json_Helper.JsonToCliente("datos.json");
    	this.sge.setearClientes(clientes);

    }
    
    @Test
    //Se deben obtener 3 clientes cagados del "datos.json" en memosria con sus respectivos dispositivos
    public void debeDevolverelconsumoPromedio() {    
        //Verifico elduncionamiento del metodo tuConsumo() para un dispositivo estandar
    	//para el cliente 3, debe ser 1.274.
    	assertEquals(1.274,clientes.get(2).getDispositivo(2).tuConsumo(),0.0);
    }

}
