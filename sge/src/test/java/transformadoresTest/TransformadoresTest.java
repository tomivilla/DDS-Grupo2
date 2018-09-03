package transformadoresTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import beans.Transformador;
import beans.Zona;
import json_helper.Json_Helper;

public class TransformadoresTest {
	
	private List<Transformador> transformadores;
	private List<Zona> zonas;

	@Before
    public void setup() throws IOException{
		transformadores = new ArrayList<Transformador>();
		transformadores = Json_Helper.jsonToTransformadores("transformadores.json");
		
		zonas = new ArrayList<Zona>();
		zonas = Json_Helper.jsonToZonas("zonas.json");
	}
	
	@Test
    public void debeDevolverId() {    
    	assertEquals(2,transformadores.get(1).getId(),0.0);
    }
	
	@Test
    public void debeCargarZonasYAgregarTransformadores() {  
		
		for (Zona zona : zonas) {
			for (Transformador transformador : transformadores) {
				if (transformador.getZona()==zona.getId()) {
					zona.agregarTransformador(transformador);
				}
			}
		}
		
    	assertEquals(2,zonas.get(1).getId(),0.0);
    	assertEquals(2,zonas.get(1).getTransformadores().get(0).getId(),0.0);
    }
}
