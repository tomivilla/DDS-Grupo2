package sge_ui;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.SGE;
import json_helper.Json_Helper;

public class SGETest {

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
    	
    	//Se cargan los clientes jusnto con sus dispositivos desde el Jason "datos.json"
    	clientes = new ArrayList<Cliente>();
    	clientes = Json_Helper.JsonToCliente("datos.json");
    	this.sge.setearClientes(clientes);
    	//Se recategorizan los clientes
    	this.sge.recategorizarClientes();
    	
    	
    }
    
    @Test
    //Se deben obtener 3 clientes cagados del "datos.json" en memosria con sus respectivos dispositivos
    public void debeDevolverJSONEnUnObjeto() throws IOException {
        
    	assertEquals("Cantidad de clientes",3, sge.getClientes().size());
        //Verifico correcta carga de nombre del cliente 1
    	assertEquals("Nombre de Cliente 1 'Juan Perez'","Juan Perez", clientes.get(0).getNombre());
        //Verifico correcta carga de cliente 2
    	assertEquals("Domicilio Cliente 2 'Calle Falsa 789'","Calle Falsa 789", clientes.get(1).getDomicilio());
        //Verifico Corrcta cantidad de dispositivos cliente 3, debe ser 6.
    	assertEquals("Cantidad de dispositivos cargados en el cliente 3 '12'",12, clientes.get(2).getDispositivos().size());
     
    }
    
    @Test
	public void GeneralTest() throws ParseException {
    	//Verifico que contenga 9 categorias
    	//Assert.assertEquals("Cantidad de categorias sge", 9, this.sge.cantidadDeCategorias());
		//Verifico correcta carga de categoria R5
    	Assert.assertEquals("Consumo maximo 'R5'", 500, this.R5.getConsumoMaximo());
		//Verifico los meses activos del administrador
    	Assert.assertEquals("Meses activo admin'", 0, this.administrador.cantidadDeMesesComoAdmin());
		//El correcto funcionamiento del la recategorización de clientes.
    	Assert.assertEquals("Recategorización cliente 1 'R1' ", 150, clientes.get(0).getCategoria().getConsumoMaximo());
    	Assert.assertEquals("Recategorización cliente 1 'R1' ", 150, clientes.get(1).getCategoria().getConsumoMaximo());
    }
}
