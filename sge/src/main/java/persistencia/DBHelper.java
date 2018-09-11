package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Documento;
import beans.Transformador;
import json_helper.Json_Helper;
import utils.HibernateUtils;

public class DBHelper {

	public void cargarUsuarioFromJson(String path) {
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
	
	public void cargarTransformadores (String path) {
		List<Transformador> transformadores = new ArrayList<Transformador>();
    	try {
			transformadores = Json_Helper.jsonToTransformadores(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (Transformador transformador : transformadores) {
			storeTransformador(transformador);
		}
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
    
	public Long modificarCliente (Cliente cliente) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
        session.update(cliente);
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
        List<Administrador> result = (List<Administrador>)session.createQuery("from Administrador").list();
        session.getTransaction().commit();
        return result;
    }
	
	public List<Transformador> listTransformadores(){
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Transformador> result = (List<Transformador>)session.createQuery("from Transformador").list();
        session.getTransaction().commit();
        return result;
	}
	
	
}
