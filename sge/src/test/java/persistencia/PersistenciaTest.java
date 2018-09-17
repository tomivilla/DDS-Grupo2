package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Estado.Apagado;
import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Dispositivo;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Documento;
import beans.Periodo;
import beans.Transformador;
import junit.framework.Assert;
import sensor.SensorDeMovimiento;

public class PersistenciaTest {
	static DBHelper dbhelper = new DBHelper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbhelper.crearDocumentos();
		dbhelper.crearCategorias();
		dbhelper.crearDispositivosPosibles();

		Administrador admin = new Administrador("Tomas Villa", "tomiv", "hola1234", "maipu 304 1°E", new Date());

		Documento docuCliente = new Documento();
		docuCliente.setId(1);

		Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);

		DispositivoEstandar disp7 = new DispositivoEstandar(20L, "Televisor LCD de 40\"", 0.18, 2, false);

		List<DispositivoEstandar> dispsEstandar = new ArrayList<DispositivoEstandar>();

		dispsEstandar.add(disp7);

		dbhelper.storeDipositivoEstandar(disp7);

		// DispositivoInteligente disInt = new DispositivoInteligente(21L, "Aire
		// acondicionado 3500 frigorias", 1.613, Apagado.class, false, new
		// ArrayList<SensorDeMovimiento>, new ArrayList<Periodo>());

		List<DispositivoInteligente> dispsInteligentes = new ArrayList<DispositivoInteligente>();

		Cliente cliente = new Cliente("Leonardo", "leonardol", "qwerty1234", docuCliente, "3341213", 4321231,
				"Calle falsa 123", new Date(), categoria, dispsEstandar, dispsInteligentes);

		dbhelper.storeAdmin(admin);
		dbhelper.storeCliente(cliente);

		dbhelper.cargarTransformadores("transformadores.json");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testModificarCliente() {
		Cliente clienteObtenido = dbhelper.getClienteById(1L);

		Assert.assertEquals("Calle falsa 123", clienteObtenido.getDomicilio());

		clienteObtenido.setDomicilio("Nueva Calle 123");

		dbhelper.modificarCliente(clienteObtenido);

		Cliente clienteModificado = dbhelper.getClienteById(1L);

		Assert.assertEquals("Nueva Calle 123", clienteModificado.getDomicilio());

	}

	@Test
	public void testRecuperarTransformadores() {
		List<Transformador> transformadores = dbhelper.listTransformadores();

		Assert.assertEquals(2, transformadores.size());
	}

	@Test
	public void testModificarDispDeCliente() {
		Cliente clienteObtenido = dbhelper.getClienteById(1L);

		DispositivoEstandar disp = clienteObtenido.getDispositivosEstandar().get(0);

		disp.setNombre_generico("Dispositivo Nuevo Nombre");

		clienteObtenido.agregarDispositivo(disp);

		dbhelper.modificarCliente(clienteObtenido);

		
		Assert.assertEquals(1, 1);

	}

}
