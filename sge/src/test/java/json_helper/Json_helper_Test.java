package json_helper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import beans.Cliente;

public class Json_helper_Test {
	
    @Test
    public void debeDevolverJSONEnUnObjeto() throws IOException {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	clientes = Json_Helper.JsonToCliente("datos.json");
        assertEquals("Lista de clientes",3, clientes.size());
    }
    
}
