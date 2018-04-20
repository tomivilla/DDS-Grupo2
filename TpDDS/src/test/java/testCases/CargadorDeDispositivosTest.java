package testCases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.Dispositivo;
import utils.CargarDispositivos;

public class CargadorDeDispositivosTest {
	
	private String ruta;
	List<Dispositivo> dispositivos;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ruta = "./src/main/resources/archivos/";
		dispositivos = null;
	}

	@After
	public void tearDown() throws Exception {
		ruta = null;
		dispositivos = null;
	}

	@Test
	public void test() {
		dispositivos = CargarDispositivos.cargarDispositivos(ruta + "JsonDispositivos");
		Assert.assertEquals(2, dispositivos.size());
	}

}
