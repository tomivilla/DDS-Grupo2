package servlet;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Documento;
import persistencia.DBHelper;

public class InitHandler implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		DBHelper dbhelper = new DBHelper();

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

		dbhelper.cargarTransformadores("/transformadores.json");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
