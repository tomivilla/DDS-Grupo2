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
	private List<Dispositivo> dispositivos;
	private long dni1;
	private long dni2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dni1 = 38132912;
		dni2 = 38132432;
		dispositivos = null;
	}

	@After
	public void tearDown() throws Exception {
		ruta = null;
		dispositivos = null;
	}

	@Test
	public void test() {
		dispositivos = CargarDispositivos.cargarDispositivos(dni1);
		Assert.assertEquals(2, dispositivos.size());
	}

}
