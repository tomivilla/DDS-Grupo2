package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Dispositivo;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Documento;
import beans.Transformador;
import json_helper.Json_Helper;
import utils.HibernateUtils;

public class DBHelper {

	public void cargarUsuarioFromJson(String path) {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
    	Json_Helper jsonHelper = new Json_Helper();
    	try {
			clientes = jsonHelper.JsonToCliente(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (Cliente cliente : clientes) {
    		cliente.setCategoria(categoria);
			storeCliente(cliente);
		}
		
	}
	
	public void cargarTransformadores (String path) {
		List<Transformador> transformadores = new ArrayList<Transformador>();
		Json_Helper jsonHelper = new Json_Helper();
    	try {
			transformadores = jsonHelper.jsonToTransformadores(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (Transformador transformador : transformadores) {
			storeTransformador(transformador);
		}
	}
	
	public void cargarDispositivosEstandar(List<DispositivoEstandar> dispositivos, Long idUsuario) {
    	
    	for (DispositivoEstandar dispositivo : dispositivos) {
			addDispositivoACliente(dispositivo, idUsuario);
		}
	}
	
	public void cargarDispositivosInteligentes(List<DispositivoInteligente> dispositivos, Long idUsuario) {
    	
    	for (DispositivoInteligente dispositivo : dispositivos) {
			addDispositivoACliente(dispositivo, idUsuario);
		}
	}
	
	public void addDispositivoACliente(Dispositivo dispositivo, Long idUsuario) {
		Cliente cliente = getClienteById(idUsuario);
		
		if (dispositivo instanceof DispositivoEstandar) {
			DispositivoEstandar dispEst = (DispositivoEstandar) dispositivo;
			List<DispositivoEstandar> dispositivosAnteriores = cliente.getDispositivosEstandar();
			List<DispositivoEstandar> dispositivosNuevos = new ArrayList<DispositivoEstandar>();
			dispositivosNuevos.addAll(dispositivosAnteriores);
			dispositivosNuevos.add(dispEst);
			cliente.setDispositivosEstandar(dispositivosNuevos);
		}
		
		if (dispositivo instanceof DispositivoInteligente) {
			DispositivoInteligente dispInt = (DispositivoInteligente) dispositivo;
			List<DispositivoInteligente> dispositivosAnteriores = cliente.getDispositivosInteligentes();
			dispositivosAnteriores.add(dispInt);
			cliente.setDispositivosInteligentes(dispositivosAnteriores);
		}
		
	    modificarCliente(cliente);
	}

	public void crearCategorias() {
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
    	storeCategoria(categoria);		
	}

	public Cliente getClienteById (Long id) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        session.getTransaction().commit();
        return cliente;
    }
	
	public Dispositivo getDispositivoPosibleById (Long id) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Dispositivo disp = (Dispositivo) session.get(Dispositivo.class, id);
        session.getTransaction().commit();
        return disp;
	}
    
	public Long modificarCliente (Cliente cliente) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
        session.saveOrUpdate(cliente);
        session.getTransaction().commit();
        return cliente.getId();
    }
    
	public Long storeCliente(Cliente cliente) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        System.out.println("Insertado: "+cliente.getNombre());
        return cliente.getId();
	}
	
	public Long storeTransformador(Transformador transformador) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(transformador);
        session.getTransaction().commit();
        return transformador.getId();
	}

	public void crearDocumentos() {
		Documento doc = new Documento();
    	doc.setDescripcion("DNI");
    	storeDocu(doc);
    	
    	Documento doc2 = new Documento();
    	doc2.setDescripcion("CI");
    	storeDocu(doc2);
    	
    	Documento doc3 = new Documento();
    	doc3.setDescripcion("LE");
    	storeDocu(doc3);
    	
    	Documento doc4 = new Documento();
    	doc4.setDescripcion("LC");
    	storeDocu(doc4);
	}
	
	public void crearDispositivosPosibles() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Dispositivo disp1 = new Dispositivo(1L, "Aire acondicionado 3500 frigorias", 1.613, true, false);
		Dispositivo disp2 = new Dispositivo(2L, "Aire acondicionado 2200 frigorias", 1.013, true, true);
		Dispositivo disp3 = new Dispositivo(3L, "Televisor color de tubo fluorescente de 21\"", 0.075, false, false);
		Dispositivo disp4 = new Dispositivo(4L, "Televisor color de tubo fluorescente de 29\" a 34\"", 0.175, false, false);
		Dispositivo disp5 = new Dispositivo(5L, "Televisor LCD de 40\"", 0.18, false, false);
		Dispositivo disp6 = new Dispositivo(6L, "Televisor LED de 24\"", 0.04, true, true);
		Dispositivo disp7 = new Dispositivo(7L, "Televisor LED de 32\"", 0.055, true, true);
		Dispositivo disp8 = new Dispositivo(8L, "Televisor LED de 40\"", 0.08, true, true);
		Dispositivo disp9 = new Dispositivo(9L, "Heladera con freezer", 0.09, true, true);
		Dispositivo disp10 = new Dispositivo(10L, "Heladera sin freezer", 0.075, true, true);
		Dispositivo disp11 = new Dispositivo(11L, "Lavarropas automatico de 5kg con calentamiento de agua", 0.875, false, false);
		Dispositivo disp12 = new Dispositivo(12L, "Lavarropas automatico de 5kg", 0.175, true, true);
		Dispositivo disp13 = new Dispositivo(13L, "Lavarropas semi-automatico de 5kg", 0.1275, false, true);
		Dispositivo disp14 = new Dispositivo(14L, "Ventilador de pie", 0.09, false, true);
		Dispositivo disp15 = new Dispositivo(15L, "Ventilador de techo", 0.06, true, true);
		Dispositivo disp16 = new Dispositivo(16L, "Lampara halogena de 40 W", 0.04, true, false);
		Dispositivo disp17 = new Dispositivo(17L, "Lampara halogena de 60 W", 0.06, true, false);
		Dispositivo disp18 = new Dispositivo(18L, "Lampara halogena de 100 W", 0.15, true, false);
		Dispositivo disp19 = new Dispositivo(19L, "Lampara de 11 W", 0.011, true, true);
		Dispositivo disp20 = new Dispositivo(20L, "Lampara de 15 W", 0.015, true, true);
		Dispositivo disp21 = new Dispositivo(21L, "Lampara de 20 W", 0.02, true, true);
		Dispositivo disp22 = new Dispositivo(22L, "PC de escritorio", 0.4, true, true);
		Dispositivo disp23 = new Dispositivo(23L, "Microondas convencional", 0.64, false, true);
		Dispositivo disp24 = new Dispositivo(24L, "Plancha a vapor", 0.75, false, true);
		
		dispositivos.add(disp1);
		dispositivos.add(disp2);
		dispositivos.add(disp3);
		dispositivos.add(disp4);
		dispositivos.add(disp5);
		dispositivos.add(disp6);
		dispositivos.add(disp7);
		dispositivos.add(disp8);
		dispositivos.add(disp9);
		dispositivos.add(disp10);
		dispositivos.add(disp11);
		dispositivos.add(disp12);
		dispositivos.add(disp13);
		dispositivos.add(disp14);
		dispositivos.add(disp15);
		dispositivos.add(disp16);
		dispositivos.add(disp17);
		dispositivos.add(disp18);
		dispositivos.add(disp19);
		dispositivos.add(disp20);
		dispositivos.add(disp21);
		dispositivos.add(disp22);
		dispositivos.add(disp23);
		dispositivos.add(disp24);
		
		for (Dispositivo dispositivo : dispositivos) {
			storeDispositivoPosible(dispositivo);
		}
		
	}

	public void crearDispositivosInteligentes(List<DispositivoInteligente> dispositivos) {
				
		for (DispositivoInteligente dispositivo : dispositivos) {
			storeDispositivoInteligente(dispositivo);
		}
	}
	
	
	public Long storeDispositivoPosible(Dispositivo dispositivo) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(dispositivo);
        session.getTransaction().commit();
        return dispositivo.getId();		
	}

	public Long storeDispositivoInteligente(Dispositivo dispositivo) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(dispositivo);
        session.getTransaction().commit();
        return dispositivo.getId();		
	}
	
	
	
	public int storeDocu(Documento doc) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(doc);
        session.getTransaction().commit();
        System.out.println("Insertado: "+doc.getDescripcion());
        return doc.getId();		
	}
    
	public int storeCategoria(Categoria categoria) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(categoria);
        session.getTransaction().commit();
        return categoria.getId();		
	}

	public Long storeAdmin(Administrador admin) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        System.out.println("Insertado: "+admin.getNombre());
        return admin.getId();
    }

	public List<Administrador> listAdmins() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Administrador> result = (List<Administrador>)session.createQuery("from Administrador").list();
        session.getTransaction().commit();
        return result;
    }
	
	public List<Transformador> listTransformadores(){
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Transformador> result = (List<Transformador>)session.createQuery("from Transformador").list();
        session.getTransaction().commit();
        return result;
	}
	
	public List<Dispositivo> listDispositivosPosibles(){
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Dispositivo> result = (List<Dispositivo>)session.createQuery("from Dispositivo").list();
        session.getTransaction().commit();
        return result;
	}

	public Long storeDipositivoEstandar(DispositivoEstandar dispositivo) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(dispositivo);
        session.getTransaction().commit();
        return dispositivo.getId();		
	}
	
	public Administrador loginAdmin(String usr, String psw) {
		Administrador adm = new Administrador();
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from Administrador Adm where Adm.nombre_de_usuario = '"+usr+"'";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Administrador> result = (List<Administrador>) query.list();
		session.getTransaction().commit();
		
		if (!result.isEmpty() && result.get(0).getContrasena().equals(psw)) {
			adm = result.get(0);			
		}
		
		return adm;
	}

	public Cliente loginCliente(String usr, String psw) {
		Cliente cliente = new Cliente();
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from Cliente Clt where Clt.nombre_de_usuario = '"+usr+"'";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cliente> result = (List<Cliente>) query.list();
		session.getTransaction().commit();
		
		if (!result.isEmpty() && result.get(0).getContrasena().equals(psw)) {
			cliente = result.get(0);			
		}
		
		return cliente;
	}
	
	public List<Dispositivo> getDispositivosPorCliente (Long id){
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        session.getTransaction().commit();
        if (cliente.getDispositivosEstandar() != null) {
        	dispositivos.addAll(cliente.getDispositivosEstandar());			
		}
        if (cliente.getDispositivosInteligentes() != null) {
        	dispositivos.addAll(cliente.getDispositivosInteligentes());			
		}
        return dispositivos;
        
	}
}
