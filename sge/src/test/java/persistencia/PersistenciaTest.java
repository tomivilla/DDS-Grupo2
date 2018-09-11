package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Dispositivo;
import beans.Documento;
import beans.Transformador;
import junit.framework.Assert;

public class PersistenciaTest {
	DBHelper dbhelper = new DBHelper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		dbhelper.crearDocumentos();
		dbhelper.crearCategorias();
		
		Administrador admin = new Administrador("Tomas Villa", "tomiv", "hola1234", "maipu 304 1°E", new Date());
		
		Documento docuCliente = new Documento();
    	docuCliente.setId(1);
    	
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
    	
    	Cliente cliente = new Cliente("Leonardo", "leonardol", "qwerty1234", docuCliente, "3341213", 4321231, "Calle falsa 123", new Date(), categoria, new ArrayList<Dispositivo>());
    	
    	dbhelper.storeAdmin(admin);
    	dbhelper.storeCliente(cliente);
    	
		dbhelper.cargarTransformadores("transformadores.json");
		
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

}
