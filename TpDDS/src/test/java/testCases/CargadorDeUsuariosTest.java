package testCases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.Usuario;
import utils.CargarUsuarios;

public class CargadorDeUsuariosTest {
	
	private String ruta;
	List<Usuario> usuarios;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ruta = "./src/main/resources/archivos/";
		usuarios = null;
	}

	@After
	public void tearDown() throws Exception {
		ruta = null;
		usuarios = null;
	}

	@Test
	public void test() {
		usuarios = CargarUsuarios.cargarUsuarios(ruta+"JsonUsuarios");
		Assert.assertEquals(2, usuarios.size());
	}

}
