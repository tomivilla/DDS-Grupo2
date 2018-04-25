package testCases;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.Administrador;
import beans.Cliente;
import beans.UsuariosResponse;
import utils.CargarDispositivos;
import utils.CargarUsuarios;

public class CargadorDeUsuariosTest {
	
	private String ruta;
	UsuariosResponse usuarios;
	List<Administrador> administradores;
	List<Cliente> clientes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ruta = "./src/main/resources/archivos/";
		usuarios = new UsuariosResponse();
		administradores = new ArrayList<Administrador>();
		clientes = new ArrayList<Cliente>();
	}

	@After
	public void tearDown() throws Exception {
		ruta = null;
		usuarios = null;
	}

	@Test
	public void test() {
		usuarios = CargarUsuarios.cargarUsuarios(ruta+"JsonUsuarios");
		
		administradores.addAll(usuarios.getAdministradores());
		clientes.addAll(usuarios.getClientes());
		
		for (Cliente cliente : clientes) {
			cliente.setDispositivos(CargarDispositivos.cargarDispositivos(cliente.getDni()));
		}
		
		Assert.assertEquals(2, administradores.size());
		Assert.assertEquals(2, clientes.size());
	}

}
