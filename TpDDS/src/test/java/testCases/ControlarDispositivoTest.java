package testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.ActuadorEstrategiaComun;
import beans.DispositivoInteligente;
import beans.Fabricante;
import beans.FabricanteLG;

public class ControlarDispositivoTest {
	
	DispositivoInteligente dispositivo;
	ActuadorEstrategiaComun actuador;
	Fabricante fabricante;
	List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
	List<Fabricante> fabricantes = new ArrayList<Fabricante>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dispositivo = new DispositivoInteligente("Disp1", 12312, true, false, false, 1);
		actuador = new ActuadorEstrategiaComun(dispositivo);
		dispositivos.add(dispositivo);
		fabricante = new FabricanteLG(dispositivos, 12312);
		fabricantes.add(fabricante);
	}

	@After
	public void tearDown() throws Exception {
//		dispositivo = null;
//		actuador = null;
//		dispositivos = null;
//		fabricante = null;
//		fabricantes = null;
	}

	@Test
	public void test() {
		//Test para apagar dispositivo
		assertTrue(dispositivo.isEncendido());
		actuador.getMediador().setFabricantes(fabricantes);
		actuador.apagarDispositivo();
		assertTrue(dispositivo.isApagado());

	}

}
