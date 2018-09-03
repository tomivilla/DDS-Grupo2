package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import beans.Administrador;
import beans.Categoria;
import beans.Cliente;
import beans.Dispositivo;
import beans.Documento;
import utils.HibernateUtils;

public class PruebaHibernate {

    public static void main(String[] args) {
        new PruebaHibernate();
    }

    public PruebaHibernate() {
    	crearDocumentos();

    	Administrador admin = new Administrador("Tomas Villa", "tomiv", "hola1234", "maipu 304 1°E", new Date());
    	
    	Cliente cliente = new Cliente("Leonardo", "leonardol", "qwerty1234", 1, "3341213", 4321231, "Calle falsa 123", new Date(), new Categoria(), new ArrayList<Dispositivo>());
    	
    	storeAdmin(admin);
    	storeCliente(cliente);
        listAdmins();
        HibernateUtils.getSessionFactory().close();
    }

	private Long storeCliente(Cliente cliente) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        System.out.println("Insertado: "+cliente.getNombre());
        return cliente.getId();
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
