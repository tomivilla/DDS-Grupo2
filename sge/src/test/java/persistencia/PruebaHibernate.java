package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Dispositivo;
import beans.Documento;
import beans.Transformador;
import json_helper.Json_Helper;
import utils.HibernateUtils;

public class PruebaHibernate {

    public static void main(String[] args) {
        new PruebaHibernate();
    }

    public PruebaHibernate() {
    	crearDocumentos();
    	crearCategorias();
    	cargarUsuarioFromJson("datos.json");

    	Administrador admin = new Administrador("Tomas Villa", "tomiv", "hola1234", "maipu 304 1°E", new Date());
    	
    	Documento docuCliente = new Documento();
    	docuCliente.setId(1);
    	
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
//    	
//    	Cliente cliente = new Cliente("Leonardo", "leonardol", "qwerty1234", docuCliente, "3341213", 4321231, "Calle falsa 123", new Date(), categoria, new ArrayList<Dispositivo>());
//    	
    	
    	
    	storeAdmin(admin);
//    	storeCliente(cliente);
//    	
    	Cliente clienteObtenido = getClienteById(1L);
    	clienteObtenido.setDomicilio("nueva calle 123");
    	
    	modificarCliente(clienteObtenido);
    	
    	Cliente clienteModificado = getClienteById(1L);
    	
    	if (clienteModificado.getDomicilio().equals("nueva calle 123")) {
			System.out.println("Lo modifico bien");
		}
    	
    	
    	List<Transformador> transformadores = new ArrayList<Transformador>();
    	try {
			transformadores = Json_Helper.jsonToTransformadores("transformadores.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (Transformador transformador : transformadores) {
			storeTransformador(transformador);
		}
    	
    	
    	
//        listAdmins();
        HibernateUtils.getSessionFactory().close();
    }

    
    private void cargarUsuarioFromJson(String path) {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
    	try {
			clientes = Json_Helper.JsonToCliente(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (Cliente cliente : clientes) {
    		cliente.setCategoria(categoria);
			storeCliente(cliente);
		}
		
	}

	private void crearCategorias() {
    	Categoria categoria = new Categoria(1, 100, 2000, 20.0, 32.5);
    	storeCategoria(categoria);		
	}

	private Cliente getClienteById (Long id) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        session.getTransaction().commit();
        return cliente;
    }
    
    private Long modificarCliente (Cliente cliente) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
        session.update(cliente);
        session.getTransaction().commit();
        return cliente.getId();
    }
    
	private Long storeCliente(Cliente cliente) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        System.out.println("Insertado: "+cliente.getNombre());
        return cliente.getId();
	}
	
	private Long storeTransformador(Transformador transformador) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(transformador);
        session.getTransaction().commit();
        return transformador.getId();
	}

	private void crearDocumentos() {
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

    private int storeDocu(Documento doc) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(doc);
        session.getTransaction().commit();
        System.out.println("Insertado: "+doc.getDescripcion());
        return doc.getId();		
	}
    
    private int storeCategoria(Categoria categoria) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(categoria);
        session.getTransaction().commit();
        return categoria.getId();		
	}

	private Long storeAdmin(Administrador admin) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        System.out.println("Insertado: "+admin.getNombre());
        return admin.getId();
    }

    private List<Administrador> listAdmins() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Administrador> result = (List<Administrador>)session.createQuery("from Administrador").list();
        session.getTransaction().commit();
        for (Administrador admin : result) {
            System.out.println("Leido: "+admin.getNombre());
        }
        return result;
    }
}
